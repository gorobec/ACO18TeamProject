package view.javafx.scenes;

import controller.IService;
import exception.InvalidInputParameters;
import exception.InvalidTokenException;
import exception.NoSuchProductException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Address;
import model.BankCard;
import model.Product;
import view.javafx.ViewJavaFX;

import java.time.YearMonth;
import java.util.List;

/**
 * Created by v21k on 24.02.17.
 */
public class BuyScene {
    public static Scene buyScene(IService iService) {
        Text city = new Text("City");
        Text street = new Text("street");
        Text houseNumber = new Text("House number");
        Text card = new Text("card");
        Text cvv2 = new Text("cvv2");
        Text validUntil = new Text("valid until (xxxx-xx format)");
        Text productId = new Text("product ID");
        Text resultText = new Text();

        TextField cityField = new TextField();
        TextField streetField = new TextField();
        TextField houseNumberField = new TextField();
        TextField cardField = new TextField();
        PasswordField cvv2Field = new PasswordField();
        TextField validUntilField = new TextField();
        TextField productIdField = new TextField();

        Button buy = new Button("SHUT UP AND TAKE MY MONEY!!!11");
        Button back = new Button("Back");
        back.setOnAction(event -> {
            ViewJavaFX.stage.setScene(StoreMainScene.mainScene(iService));
        });


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600, 400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(city, 0, 0);
        gridPane.add(cityField, 1, 0);
        gridPane.add(street, 0, 1);
        gridPane.add(streetField, 1, 1);
        gridPane.add(houseNumber, 0, 2);
        gridPane.add(houseNumberField, 1, 2);
        gridPane.add(card, 0, 3);
        gridPane.add(cardField, 1, 3);
        gridPane.add(cvv2, 0, 4);
        gridPane.add(cvv2Field, 1, 4);
        gridPane.add(validUntil, 0, 5);
        gridPane.add(validUntilField, 1, 5);
        gridPane.add(productId, 0, 6);
        gridPane.add(productIdField, 1, 6);
        gridPane.add(back, 0, 7);
        gridPane.add(buy, 1, 7);
        gridPane.add(resultText, 0, 8);

        buy.setOnAction(event -> {
            try {
                int result = iService.buy(iService.getUserByToken(ViewJavaFX.token).getId(),
                        Integer.parseInt(productIdField.getText()),
                        new Address(cityField.getText(), streetField.getText(), Integer.parseInt(houseNumberField.getText())),
                        new BankCard(cardField.getText(), Integer.parseInt(cvv2Field.getText()),
                                YearMonth.parse(validUntilField.getText())));
                resultText.setText("Done! Your ticket # is " + result);
            } catch (NoSuchProductException | InvalidTokenException | InvalidInputParameters e) {
                resultText.setText(e.getMessage());
            }
        });


        gridPane.setStyle("-fx-background-color: BEIGE;");


        return new Scene(gridPane);
    }
}


