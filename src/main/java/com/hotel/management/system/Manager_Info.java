package com.hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Manager_Info extends JFrame implements ActionListener {
  JTable table;
  JButton backButton;

  Manager_Info() {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel l1 = new JLabel("Name");
    l1.setBounds(0, 5, 125, 20);
    add(l1);

    JLabel l2 = new JLabel("Age");
    l2.setBounds(125, 5, 125, 20);
    add(l2);

    JLabel l3 = new JLabel("Gender");
    l3.setBounds(250, 5,125, 20);
    add(l3);

    JLabel l4 = new JLabel("Job");
    l4.setBounds(375, 5, 125, 20);
    add(l4);

    JLabel l5 = new JLabel("Salary");
    l5.setBounds(500, 5, 125, 20);
    add(l5);

    JLabel l6 = new JLabel("Phone Number");
    l6.setBounds(625, 5, 125, 20);
    add(l6);

    JLabel l7 = new JLabel("Email");
    l7.setBounds(750, 5, 125, 20);
    add(l7);

    JLabel l8 = new JLabel("Aadhar");
    l8.setBounds(875, 5, 125, 20);
    add(l8);

    table = new JTable();
    table.setBounds(0, 30, 1000, 400);
    add(table);

    try {
      Connect conn = new Connect();
      ResultSet rs = conn.s.executeQuery("select * from employee where job='Manager'");
      table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
      e.printStackTrace();
    }

    backButton = new JButton("Back");
    backButton.addActionListener(this);
    backButton.setBounds(420, 500, 120, 30);
    add(backButton);

    setBounds(300, 200, 1000, 600);
    setVisible(true);
  }

  public static void main (String[] args) {
    new Manager_Info();
  }

  @Override
  public void actionPerformed (ActionEvent ae) {
    setVisible(false);
    new Reception();
  }
}
