package view.javafx;/**
 * Created by v21k on 24.02.17.
 */

import controller.IService;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.ViewUtils;
import view.javafx.scenes.LoginScene;

import java.io.IOException;

public class ViewJavaFX extends Application {
    public static Stage stage;
    public static String token;

    private static IService iService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        iService = ViewUtils.load();

        primaryStage.setScene(LoginScene.loginScene(iService));
        primaryStage.show();
    }
}
