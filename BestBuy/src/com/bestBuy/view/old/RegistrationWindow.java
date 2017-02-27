package com.bestBuy.view.old;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.IllegalCreditCardFormatException;
import com.bestBuy.exceptions.IllegalEmailFormatException;
import com.bestBuy.exceptions.IllegalPasswordFormatException;
import com.bestBuy.exceptions.UserWithSuchEmailRegisteredException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RegistrationWindow extends JFrame {

    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField addressField;
    private JTextField creditCardField;

    private String loginString;

    public RegistrationWindow(IStore service) {

        String infoStr = "Enter registration data";

        setTitle("Registration Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(500, 250);

        Box box0 = Box.createHorizontalBox();
        JLabel infoLabel = new JLabel("info: " + infoStr + "");
        box0.add(infoLabel);
        box0.add(Box.createHorizontalGlue());

        Box box1 = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Email:");
        loginField = new JTextField(25);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField);

        Box box2 = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("password:");
        passwordField = new JPasswordField(25);
        box2.add(passwordLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(passwordField);

        Box box3 = Box.createHorizontalBox();
        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField(25);
        box3.add(addressLabel);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(addressField);

        Box box4 = Box.createHorizontalBox();
        JLabel creditCardLable = new JLabel("Credit Card №:");
        creditCardField = new JTextField(25);
        box4.add(creditCardLable);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(creditCardField);

        Box box5 = Box.createHorizontalBox();
        JButton apply = new JButton("Apply");

        apply.addActionListener(e -> {
            try {
                service.registerUser(loginField.getText(), passwordField.getText(), addressField.getText(), creditCardField.getText());
                loginString = loginField.getText();
                service.saveDatabase();
                JOptionPane.showMessageDialog(null, "You have registered now!!!\n" +
                                " You can log in, using your login and password!!!", "Congratulation!",
                        JOptionPane.INFORMATION_MESSAGE);
                new LoginWindow(service);
                dispose();
            } catch (IllegalEmailFormatException emailEx) {
                JOptionPane.showMessageDialog(null, "Illegal Email format",
                        "Warning", JOptionPane.WARNING_MESSAGE);

            } catch (UserWithSuchEmailRegisteredException loginEx) {
                JOptionPane.showMessageDialog(null, "User with such login is already registered",
                        "Warning", JOptionPane.WARNING_MESSAGE);

            } catch (IllegalPasswordFormatException pasEx) {
                JOptionPane.showMessageDialog(null, "Your password should have 6 chars minimum ",
                        "Warning", JOptionPane.WARNING_MESSAGE);

            } catch (IllegalCreditCardFormatException cardEx) {
                JOptionPane.showMessageDialog(null, "Card with such number don't exists",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> dispose());

        box5.add(Box.createHorizontalGlue());
        box5.add(apply);
        box5.add(Box.createHorizontalStrut(12));
        box5.add(cancel);

        loginLabel.setPreferredSize(creditCardLable.getPreferredSize());
        passwordLabel.setPreferredSize(creditCardLable.getPreferredSize());
        addressLabel.setPreferredSize(creditCardLable.getPreferredSize());

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box0);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box4);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box5);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setVisible(true);
    }
}
