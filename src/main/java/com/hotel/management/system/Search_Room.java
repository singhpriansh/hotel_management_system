package com.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class Search_Room extends JFrame implements ActionListener {

  JButton backButton, submitButton;
  JTextField tfroom, tfprice;
  JLabel heading, lblroomno;
  JComboBox<String> bedType;
  JTable table;
  JCheckBox available;

  Search_Room () {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    heading = new JLabel("Search for Room");
    heading.setFont(new Font("Comfortaa", Font.BOLD, 20));
    heading.setBounds(400, 30, 200, 30);
    add(heading);

    lblroomno = new JLabel("Bed Type");
    lblroomno.setFont(new Font("Comfortaa", Font.PLAIN, 14));
    lblroomno.setBounds(50, 80, 100, 30);
    add(lblroomno);

    bedType = new JComboBox<String>(new String[] {"Single Bed", "Double Bed"});
    bedType.setBounds(150, 80, 150, 30);
    add(bedType);

    available = new JCheckBox("Only display Available");
    available.setFont(new Font("Comfortaa", Font.PLAIN, 14));
    available.setBounds(650, 80, 200, 30);
    add(available);


    JLabel l1 = new JLabel("Room Number");
    l1.setBounds(0, 135, 100, 20);
    add(l1);

    JLabel l2 = new JLabel("Availability");
    l2.setBounds(200, 135, 100, 20);
    add(l2);

    JLabel l3 = new JLabel("Cleaning Status");
    l3.setBounds(400, 135, 100, 20);
    add(l3);

    JLabel l4 = new JLabel("Price");
    l4.setBounds(600, 135, 100, 20);
    add(l4);

    JLabel l5 = new JLabel("Bed Type");
    l5.setBounds(800, 135, 100, 20);
    add(l5);

    table = new JTable();
    table.setBounds(0, 160, 1000, 300);
    add(table);

    try {
      Connect conn = new Connect();
      ResultSet rs = conn.s.executeQuery("select * from room");
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
    new Search_Room();
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submitButton) {
      try {
        String query1 = "select * from room where bed_type='"+bedType.getSelectedItem()+"'";
        String query2 = "select * from room where availability='Available' and bed_type='"+bedType.getSelectedItem()+"'";
        Connect conn = new Connect();
        ResultSet rs =  null;
        if (available.isSelected()) {
          rs = conn.s.executeQuery(query2);
        } else {
          rs = conn.s.executeQuery(query1);
        }
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
