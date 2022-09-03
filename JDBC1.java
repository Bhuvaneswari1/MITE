package com;
import java.sql.*;

public class JDBC1 {

	public static void main(String[] args) {		
	String str="SELECT * FROM Emp WHERE city LIKE 'C%'";		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 			
		Connection con;
		try {
con = DriverManager.getConnection( 
"jdbc:mysql://localhost:3306/NexaDB","root","");		
			Statement stmt=con.createStatement(); 
			ResultSet rs=stmt.executeQuery(str);
			System.out.println("Empid\tEname");
			while (rs.next())	
			{
				String id=rs.getString("id");		
				String sna=rs.getString("ename");	
				System.out.print(id+"\t");
				System.out.println(sna);
			}	
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		}
	