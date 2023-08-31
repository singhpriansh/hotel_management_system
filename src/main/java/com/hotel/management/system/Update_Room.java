package com.hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Update_Room extends JFrame implements ActionListener {

  Choice customer;
  JTextField tfroom, tf_available, tf_status ;
  JButton check, update, back;
  Date date = new Date();

  Update_Room() {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel text = new JLabel("Update Room Status");
    text.setFont(new Font("Comfortaa", Font.PLAIN, 20));
    text.setForeground(Color.BLUE);
    text.setBounds(50, 30, 250, 30);
    add(text);

    JLabel lblid = new JLabel("Customer Id");
    lblid.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblid.setBounds(50, 80, 150, 30);
    add(lblid);

    customer = new Choice();
    customer.setBounds(220, 80, 150, 30);
    add(customer);

    try {
      Connect c = new Connect();
      ResultSet rs = c.s.executeQuery("select * from customer");
      while (rs.next()) {
        customer.add(rs.getString("number"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    JLabel lblroom = new JLabel("Room Number");
    lblroom.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblroom.setBounds(50, 130, 150, 30);
    add(lblroom);

    tfroom = new JTextField();
    tfroom.setBounds(220, 130, 150, 30);
    add(tfroom);

    JLabel lbl_available = new JLabel("Availability");
    lbl_available.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbl_available.setBounds(50, 180, 150, 30);
    add(lbl_available);

    tf_available = new JTextField();
    tf_available.setBounds(220, 180, 150, 30);
    add(tf_available);

    JLabel lbl_check = new JLabel("Cleaning Status");
    lbl_check.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbl_check.setBounds(50, 230, 150, 30);
    add(lbl_check);

    tf_status = new JTextField();
    tf_status.setBounds(220, 230, 150, 30);
    add(tf_status);

    check = new JButton("Check");
    check.setBounds(30, 300, 100, 30);
    check.addActionListener(this);
    add(check);

    update = new JButton("Update");
    update.setBounds(150, 300, 100, 30);
    update.addActionListener(this);
    add(update);

    back = new JButton("Back");
    back.setBounds(270, 300, 100, 30);
    back.addActionListener(this);
    add(back);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(420, 50, 500, 300);
    add(image);

    setBounds(300, 200, 980, 450);
    setVisible(true);
  }
  public static void main(String[] args) {
    new Update_Room();
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == check) {
      String id = customer.getSelectedItem();
      String query = "select * from customer where number ='"+id+"'";
      try {
        Connect c = new Connect();
        ResultSet rs = c.s.executeQuery(query);
        while(rs.next()) {
          tfroom.setText(rs.getString("room"));
        }
        ResultSet rs2 = c.s.executeQuery("select * from room where room_number='"+tfroom.getText()+"'");
        while(rs2.next()) {
          tf_available.setText(rs2.getString("availability"));
          tf_status.setText(rs2.getString("cleaning_status"));
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (ae.getSource() == update) {
      String available = tf_available.getText();
      String check = tf_status.getText();
      String room = tfroom.getText();
      try {
        Connect c = new Connect();
        c.s.executeUpdate("update room set availability='" + available + "', cleaning_status='" + check+ "' where room_number='" + room + "'");
        JOptionPane.showMessageDialog(null, "Data updated successfully");
        setVisible(false);
        new Reception();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (ae.getSource() == back) {
      setVisible(false);
      new Reception();
    }
  }
}