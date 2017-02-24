package view.javafx.scenes;

import controller.IService;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

/**
 * Created by v21k on 24.02.17.
 */
public class StoreScene {

    public static Scene storeScene(IService iService) {
        GridPane gp = new GridPane();
        return new Scene(gp);
    }
}
