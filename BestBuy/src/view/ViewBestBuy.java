package view;

import controller.Service;
import exceptions.NoSuchProductException;
import exceptions.NoSuchTicketException;

import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class ViewBestBuy extends JFrame {

    public ViewBestBuy(Service service) {

        Dimension sizeWindow = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(sizeWindow);
        setTitle("Best Buy SHOP");

        Container container = getContentPane();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JLabel label = new JLabel("Здесь может быть ваша реклама");
        Dimension labDim = new Dimension(1000, 40);
        label.setPreferredSize(labDim);
        topPanel.add(label);
        JButton cartButton = new JButton("Cart");
        Dimension butlDim = new Dimension(100, 50);
        cartButton.setPreferredSize(butlDim);

        cartButton.addActionListener(e -> new CartWindow(service));
        topPanel.add(cartButton);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JLabel labelBot = new JLabel("We can write some important information here");
        Dimension labDim2 = new Dimension(1000, 100);
        label.setPreferredSize(labDim2);
        bottomPanel.setPreferredSize(labDim2);
        bottomPanel.add(labelBot);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setMinimumSize(scrollPane.getPreferredSize());
        Dimension scrollDim = new Dimension(700, 450);
        scrollPane.setPreferredSize(scrollDim);
        scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(BorderFactory.createTitledBorder("Info:"));
        Dimension leftPaneldim = new Dimension(750, 480);
        leftPanel.setPreferredSize(leftPaneldim);
        leftPanel.add(scrollPane);
        mainPanel.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Actions:"));
        Dimension rightPaneldim = new Dimension(550, 480);
        rightPanel.setPreferredSize(rightPaneldim);

        JPanel rightTopPanel = new JPanel();
        Dimension rightTopPaneldim = new Dimension(430, 220);
        rightTopPanel.setPreferredSize(rightTopPaneldim);

        JButton getProductByIdBut = new JButton("Show product by ID");
        Dimension butDim3 = new Dimension(300, 50);
        getProductByIdBut.setPreferredSize(butDim3);
        rightTopPanel.add(getProductByIdBut);

        JTextField productIdField = new JTextField();
        Dimension fieldIdDim = new Dimension(100, 50);
        productIdField.setPreferredSize(fieldIdDim);
        rightTopPanel.add(productIdField);

        getProductByIdBut.addActionListener(event -> {
            int idProd = Integer.parseInt(productIdField.getText());
            String productStr = null;
            try {
                productStr = service.printProduct(service.getProductById(idProd));
            } catch (NoSuchProductException e) {
                e.printStackTrace();
            }
            textArea.setText(productStr);
        });

        JButton getTicketByIdBut = new JButton("Show ticket by ID");
        getTicketByIdBut.setPreferredSize(butDim3);
        rightTopPanel.add(getTicketByIdBut);
        JTextField ticketIdField = new JTextField();
        ticketIdField.setPreferredSize(fieldIdDim);
        rightTopPanel.add(ticketIdField);

        getTicketByIdBut.addActionListener(event -> {
            int idTick = Integer.parseInt(ticketIdField.getText());
            String ticketStr = null;
            try {
                ticketStr = service.printTicketById(service.showTicketById(idTick));
            } catch (NoSuchTicketException e) {
                e.printStackTrace();
            }
            textArea.setText(ticketStr);
        });

        JButton buy = new JButton("ADD product to Cart by ID");
        buy.setPreferredSize(butDim3);
        rightTopPanel.add(buy);
        JTextField addToCart = new JTextField();
        addToCart.setPreferredSize(fieldIdDim);
        rightTopPanel.add(buy);
        rightTopPanel.add(addToCart);

        JPanel rightBottomPanel = new JPanel();
        rightBottomPanel.setPreferredSize(rightTopPaneldim);


        JButton showProducts = new JButton("Show all products in catalog");
        Dimension butDim2 = new Dimension(400, 50);
        showProducts.setPreferredSize(butDim2);
        rightBottomPanel.add(showProducts);

        showProducts.addActionListener(event -> {
            String productStr = service.printAllProducts();
            textArea.setText(productStr);
        });


        rightPanel.add(rightTopPanel, BorderLayout.NORTH);
        rightPanel.add(rightBottomPanel, BorderLayout.CENTER);

        mainPanel.add(rightPanel, BorderLayout.EAST);

        container.add(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

}
