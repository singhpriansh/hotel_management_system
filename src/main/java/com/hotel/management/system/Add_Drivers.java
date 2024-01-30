package com.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Add_Drivers extends JFrame implements ActionListener {

  JButton jbadd, cancel;
  JTextField tfname, tfCarModel, tfage, tfCarCompany, tfLocation;
  JLabel heading, lblname, lblage, lblgender, lblCarCompany, lblCarModel, lblavailable, lbl_location;
  JComboBox<String> genCombo, available_Combo;

  Add_Drivers () {

    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    heading = new JLabel("Add Drivers");
    heading.setFont(new Font("Comfortaa", Font.BOLD, 20));
    heading.setBounds(150, 20, 200, 20);
    add(heading);

    lblname = new JLabel("Name");
    lblname.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblname.setBounds(60, 80, 140, 30);
    add(lblname);

    tfname = new JTextField();
    tfname.setBounds(220, 80, 150, 30);
    add(tfname);

    lblage = new JLabel("Age");
    lblage.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblage.setBounds(60, 130, 140, 30);
    add(lblage);

    tfage = new JTextField();
    tfage.setBounds(220, 130, 150, 30);
    add(tfage);

    lblgender = new JLabel("Gender");
    lblgender.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblgender.setBounds(60, 180, 140, 30);
    add(lblgender);

    String genOption[] = { "Male", "Female" };
    genCombo = new JComboBox<String>(genOption);
    genCombo.setBounds(220, 180, 150, 30);
    genCombo.setBackground(Color.WHITE);
    add(genCombo);

    lblCarCompany = new JLabel("Car Company");
    lblCarCompany.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblCarCompany.setBounds(60, 230, 140, 30);
    add(lblCarCompany);

    tfCarCompany = new JTextField();
    tfCarCompany.setBounds(220, 230, 150, 30);
    add(tfCarCompany);
    
    lblCarModel = new JLabel("Car Model");
    lblCarModel.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblCarModel.setBounds(60, 280, 140, 30);
    add(lblCarModel);

    tfCarModel = new JTextField();
    tfCarModel.setBounds(220, 280, 150, 30);
    add(tfCarModel);

    lblavailable = new JLabel("Available");
    lblavailable.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lblavailable.setBounds(60, 330, 140, 30);
    add(lblavailable);

    String available_Options[] = { "Available", "Busy", "Delayed" };
    available_Combo = new JComboBox<String>(available_Options);
    available_Combo.setBounds(220, 330, 150, 30);
    available_Combo.setBackground(Color.WHITE);
    add(available_Combo);

    lbl_location = new JLabel("Location");
    lbl_location.setFont(new Font("Comfortaa", Font.PLAIN, 16));
    lbl_location.setBounds(60, 380, 140, 30);
    add(lbl_location);

    tfLocation = new JTextField();
    tfLocation.setBounds(220, 380, 150, 30);
    add(tfLocation);

    jbadd = new JButton("Add Driver");
    jbadd.setBounds(60, 430, 140, 30);
    jbadd.addActionListener(this);
    add(jbadd);

    cancel = new JButton("Cancel");
    cancel.setBounds(220, 430, 140, 30);
    cancel.addActionListener(this);
    add(cancel);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
    Image i2 = i1.getImage().getScaledInstance(510,330, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(400, 100, 500, 300);
    add(image);

    setBounds(300, 180, 980, 570);
    setVisible(true);
  }

  public static void main (String[] args) {
    new Add_Drivers();
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == jbadd) {
      String name = tfname.getText();
      String age = tfage.getText();
      String gender = (String)genCombo.getSelectedItem();
      String company = tfCarCompany.getText();
      String brand = tfCarModel.getText();
      String available = (String)available_Combo.getSelectedItem();
      String location = tfLocation.getText();

      try {
        Connect conn = new Connect();
        String str = "insert into driver values('"+ name +"', '"+ age +"', '"+ gender +"','"+ company +"', '"+ brand + "', '"+ available+"', '"+ location +"')";
        conn.s.executeUpdate(str);
        setVisible(false);
        JOptionPane.showMessageDialog(null,"New driver registered successfully");
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (ae.getSource() == cancel) {
      setVisible(false);
    }
  }
}
