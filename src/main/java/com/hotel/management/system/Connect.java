package com.hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
  Connection c;
  Statement s;
  Connect() {
    try {
      // String url = "jdbc:sqlite:/Users/singhpriansh/Desktop/Computer/JAVA/hotel_management/hotelmanagementsystem.sqlite3";  
      // create a connection to the database
      // c = DriverManager.getConnection(url);
      // s.execute("use hotelmanagementsystem");
      // System.out.println("Connection to SQLite has been established.");
      Class.forName("com.mysql.cj.jdbc.Driver");
      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/","singhpriansh","password");
      s = c.createStatement();
      s.executeUpdate("use hotelmanagementsystem");
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}
