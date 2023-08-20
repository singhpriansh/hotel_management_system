package com.hotel.management.system;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

public class Login extends JFrame{
  Login () {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel user = new JLabel("Username");
    user.setBounds(40, 20, 100, 30);
    add(user);

    JTextField username = new JTextField();
    username.setBounds(150, 20, 150, 30);
    add(username);

    JLabel pass = new JLabel("Password");
    pass.setBounds(40, 70, 100, 30);
    add(pass);

    JTextField password = new JTextField();
    password.setBounds(150, 70, 150, 30);
    add(password);

    JButton login = new JButton("Login");
    login.setBounds(40,150,100,30);
    login.setBackground(Color.WHITE);
    login.setForeground(Color.BLACK);
    add(login);

    JButton cancel = new JButton("Cancel");
    cancel.setBounds(180,150,100,30);
    cancel.setBackground(Color.WHITE);
    cancel.setForeground(Color.BLACK);
    add(cancel);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
    Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(320,20,210,210);
    add(image);

    setBounds(500,200,600,300);
    setVisible(true);
  }
  public static void main(String[] args) {
    new Login();
  }
}
