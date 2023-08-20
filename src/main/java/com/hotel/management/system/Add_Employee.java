package com.hotel.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Add_Employee extends JFrame {
  Add_Employee() {
    setLayout(null);

    JLabel lblname = new JLabel("NAME");
    lblname.setBounds(60, 30, 120, 30);
    lblname.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblname);

    JTextField tfname = new JTextField();
    tfname.setBounds(200, 30, 150, 30);
    add(tfname);

    JLabel lblage = new JLabel("AGE");
    lblage.setBounds(60, 80, 120, 30);
    lblage.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblage);

    JTextField tfage = new JTextField();
    tfage.setBounds(200, 80, 150, 30);
    add(tfage);

    JLabel lblgender = new JLabel("GENDER");
    lblgender.setBounds(60, 130, 120, 30);
    lblgender.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblgender);

    JRadioButton rbmale = new JRadioButton("Male");
    rbmale.setBounds(200, 130, 80, 30);
    rbmale.setFont(new Font("Comfortaa", Font.PLAIN, 14));
    rbmale.setBackground(Color.WHITE);
    add(rbmale);

    JRadioButton rbfemale = new JRadioButton("Female");
    rbfemale.setBounds(270, 130, 90, 30);
    rbfemale.setFont(new Font("Comfortaa", Font.PLAIN, 14));
    rbfemale.setBackground(Color.WHITE);
    add(rbfemale);

    // JTextField tfgender = new JTextField();
    // tfgender.setBounds(200, 130, 150, 30);
    // add(tfgender);

    getContentPane().setBackground(Color.WHITE);
    setBounds(350, 200, 850, 540);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Add_Employee();
  }
}