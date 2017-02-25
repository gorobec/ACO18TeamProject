package view.javafx.scenes;

import controller.IService;
import exception.InvalidIdException;
import exception.UserLoginException;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Product;
import view.javafx.ViewJavaFX;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

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

        TextField idFieldProduct = new TextField("enter id");
        TextField idFieldTicket = new TextField("enter id");
        idFieldProduct.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> idFieldProduct.clear());
        idFieldTicket.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> idFieldTicket.clear());
        Text allProducts = new Text();
        Text idResult = new Text();

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1000, 600);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(showProductById, 0, 0);
        gridPane.add(showTicketById, 0, 1);
        gridPane.add(idFieldProduct, 1, 0);
        gridPane.add(idFieldTicket, 1, 1);
        gridPane.add(showAllProducts, 0, 2);
        gridPane.add(buy, 1, 2);
        gridPane.add(idResult, 0, 3);
        gridPane.add(allProducts, 0, 4);
        gridPane.add(logOut, 0, 5);
        gridPane.setStyle("-fx-background-color: BEIGE;");

        showProductById.setOnAction(event -> {
            try {
                String prodInfo = iService.getProductById(Integer.parseInt(idFieldProduct.getText())).toString();
                idResult.setText(prodInfo);
            } catch (InvalidIdException e) {
                idResult.setText(e.getMessage());
            }
        });

        showTicketById.setOnAction(event -> {
            try {
                String ticketInfo = iService.getTicketById(Integer.parseInt(idFieldTicket.getText()), ViewJavaFX.token)
                        .toString();
                idResult.setText(ticketInfo);
            } catch (InvalidIdException | UserLoginException e) {
                idResult.setText(e.getMessage());
            }
        });

        showAllProducts.setOnAction(event -> {
            String res = iService.getProducts().stream().map(Object::toString).collect(Collectors.joining());
            allProducts.setText(res);
        });

        buy.setOnAction(event -> {
            ViewJavaFX.stage.setScene(BuyScene.buyScene(iService));
        });

        logOut.setOnAction(event -> {
            ViewJavaFX.stage.setScene(LoginScene.loginScene(iService));
        });

        return new Scene(gridPane, 1000, 600);
    }
}
