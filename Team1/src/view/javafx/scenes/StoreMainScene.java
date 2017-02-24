package view.javafx.scenes;

import controller.IService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Product;
import view.javafx.ViewJavaFX;

import java.awt.*;
import java.util.List;

/**
 * Created by v21k on 24.02.17.
 */
public class StoreMainScene {
    public static Scene mainScene(IService iService) {
        Button showAllProducts = new Button("Show all products");
        Button showProductById = new Button("Show product by id");
        Button showTicketById = new Button("Show ticket by id");
        Button buy = new Button("BUY!");
        Button getId = new Button("Go");
        Button logOut = new Button("Log out");

        TextField textField = new TextField("enter id");
        Text allProducts = new Text();
        Text idResult = new Text();

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600, 400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(showAllProducts, 0, 0);
        gridPane.add(showProductById, 1, 0);
        gridPane.add(showTicketById, 0, 1);
        gridPane.add(buy, 1, 1);
        gridPane.add(allProducts, 0, 2);
        gridPane.add(logOut, 0, 3);
        gridPane.setStyle("-fx-background-color: BEIGE;");

        showAllProducts.setOnAction(event -> {
            List<Product> productList = iService.getProducts();
            allProducts.setText(productList.toString());
        });

        buy.setOnAction(event -> {
            ViewJavaFX.stage.setScene(BuyScene.buyScene(iService));
        });

        logOut.setOnAction(event -> {
            ViewJavaFX.stage.setScene(LoginScene.loginScene(iService));
        });

        return new Scene(gridPane);
    }
}
