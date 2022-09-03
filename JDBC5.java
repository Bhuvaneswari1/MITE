import java.sql.*;
public class JDBC5
{
public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		Class.forName("com.mysql.jdbc.Driver");				 
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/nexadb","root","");
	 	conn.setAutoCommit(false);
		PreparedStatement ps=conn.prepareStatement("insert into Freshers (ecode, name) values (?,?)");
		ps.setInt(1,105);
		ps.setString(2,"Porko");

		int ctr1=ps.executeUpdate();
		System.out.println("First Row Inserted but not committed");
	 
		ps=conn.prepareStatement("insert into Freshers (ecode, name) values (?,?)");              // ? -place holder
		ps.setInt(1,106);                      
		ps.setString(2,"Sounder");

		int ctr2=ps.executeUpdate();
		System.out.println("Second Row inserted but not committed");
		conn.commit();
		System.out.println("Transaction committed");
		ps.close();
		conn.close();
		}
		catch (Exception  e)
		{
		System.out.println("error"+e);
		}
		}
	}

 
