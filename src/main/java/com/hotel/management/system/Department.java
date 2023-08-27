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

public class Department extends JFrame implements ActionListener {
  JTable table;
  JButton backButton;

  Department() {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel l1 = new JLabel("Department");
    l1.setBounds(10, 5, 100, 20);
    add(l1);

    JLabel l2 = new JLabel("Budget");
    l2.setBounds(270, 5, 100, 20);
    add(l2);

    table = new JTable();
    table.setBounds(0, 30, 550, 350);
    add(table);

    try {
      Connect conn = new Connect();
      ResultSet rs = conn.s.executeQuery("select * from department");
      table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
      e.printStackTrace();
    }

    backButton = new JButton("Back");
    backButton.setBounds(200, 400, 120, 30);
    backButton.addActionListener(this);
    add(backButton);

    setBounds(400, 200, 700, 480);
    setVisible(true);
  }

  public static void main (String[] args) {
    new Department();
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    setVisible(false);
    new Reception();
  }
}
