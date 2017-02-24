package view;

<<<<<<< HEAD
import controller.Service;
=======
import controller.IStore;
>>>>>>> c76d27dd9d564296fd56155b5fa253888c031950

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class CartWindow extends JFrame {

    public CartWindow(Service service) {

        setTitle("Cart");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocation(300, 150);

        Box box1 = Box.createHorizontalBox();
        String ticketId = "";
        JLabel labelTicketId = new JLabel("Ticket ID: " + ticketId);
        double price = 0;
        JLabel labelPrice = new JLabel("Total price : " + price);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(labelTicketId);
        box1.add(Box.createHorizontalGlue());
        box1.add(labelPrice);
        box1.add(Box.createHorizontalStrut(10));

        Box box2 = Box.createHorizontalBox();
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setMinimumSize(scrollPane.getPreferredSize());
        Dimension scrollDim = new Dimension(500, 400);
        scrollPane.setPreferredSize(scrollDim);
        scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        box2.add(Box.createHorizontalStrut(5));
        box2.add(scrollPane);

        Box box2_1 = Box.createVerticalBox();

        JButton addProdBut = new JButton("Add product");
        JButton removeProdBut = new JButton("Remove product");
        JButton clearProdBut = new JButton("Clear cart");
        JButton buyBut = new JButton("Buy");
        JButton backToShopBut = new JButton("Back to Shop");
        Dimension butCatDim = new Dimension(100, 25);
        addProdBut.setPreferredSize(butCatDim);
        removeProdBut.setSize(butCatDim);
        clearProdBut.setSize(butCatDim);
        buyBut.setSize(butCatDim);
        backToShopBut.setSize(butCatDim);
        String info = "Choose action";
        JTextArea textAreaHelp = new JTextArea(info);
        textArea.setPreferredSize(removeProdBut.getPreferredSize());
        JPanel butPanel = new JPanel(new GridLayout(6, 1, 20, 20));
        butPanel.add(textAreaHelp);
        butPanel.add(addProdBut);
        butPanel.add(removeProdBut);
        butPanel.add(clearProdBut);
        butPanel.add(buyBut);
        butPanel.add(backToShopBut);
        box2_1.add(butPanel);
        box2.add(Box.createHorizontalStrut(5));
        box2.add(box2_1);

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(box2);
        setContentPane(mainBox);

        setResizable(false);
        setVisible(true);

    }
}
