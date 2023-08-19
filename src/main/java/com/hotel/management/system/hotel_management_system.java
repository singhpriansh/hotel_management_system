package com.hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class hotel_management_system extends JFrame implements ActionListener {

	hotel_management_system() {
		// setSize(1366, 565);
    // setLocation(100, 100);
		setBounds(100, 100, 1366, 565);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		JLabel image = new JLabel(i1);
		add(image);

		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20, 430, 1000, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("serif", Font.PLAIN, 50));
		image.add(text);

		JButton next = new JButton("Next");
		next.setBounds(1150,450,150,50);
		next.setBackground(Color.WHITE);
		next.setForeground(Color.MAGENTA);
		next.addActionListener(this);
		next.setFont(new Font("serif", Font.PLAIN, 24));
		image.add(next);
		setVisible(true);

		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500);
			} catch (Exception e){
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// SpringApplication.run(HotelManagementApplication.class, args);
		new hotel_management_system();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Login();
		// throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}
}
