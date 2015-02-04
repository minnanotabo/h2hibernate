package com.ms.h2hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
 
 
public class H2HibernateTry {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
 
			//driver for H2 db get from http://www.h2database.com
			Class.forName("org.h2.Driver");
 
			//create database on memory
			Connection con = DriverManager.getConnection("jdbc:h2:mem:mytest", "sa", "");
			//Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test",  "sa", "");
 
			Statement stat = con.createStatement();
 
			//create table
			stat.execute("CREATE TABLE ACTIVITY (ID INTEGER, STARTTIME datetime, ENDTIME datetime,  ACTIVITY_NAME VARCHAR(200),  PRIMARY KEY (ID))");
 
			//prepared statement
			PreparedStatement prep = con.prepareStatement("INSERT INTO ACTIVITY (ID, STARTTIME, ENDTIME, ACTIVITY_NAME) VALUES (?,?,?,?)");
 
			//insert 10 row data
			for (int i = 0; i<10; i++){
				prep.setLong(1, i);
				prep.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				prep.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
				prep.setString(4, "Activity-" + i);
 
				//batch insert
				prep.addBatch();
			}
			con.setAutoCommit(false);
			prep.executeBatch();
			con.setAutoCommit(true);
 
 
 
			//query to database
			try {
				ResultSet rs = stat.executeQuery("Select STARTTIME, ENDTIME, ACTIVITY_NAME from ACTIVITY");
				while (rs.next()) {
 
					Date start = rs.getTimestamp(1);
					Date end = rs.getTimestamp(2);
					String activityName = rs.getString(3);
 
					//print query result to console
					System.out.println("activity: " + activityName);
					System.out.println("start: " + start);
					System.out.println("end: " + end);
					System.out.println("--------------------------");
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 
			//close connection
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}
 
}