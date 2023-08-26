package com.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Add_Employee extends JFrame implements ActionListener {

  JTextField tfname, tfage, tfsalary, tfphone, tfemail, tfaadhar;
  JRadioButton rbmale, rbfemale;
  JComboBox<String> cbjob;
  JButton jbadd, cancel;

  Add_Employee() {
    setLayout(null);

    JLabel lblname = new JLabel("Name");
    lblname.setBounds(60, 30, 120, 30);
    lblname.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblname);

    tfname = new JTextField();
    tfname.setBounds(200, 30, 150, 30);
    add(tfname);

    JLabel lblage = new JLabel("Age");
    lblage.setBounds(60, 80, 120, 30);
    lblage.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblage);

    tfage = new JTextField();
    tfage.setBounds(200, 80, 150, 30);
    add(tfage);

    JLabel lblgender = new JLabel("Gender");
    lblgender.setBounds(60, 130, 120, 30);
    lblgender.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblgender);

    rbmale = new JRadioButton("Male");
    rbmale.setBounds(200, 130, 80, 30);
    rbmale.setFont(new Font("Comfortaa", Font.PLAIN, 14));
    rbmale.setBackground(Color.WHITE);
    add(rbmale);

    rbfemale = new JRadioButton("Female");
    rbfemale.setBounds(270, 130, 90, 30);
    rbfemale.setFont(new Font("Comfortaa", Font.PLAIN, 14));
    rbfemale.setBackground(Color.WHITE);
    add(rbfemale);

    ButtonGroup bg = new ButtonGroup();
    bg.add(rbmale);
    bg.add(rbfemale);

    JLabel lbljob = new JLabel("Job");
    lbljob.setBounds(60, 180, 120, 30);
    lbljob.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lbljob);

    String str[] = { "Manager", "Accountant", "Chefs", "Front Desk Clerks", "Porters", "HouseKeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress" };
    cbjob = new JComboBox<String>(str);
    cbjob.setBounds(200, 180, 150, 30);
    cbjob.setBackground(Color.WHITE);
    add(cbjob);

    JLabel lblsalary = new JLabel("Salary");
    lblsalary.setBounds(60, 230, 120, 30);
    lblsalary.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblsalary);

    tfsalary = new JTextField();
    tfsalary.setBounds(200, 230, 150, 30);
    add(tfsalary);

    JLabel lblphone = new JLabel("Phone No");
    lblphone.setBounds(60, 280, 120, 30);
    lblphone.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblphone);

    tfphone = new JTextField();
    tfphone.setBounds(200, 280, 150, 30);
    add(tfphone);

    JLabel lblemail = new JLabel("Email ID");
    lblemail.setBounds(60, 330, 120, 30);
    lblemail.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblemail);

    tfemail = new JTextField();
    tfemail.setBounds(200, 330, 150, 30);
    add(tfemail);

    JLabel lblaadhar = new JLabel("Aadhar");
    lblaadhar.setBounds(60, 380, 120, 30);
    lblaadhar.setFont(new Font("Comfortaa", Font.PLAIN, 17));
    add(lblaadhar);

    tfaadhar = new JTextField();
    tfaadhar.setBounds(200, 380, 150, 30);
    add(tfaadhar);

    jbadd = new JButton("Register Employee");
    jbadd.setBounds(40, 430, 160, 30);
    jbadd.addActionListener(this);
    add(jbadd);

    cancel = new JButton("Cancel");
    cancel.setBounds(210, 430, 140, 30);
    cancel.addActionListener(this);
    add(cancel);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
    Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(350, 50, 500, 400);
    add(image);

    getContentPane().setBackground(Color.WHITE);
    setBounds(350, 200, 850, 540);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Add_Employee();
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == jbadd) {
      String name = tfname.getText();
      String age = tfage.getText();
      String salary = tfsalary.getText();
      String phone = tfphone.getText();
      String email = tfemail.getText();
      String aadhar = tfaadhar.getText();
      String gender = null;

      if(rbmale.isSelected()) {
        gender = "Male";
      } else if(rbfemale.isSelected()){
        gender = "Female";
      }

      String job = (String)cbjob.getSelectedItem();

      // Validations
      if (name.equals("")) {
        JOptionPane.showMessageDialog(null, "Name should not be empty");
        return;
      }

      try {
        if (age.equals("") || Integer.valueOf(age) < 5 || Integer.valueOf(age) > 120) {
          JOptionPane.showMessageDialog(null, "Please enter a valid age");
          return;
        }
      } catch (NumberFormatException ne){
        JOptionPane.showMessageDialog(null, "Please enter a valid age");
        return;
      }

      try {
        if (salary.equals("") || Integer.valueOf(salary) < 5000) {
          JOptionPane.showMessageDialog(null, "Please enter a valid Salary");
          return;
        }
      } catch (NumberFormatException ne){
        JOptionPane.showMessageDialog(null, "Please enter a valid Salary");
        return;
      }

      try {
        if (phone.equals("") || phone.length() < 10 || phone.length() > 10) {
          JOptionPane.showMessageDialog(null, "Please enter a valid Phone number");
          return;
        }
      } catch (Exception exception){
        throw new UnsupportedOperationException("Exception while processing phone number");
      }

      if (email.equals("") || !email.contains("@") || !email.endsWith(".com")){
        JOptionPane.showMessageDialog(null, "Please enter a valid email id");
        return;
      }

      try {
        if (aadhar.equals("") || aadhar.length() < 12 || aadhar.length() > 12) {
          JOptionPane.showMessageDialog(null, "Please enter a valid aadhar number");
          return;
        }
      } catch (Exception exception){
        throw new UnsupportedOperationException("Exception while processing aadhar number");
      }

      try {
        Connect conn = new Connect();
        String query = "insert into employee values('"+ name +"','"+ age +"','"+ gender +"','"+ job +"','"+ salary +"','"+ phone +"','"+ email +"','"+ aadhar + "');";
        conn.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Employee added successfully");
        setVisible(false);
      } catch(Exception excep) {
        excep.printStackTrace();
      }
    } else if (ae.getSource() == cancel) {
      setVisible(false);
    }
  }
}