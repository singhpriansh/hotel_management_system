package com.hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
  Connection c;
  Statement s;
  Connect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver"); 
      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/","singhpriansh","password");
      s = c.createStatement();
      s.executeUpdate("use hotelmanagementsystem");
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}
