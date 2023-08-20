package com.hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

  JTextField username;
  JPasswordField password;
  JButton login, cancel;

  Login () {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel user = new JLabel("Username");
    user.setBounds(40, 20, 100, 30);
    add(user);

    username = new JTextField();
    username.setBounds(150, 20, 150, 30);
    add(username);

    JLabel pass = new JLabel("Password");
    pass.setBounds(40, 70, 100, 30);
    add(pass);

    password = new JPasswordField();
    password.setBounds(150, 70, 150, 30);
    add(password);

    login = new JButton("Login");
    login.setBounds(40,150,100,30);
    login.setBackground(Color.WHITE);
    login.setForeground(Color.BLACK);
    login.addActionListener(this);
    add(login);

    cancel = new JButton("Cancel");
    cancel.setBounds(180,150,100,30);
    cancel.setBackground(Color.WHITE);
    cancel.setForeground(Color.BLACK);
    cancel.addActionListener(this);
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

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == login) {
      String user = username.getText();
      String pass = String.valueOf(password.getPassword());
      try {
        Connect connect = new Connect();
        String query = "select * from login where username = '" + user + "' and password = '" + pass+ "'";
        ResultSet rs = connect.s.executeQuery(query);
        if (rs.next()) {
          setVisible(false);
          new Dashboard();
        } else {
          JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (ae.getSource() == cancel) {
      setVisible(false);
    }
    // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
  }
}
