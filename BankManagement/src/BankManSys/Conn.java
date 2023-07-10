package BankManSys;

import java.sql.*;
public class Conn {
	Connection c=null;
	Statement stmt=null;
	Conn(){
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsys","root","khushikhushi");
			stmt=c.createStatement();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

}
