package view;

import controller.BestBuy;
import controller.IStore;
import exceptions.IllegalPasswordException;
import exceptions.NoSuchUserException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginWindow extends JFrame {

    private JTextField loginField;
    private JPasswordField passwordField;

    private String loginString;

    public LoginWindow(IStore service) {
        String infoStr = "SIGN IN";

        setTitle("Login Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500, 250);

        Box box0 = Box.createHorizontalBox();
        JLabel infoLabel = new JLabel("info: " + infoStr + "");
        box0.add(infoLabel);
        box0.add(Box.createHorizontalGlue());

        Box box1 = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Email:");
        loginField = new JTextField(15);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField);

        Box box2 = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("password:");
        passwordField = new JPasswordField(15);
        box2.add(passwordLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(passwordField);

        Box box3 = Box.createHorizontalBox();
        JButton registration = new JButton("Registration");
        registration.addActionListener(e -> {
            new RegistrationWindow(service);
            dispose();
        });
        JButton ok = new JButton("OK");
        ok.addActionListener(e -> {
            loginString = loginField.getText();
            try {
                service.checkLoginAndPassword(loginField.getText(), passwordField.getText());
                new ViewBestBuy(service);
                dispose();
            } catch (NoSuchUserException e1) {
                JOptionPane.showMessageDialog(null, "User with such login is Not registered",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            } catch (IllegalPasswordException e1) {
                JOptionPane.showMessageDialog(null, "Wrong password",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }

        });
        JButton cancel = new JButton("Cancel");

        cancel.addActionListener(e -> dispose());

        box3.add(Box.createHorizontalGlue());
        box3.add(registration);
        box3.add(Box.createHorizontalStrut(12));
        box3.add(ok);
        box3.add(Box.createHorizontalStrut(12));
        box3.add(cancel);

        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box0);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setVisible(true);
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
}