package com.hotel.management.system;

import javax.swing.JFrame;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
public class hotel_management_system extends JFrame{

	hotel_management_system() {
		setSize(1366, 565);
    setLocation(100, 100);

    setVisible(true);
	}

	public static void main(String[] args) {
		// SpringApplication.run(HotelManagementApplication.class, args);
		new hotel_management_system();
	}
}
