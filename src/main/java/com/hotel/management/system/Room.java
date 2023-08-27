package com.hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener{
  JTable table;
  JButton backButton;

  Room() {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
    Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(500, 0, 600, 600);
    add(image);

    JLabel l1 = new JLabel("Room Number");
    l1.setBounds(0, 5, 100, 20);
    add(l1);

    JLabel l2 = new JLabel("Availability");
    l2.setBounds(100, 5, 100, 20);
    add(l2);

    JLabel l3 = new JLabel("Status");
    l3.setBounds(200, 5, 100, 20);
    add(l3);

    JLabel l4 = new JLabel("Price");
    l4.setBounds(300, 5, 100, 20);
    add(l4);

    JLabel l5 = new JLabel("Bed Type");
    l5.setBounds(400, 5, 100, 20);
    add(l5);

    table = new JTable();
    table.setBounds(0, 30, 500, 400);
    add(table);

    try {
      Connect conn = new Connect();
      ResultSet rs = conn.s.executeQuery("select * from room");
      table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
      e.printStackTrace();
    }

    backButton = new JButton("Back");
    backButton.addActionListener(this);
    backButton.setBounds(200, 500, 120, 30);
    add(backButton);

    setBounds(300, 200, 1050, 600);
    setVisible(true);
  }

  public static void main (String[] args) {
    new Room();
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    setVisible(false);
    new Reception();
  }
}
