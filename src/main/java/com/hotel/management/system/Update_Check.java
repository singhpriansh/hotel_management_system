package com.hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Update_Check extends JFrame implements ActionListener {

  Choice customer;
  JTextField tfroom, tfname, tfcheck_in, tfcheck_out, tfpaid, tfpending;
  JButton check, update, back;
  Date date = new Date();

  Update_Check() {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel text = new JLabel("Update Status");
    text.setFont(new Font("Comfortaa", Font.PLAIN, 20));
    text.setForeground(Color.BLUE);
    text.setBounds(90, 20, 200, 30);
    add(text);

    JLabel lblid = new JLabel("Customer Id");
    lblid.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblid.setBounds(50, 80, 150, 30);
    add(lblid);

    customer = new Choice();
    customer.setBounds(200, 80, 200, 30);
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
    lblroom.setBounds(50, 120, 150, 30);
    add(lblroom);

    tfroom = new JTextField();
    tfroom.setBounds(200, 120, 200, 30);
    add(tfroom);

    JLabel lblname = new JLabel("Name");
    lblname.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblname.setBounds(50, 160, 150, 30);
    add(lblname);

    tfname = new JTextField();
    tfname.setBounds(200, 160, 200, 30);
    add(tfname);

    JLabel lbl_check = new JLabel("Check in Time");
    lbl_check.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbl_check.setBounds(50, 200, 150, 30);
    add(lbl_check);

    tfcheck_in = new JTextField();
    tfcheck_in.setBounds(200, 200, 200, 30);
    add(tfcheck_in);

    JLabel lbl_checkout = new JLabel("Check out Time");
    lbl_checkout.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbl_checkout.setBounds(50, 240, 150, 30);
    add(lbl_checkout);

    tfcheck_out = new JTextField();
    tfcheck_out.setBounds(200, 240, 200, 30);
    tfcheck_out.setText("" + date);
    add(tfcheck_out);

    JLabel lbl_paid = new JLabel("Amount Paid");
    lbl_paid.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbl_paid.setBounds(50, 280, 150, 30);
    add(lbl_paid);

    tfpaid = new JTextField();
    tfpaid.setBounds(200, 280, 200, 30);
    add(tfpaid);

    JLabel lbl_pending = new JLabel("Pending Amount");
    lbl_pending.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbl_pending.setBounds(50, 320, 150, 30);
    add(lbl_pending);

    tfpending = new JTextField();
    tfpending.setBounds(200, 320, 200, 30);
    add(tfpending);

    check = new JButton("Check");
    check.setBounds(30, 380, 100, 30);
    check.addActionListener(this);
    add(check);

    update = new JButton("Update");
    update.setBounds(150, 380, 100, 30);
    update.addActionListener(this);
    add(update);

    back = new JButton("Back");
    back.setBounds(270, 380, 100, 30);
    back.addActionListener(this);
    add(back);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(400, 50, 500, 300);
    add(image);

    setBounds(300, 200, 980, 500);
    setVisible(true);
  }
  public static void main(String[] args) {
    new Update_Check();
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
          tfname.setText(rs.getString("name"));
          tfcheck_in.setText(rs.getString("checkintime"));
          tfpaid.setText(rs.getString("deposit"));
        }
        ResultSet rs2 = c.s.executeQuery("select * from room where room_number='"+tfroom.getText()+"'");
        while(rs2.next()) {
          String price = rs2.getString("price");
          DateFormat df = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
          long diffIn_Millis = Math.abs(date.getTime() - df.parse(tfcheck_in.getText()).getTime());
          long diff = TimeUnit.DAYS.convert(diffIn_Millis, TimeUnit.MILLISECONDS);

          long pending_amount = diff*Long.parseLong(price) - Long.parseLong(tfpaid.getText());
          tfpending.setText("" + pending_amount);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (ae.getSource() == update) {
      String number = customer.getSelectedItem();
      String room = tfroom.getText();
      String name = tfname.getText();
      String check_in = tfcheck_in.getText();
      String deposit = tfpaid.getText();
      try {
        Connect c = new Connect();
        c.s.executeUpdate("update customer set room='"+room+"', name='"+name+"', checkintime='"+check_in+"', deposit='"+deposit+"' where number='"+ number +"'");
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