package view;/**
 * Created by v21k on 23.02.17.
 */

import controller.IService;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFXView extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome to our store!");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Text scenetitle = new Text("Welcome!");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User name");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1,1);

        Label pw = new Label("Password");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1,2);


        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actionfield = new Text();
        actionfield.setId("actionfield");
        grid.add(actionfield, 1, 6);

        btn.setOnAction(EventHandler -> {
                actionfield.setFill(Color.FIREBRICK);
                try {
                    IService iService = ViewUtils.load();
                    String token = iService.logIn(userTextField.getText(), pwBox.getText());
                    actionfield.setText("Done! your token is : " + token);
                } catch (IOException | InvalidInputParameters | InvalidIdException e) {
                    e.printStackTrace();
                }
        });

        Scene scene = new Scene(grid, 500, 600);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(JavaFXView.class.getResource("JavaFXLogin.css").toExternalForm());
        primaryStage.show();
    }
}
