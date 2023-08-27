package com.hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Add_Customer extends JFrame implements ActionListener {
  JLabel heading, lblid, lblnumber, lblname, lblgender, lblcountry, lblroom, lbltime, check_in_time, lbldeposit;
  JComboBox<String> combo_id;
  JButton combine, back;
  JTextField tfnumber, tfname, tfcountry, tfroom, tfdeposit;
  JRadioButton rbmale, rbfemale;
  Choice croom;

  Add_Customer() {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    heading = new JLabel("New Customer Form");
    heading.setFont(new Font("Comfortaa", Font.BOLD, 20));
    heading.setBounds(130, 20, 220, 30);
    add(heading);

    lblid = new JLabel("ID");
    lblid.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    lblid.setBounds(40, 80, 100, 30);
    add(lblid);

    String options[] = { "Aadhar Card", "Passport", "Driving License", "Voter-id Card", "Ration Card"};
    combo_id = new JComboBox<String>(options);
    combo_id.setBounds(220, 80, 150, 30);
    combo_id.setBackground(Color.WHITE);
    add(combo_id);

    lblnumber = new JLabel("Number");
    lblnumber.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    lblnumber.setBounds(40, 120, 100, 30);
    add(lblnumber);

    tfnumber = new JTextField();
    tfnumber.setBounds(220, 120, 150, 30);
    add(tfnumber);

    lblname = new JLabel("Name");
    lblname.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    lblname.setBounds(40, 160, 100, 30);
    add(lblname);

    tfname = new JTextField();
    tfname.setBounds(220, 160, 150, 30);
    add(tfname);

    lblgender = new JLabel("Gender");
    lblgender.setBounds(40, 200, 100, 30);
    lblgender.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblgender);

    rbmale = new JRadioButton("Male");
    rbmale.setBounds(220, 200, 80, 30);
    rbmale.setFont(new Font("Comfortaa", Font.PLAIN, 14));
    rbmale.setBackground(Color.WHITE);
    add(rbmale);

    rbfemale = new JRadioButton("Female");
    rbfemale.setBounds(290, 200, 90, 30);
    rbfemale.setFont(new Font("Comfortaa", Font.PLAIN, 14));
    rbfemale.setBackground(Color.WHITE);
    add(rbfemale);

    lblcountry = new JLabel("Country");
    lblcountry.setBounds(40, 240, 100, 30);
    lblcountry.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblcountry);

    tfcountry = new JTextField();
    tfcountry.setBounds(220, 240, 150, 30);
    add(tfcountry);

    lblroom = new JLabel("Allocate Room No.");
    lblroom.setBounds(40, 280, 180, 30);
    lblroom.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblroom);

    croom = new Choice();
    try {
      Connect conn = new Connect();
      String query = "select * from room where availability='Available'";
      ResultSet rs = conn.s.executeQuery(query);
      while(rs.next()) {
        croom.add(rs.getString("room_number"));
      }
    } catch (Exception e){
      e.printStackTrace();
    }
    croom.setBounds(220, 280, 150, 30);
    add(croom);

    lbltime = new JLabel("Check in time");
    lbltime.setBounds(40, 320, 180, 30);
    lbltime.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lbltime);

    Date date = new Date();

    check_in_time = new JLabel(""+ date);
    check_in_time.setBounds(230, 320, 147, 30);
    add(check_in_time);

    lbldeposit = new JLabel("Deposit");
    lbldeposit.setBounds(40, 360, 100, 30);
    lbldeposit.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lbldeposit);

    tfdeposit = new JTextField();
    tfdeposit.setBounds(220, 360, 150, 30);
    add(tfdeposit);

    combine = new JButton("Add");
    combine.setBounds(50, 410, 120, 30);
    combine.addActionListener(this);
    add(combine);

    back = new JButton("Back");
    back.setBounds(200, 410, 120, 30);
    back.addActionListener(this);
    add(back);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
    Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(400, 54, 300, 400);
    add(image);

    setBounds(350, 200, 800, 550);
    setVisible(true);
  }
  public static void main(String[] args) {
    new Add_Customer();
  }
  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == combine) {
      String id = (String)combo_id.getSelectedItem();
      String number = tfnumber.getText();
      String name = tfname.getText();
      String gender = null;
      if (rbmale.isSelected()) {
        gender = "Male";
      }else if (rbfemale.isSelected()) {
        gender = "Female";
      }
      String country = tfcountry.getText();
      String room = croom.getSelectedItem();
      String time = check_in_time.getText();
      String deposit = tfdeposit.getText();
      try {
        String query = "insert into customer values ('"+ id +"', '"+ number +"', '"+ name +"', '"+ gender +"', '"+country+"', '"+ room +"', '"+ time +"', '"+ deposit +"')";
        String query2 = "update room set availability='Occupied' where room_number='"+room+"'";
        Connect conn = new Connect();
        conn.s.executeUpdate(query);
        conn.s.executeUpdate(query2);
        JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
        setVisible(false);
        new Reception();
      } catch (Exception e){
        e.printStackTrace(); 
      }
    } else if (ae.getSource() == back) {
      setVisible(false);
      new Reception();
    }
  }
}
