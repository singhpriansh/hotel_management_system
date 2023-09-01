package com.hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Checkout extends JFrame implements ActionListener{

  JLabel text, lblid, lblroom, lblroom_number, lbl_check_in, lbl_check_in_time, lbl_checkout, lbl_checkout_time;
  Choice customer;
  Date date = new Date();
  JButton back, check;

  Checkout () {
    setLayout(null);

    text = new JLabel("Checkout");
    text.setBounds(100, 20, 200, 30);
    text.setForeground(Color.BLUE);
    text.setFont(new Font("Comfortaa", Font.PLAIN, 20));
    add(text);

    lblid = new JLabel("Customer Id");
    lblid.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblid.setBounds(30, 80, 150, 30);
    add(lblid);

    customer = new Choice();
    customer.setBounds(200, 80, 200, 30);
    add(customer);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
    Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel tick = new JLabel(i3);
    tick.setBounds(310, 80, 20, 20);
    add(tick);

    lblroom = new JLabel("Room number");
    lblroom.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblroom.setBounds(30, 130, 200, 30);
    add(lblroom);

    lblroom_number = new JLabel();
    lblroom_number.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblroom_number.setBounds(200, 130, 200, 30);
    add(lblroom_number);

    lbl_check_in = new JLabel("Check in Time");
    lbl_check_in.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbl_check_in.setBounds(30, 180, 200, 30);
    add(lbl_check_in);

    lbl_check_in_time = new JLabel();
    lbl_check_in_time.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbl_check_in_time.setBounds(200, 180, 200, 30);
    add(lbl_check_in_time);

    lbl_checkout = new JLabel("Check out Time");
    lbl_checkout.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbl_checkout.setBounds(30, 230, 200, 30);
    add(lbl_checkout);

    lbl_checkout_time = new JLabel("" + date);
    lbl_checkout_time.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbl_checkout_time.setBounds(200, 230, 200, 30);
    add(lbl_checkout_time);

    check = new JButton("Check");
    check.setBounds(30, 280, 100, 30);
    check.addActionListener(this);
    add(check);

    back = new JButton("Back");
    back.setBounds(150, 280, 100, 30);
    back.addActionListener(this);
    add(back);

    try {
      Connect c = new Connect();
      ResultSet rs = c.s.executeQuery("select * from customer");
      while(rs.next()) {
        customer.add(rs.getString("number"));
        lblroom_number.setText(rs.getString("room"));
        lbl_check_in_time.setText(rs.getString("checkintime"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
    Image im2 = im1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
    ImageIcon im3 = new ImageIcon(im2);
    JLabel image = new JLabel(im3);
    image.setBounds(350, 50, 400, 250);
    add(image);

    setBounds(300, 200, 800, 400);
    setVisible(true);
  }

  public static void main (String[] args) {
    new Checkout();
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == check) {
      String query1 = "delete from customer where number='"+customer.getSelectedItem()+"'";
      String query2 = "update room set availability='Available' where room_number='"+lblroom_number.getText()+"'";

      try {
        Connect c = new Connect();
        c.s.executeUpdate(query1);
        c.s.executeUpdate(query2);
        JOptionPane.showMessageDialog(null, "Done checkout");
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
