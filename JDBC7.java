import java.sql.*;
public class JDBC7
{
   public static void main(String args[])
   {
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver")	;
Connection con=DriverManager.getConnection("jdbc:odbc:DSN1","user1","");
String str = "{call emp2(?}";
CallableStatement cstmt = con.prepareCall(str);
ResultSet rs = cstmt.executeQuery();
while(rs.next())
      		{
		            System.out.println("EName : " +   rs.getString(1))+"\n");
		            System.out.println("Name : "+rs.getString(2)+"\n");
		            
		            System.out.println("-----------------------------------------------\n");
 	             }

	} 
     	catch(Exception e)
     	{
		System.out.println("Error : " + e);
	}
  }
}
 