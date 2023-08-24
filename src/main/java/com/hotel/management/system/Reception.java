package com.hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {
  JButton newCustomer, rooms, departments, allEmployee, customInfo, managerInfo, checkout, updateStatus, roomStatus, pickService, searchRoom, logout;

  Reception() {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    newCustomer = new JButton("New Customer Form");
    newCustomer.setBounds(30,30,200,30);
    newCustomer.addActionListener(this);
    add(newCustomer);

    rooms = new JButton("Rooms");
    rooms.setBounds(30,70,200,30);
    rooms.addActionListener(this);
    add(rooms);

    departments = new JButton("Department");
    departments.setBounds(30,110,200,30);
    departments.addActionListener(this);
    add(departments);

    allEmployee = new JButton("All Employee");
    allEmployee.setBounds(30,150,200,30);
    allEmployee.addActionListener(this);
    add(allEmployee);

    customInfo = new JButton("Customer info");
    customInfo.setBounds(30,190,200,30);
    customInfo.addActionListener(this);
    add(customInfo);

    managerInfo = new JButton("Manager Info");
    managerInfo.setBounds(30,230,200,30);
    managerInfo.addActionListener(this);
    add(managerInfo);

    checkout = new JButton("Checkout");
    checkout.setBounds(30,270,200,30);
    checkout.addActionListener(this);
    add(checkout);

    updateStatus = new JButton("Update status");
    updateStatus.setBounds(30,310,200,30);
    updateStatus.addActionListener(this);
    add(updateStatus);

    roomStatus = new JButton("Update room status");
    roomStatus.setBounds(30,350,200,30);
    roomStatus.addActionListener(this);
    add(roomStatus);

    pickService = new JButton("Pickup Service");
    pickService.setBounds(30,390,200,30);
    pickService.addActionListener(this);
    add(pickService);

    searchRoom = new JButton("Search Room");
    searchRoom.setBounds(30,430,200,30);
    searchRoom.addActionListener(this);
    add(searchRoom);

    logout = new JButton("Logout");
    logout.setBounds(30,470,200,30);
    logout.addActionListener(this);
    add(logout);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(250, 30, 500, 470);
    add(image);

    setBounds(350, 200, 800, 570);
    setVisible(true);
  }

  public static void main (String[] args) {
    new Reception();
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
  }
}
