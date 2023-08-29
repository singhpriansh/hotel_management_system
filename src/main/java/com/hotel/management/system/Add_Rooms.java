package com.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Add_Rooms extends JFrame implements ActionListener {

  JButton jbadd, cancel;
  JTextField tfroom, tfprice;
  JLabel heading, lblroomno, lblavailable, lblclean, lblprice, lbltype;
  JComboBox<String> availablecombo, cleanCombo, sizeCombo;

  Add_Rooms () {

    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    heading = new JLabel("Add Rooms");
    heading.setFont(new Font("Comfortaa", Font.BOLD, 20));
    heading.setBounds(150, 20, 200, 20);
    add(heading);

    lblroomno = new JLabel("Room Number");
    lblroomno.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblroomno.setBounds(60, 80, 140, 30);
    add(lblroomno);

    tfroom = new JTextField();
    tfroom.setBounds(220, 80, 150, 30);
    add(tfroom);

    lblavailable = new JLabel("Availability");
    lblavailable.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblavailable.setBounds(60, 130, 140, 30);
    add(lblavailable);

    String availableOptions[] = { "Available", "Occupied" };
    availablecombo = new JComboBox<String>(availableOptions);
    availablecombo.setBounds(220, 130, 150, 30);
    availablecombo.setBackground(Color.WHITE);
    add(availablecombo);

    lblclean = new JLabel("Room's Condition");
    lblclean.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblclean.setBounds(60, 180, 140, 30);
    add(lblclean);

    String cleanOPtions[] = { "Clean", "Dirty" };
    cleanCombo = new JComboBox<String>(cleanOPtions);
    cleanCombo.setBounds(220, 180, 150, 30);
    cleanCombo.setBackground(Color.WHITE);
    add(cleanCombo);

    lblprice = new JLabel("Price");
    lblprice.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblprice.setBounds(60, 230, 140, 30);
    add(lblprice);

    tfprice = new JTextField();
    tfprice.setBounds(220, 230, 150, 30);
    add(tfprice);

    lbltype = new JLabel("Bed type");
    lbltype.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbltype.setBounds(60, 280, 140, 30);
    add(lbltype);

    String sizeOptions[] = { "Single bed", "Double bed" };
    sizeCombo = new JComboBox<String>(sizeOptions);
    sizeCombo.setBounds(220, 280, 150, 30);
    sizeCombo.setBackground(Color.WHITE);
    add(sizeCombo);

    jbadd = new JButton("Add Room");
    jbadd.setBounds(60, 330, 140, 30);
    jbadd.addActionListener(this);
    add(jbadd);

    cancel = new JButton("Cancel");
    cancel.setBounds(220, 330, 140, 30);
    cancel.addActionListener(this);
    add(cancel);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(400, 54, 500, 300);
    add(image);

    setBounds(330, 200, 940, 470);
    setVisible(true);
  }

  public static void main (String[] args) {
    new Add_Rooms();
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == jbadd) {
      String room_number = tfroom.getText();
      String availability = (String)availablecombo.getSelectedItem();
      String status = (String)cleanCombo.getSelectedItem();
      String price = tfprice.getText();
      String type = (String)sizeCombo.getSelectedItem();

      try {
        Connect conn = new Connect();
        String str = "insert into room values('"+ room_number +"', '"+ availability +"', '"+ status +"','"+ price +"', '"+ type +"')";
        conn.s.executeUpdate(str);

        JOptionPane.showMessageDialog(null,"New room added successfully");
        setVisible(false);
      } catch (Exception e) {
        e.printStackTrace();
      }

    } else if (ae.getSource() == cancel) {
      setVisible(false);
    }
  }
}
