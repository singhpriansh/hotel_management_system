package com.hotel.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Add_Rooms extends JFrame{
  Add_Rooms () {

    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel heading = new JLabel("Add Rooms");
    heading.setFont(new Font("Comfortaa", Font.BOLD, 20));
    heading.setBounds(150, 20, 200, 20);
    add(heading);

    JLabel lblroomno = new JLabel("Rooms Number");
    lblroomno.setFont(new Font("Comfortaa", Font.PLAIN, 18));
    lblroomno.setBounds(60, 80, 140, 30);
    add(lblroomno);

    JTextField tfroom = new JTextField();
    tfroom.setBounds(220, 80, 150, 30);
    add(tfroom);

    JLabel lblavailable = new JLabel("Rooms Available");
    lblavailable.setFont(new Font("Comfortaa", Font.PLAIN, 18));
    lblavailable.setBounds(60, 130, 140, 30);
    add(lblavailable);

    

    setBounds(330, 200, 940, 470);
    setVisible(true);
  }

  public static void main (String[] args) {
    new Add_Rooms();
  }
}
