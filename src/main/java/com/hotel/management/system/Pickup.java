package com.hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener {

  JButton backButton, submitButton;
  JTextField tfroom, tfprice;
  JLabel heading, lblroomno;
  Choice type_of_car;
  JTable table;
  JCheckBox available;

  Pickup () {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    heading = new JLabel("Pickup Service");
    heading.setFont(new Font("Comfortaa", Font.BOLD, 20));
    heading.setBounds(400, 30, 200, 30);
    add(heading);

    lblroomno = new JLabel("Type of Car");
    lblroomno.setFont(new Font("Comfortaa", Font.PLAIN, 14));
    lblroomno.setBounds(50, 80, 100, 30);
    add(lblroomno);

    type_of_car = new Choice();
    type_of_car.setBounds(150, 80, 150, 30);
    add(type_of_car);

    try {
      Connect c = new Connect();
      ResultSet rs = c.s.executeQuery("select * from driver");
      while (rs.next()) {
        type_of_car.add(rs.getString("brand"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    JLabel l1 = new JLabel("Name");
    l1.setBounds(5, 135, 144, 20);
    add(l1);

    JLabel l2 = new JLabel("Age");
    l2.setBounds(149, 135, 144, 20);
    add(l2);

    JLabel l3 = new JLabel("Gender");
    l3.setBounds(291, 135, 144, 20);
    add(l3);

    JLabel l4 = new JLabel("Company");
    l4.setBounds(434, 135, 144, 20);
    add(l4);

    JLabel l5 = new JLabel("Brand");
    l5.setBounds(576, 135, 144, 20);
    add(l5);

    JLabel l6 = new JLabel("Availability");
    l6.setBounds(719, 135, 144, 20);
    add(l6);

    JLabel l7 = new JLabel("Location");
    l7.setBounds(862, 135, 144, 20);
    add(l7);

    table = new JTable();
    table.setBounds(5, 160, 1000, 300);
    add(table);

    try {
      Connect conn = new Connect();
      ResultSet rs = conn.s.executeQuery("select * from driver");
      table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
      e.printStackTrace();
    }

    submitButton = new JButton("Submit");
    submitButton.addActionListener(this);
    submitButton.setBounds(350, 520, 120, 30);
    add(submitButton);

    backButton = new JButton("Back");
    backButton.addActionListener(this);
    backButton.setBounds(550, 520, 120, 30);
    add(backButton);

    setBounds(300, 200, 1000, 600);
    setVisible(true);
  }

  public static void main (String[] args) {
    new Pickup();
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submitButton) {
      try {
        String query = "select * from driver where brand='"+ type_of_car.getSelectedItem() +"'";
        Connect conn = new Connect();
        ResultSet rs =  conn.s.executeQuery(query);
        table.setModel(DbUtils.resultSetToTableModel(rs));
      } catch (Exception e) { 
        e.printStackTrace();
      }
    } else if (ae.getSource() == backButton) {
      setVisible(false);
      new Reception();
    }
  }
}
