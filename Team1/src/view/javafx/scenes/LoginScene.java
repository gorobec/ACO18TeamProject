package view.javafx.scenes;

import controller.IService;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import view.javafx.ViewJavaFX;

/**
 * Created by v21k on 24.02.17.
 */
public class LoginScene {


    public static Scene loginScene(IService iService) {
        Text nameText = new Text("Username");
        Text textPass = new Text("Password");
        Text result = new Text();

        TextField nameField = new TextField();
        PasswordField passwordField = new PasswordField();

        Button submit = new Button("Submit");
        Button register = new Button("register");
        Button clear = new Button("Clear");

        buttonsSet(iService, result, nameField, passwordField, submit, register, clear);
        GridPane gridPane = buildGridPane(result, nameText, textPass,
                nameField, passwordField,
                submit, register, clear);

        return new Scene(gridPane);
    }

    private static void buttonsSet(IService iService, Text result, TextField nameField, PasswordField passwordField, Button submit, Button register, Button clear) {

        submit.setOnAction(event -> {
            try {
                String s = iService.logIn(nameField.getText(), passwordField.getText());
                if (s.length() > 0) {
                    ViewJavaFX.token = s;
                    ViewJavaFX.stage.setScene(StoreMainScene.mainScene(iService));
                }
            } catch (InvalidIdException | InvalidInputParameters e) {
                result.setText(e.getMessage());
            }
        });

        register.setOnAction(event -> ViewJavaFX.stage.setScene(RegisterScene.registerScene(iService)));

        clear.setOnAction(event -> {
            nameField.clear();
            passwordField.clear();
        });
    }

    private static GridPane buildGridPane(Text result, Text nameText, Text textPass,
                                          TextField nameField, PasswordField passwordField,
                                          Button submit, Button register, Button clear) {
        //Creating a Grid Pane
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600, 400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        gridPane.add(nameText, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(result, 0, 3);

        gridPane.add(textPass, 0, 1);
        gridPane.add(passwordField, 1, 1);

        gridPane.add(submit, 0, 2);
        gridPane.add(clear, 1, 2);
        gridPane.add(register, 2, 2);

        //Styling nodes
        submit.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        clear.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        gridPane.setStyle("-fx-background-color: BEIGE;");
        return gridPane;
    }
}
