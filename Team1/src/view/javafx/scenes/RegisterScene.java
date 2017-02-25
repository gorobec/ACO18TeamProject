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
public class RegisterScene {

    public static Scene registerScene(IService iService) {
        Text nameText = new Text("Username");
        Text textPass = new Text("Password");
        Text emailText = new Text("Email");
        Text result = new Text();

        TextField nameField = new TextField();
        PasswordField passwordField = new PasswordField();
        TextField emailField = new TextField();

        Button submit = new Button("Submit");
        Button clear = new Button("Clear");
        Button back = new Button("Back");

        buttonsSet(iService, result, nameField, passwordField, emailField, submit, clear, back);

        GridPane gridPane = buildGridPane(nameText, textPass, emailText, result,
                nameField, passwordField, emailField,
                submit, clear, back);

        return new Scene(gridPane);
    }

    private static GridPane buildGridPane(Text nameText, Text textPass, Text emailText, Text result,
                                          TextField nameField, PasswordField passwordField, TextField emailField,
                                          Button submit, Button clear, Button back) {
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
        gridPane.add(textPass, 0, 1);
        gridPane.add(result, 0, 5);

        gridPane.add(passwordField, 1, 1);
        gridPane.add(emailText, 0, 2);
        gridPane.add(emailField, 1, 2);

        gridPane.add(submit, 0, 3);
        gridPane.add(clear, 1, 3);
        gridPane.add(back, 2, 3);

        //Styling nodes
        submit.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        clear.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        gridPane.setStyle("-fx-background-color: BEIGE;");
        return gridPane;
    }

    private static void buttonsSet(IService iService, Text result,
                                   TextField nameField, PasswordField passwordField, TextField emailField,
                                   Button submit, Button clear, Button back) {

        back.setOnAction(event -> ViewJavaFX.stage.setScene(LoginScene.loginScene(iService)));

        clear.setOnAction(event -> {
            nameField.clear();
            passwordField.clear();
            emailField.clear();
        });

        submit.setOnAction(event -> {
            try {
                iService.signUp(nameField.getText(), passwordField.getText(), emailField.getText());
                result.setText("DONE! Click 'back' to sign in");
            } catch (InvalidInputParameters | InvalidIdException e) {
                result.setText(e.getMessage());
            }
        });
    }
}
