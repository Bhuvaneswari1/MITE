import java.sql.*;
import java.io.*;

public class JDBC6
 {

  public static void main (String args[])
   {
    try
    {
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=       DriverManager.getConnection("jdbc:odbc:Temp","","");
 Statement stm =con.createStatement();
stm.addBatch("insert into Emp(Eid,Ename) values ('106','Mala')");
stm.addBatch("insert into Emp(Eid,Ename) values ('107','Kala')");
stm.addBatch("insert into Emp(Eid,Ename) values ('108','Vimala')");
   
  int[] result =stm.executeBatch();
   
System.out.println("\nUsing Statement Object");
 System.out.println("------------------------------------------");
 for (int i=0;i<result.length;i++)
{
  System.out.println("Rows Affected by "+(i+1)+" sql statement"+ result[i]);
}

stm.close();

PreparedStatement ps=con.prepareStatement (" insert into Emp (Eid,Ename)values (?,?)");    
 System.out.println("");
   System.out.println("Using Prepare Statement Object");
    System.out.println("");
  
  ps.setString(1,"109");
   ps.setString(2,"Maha");

 ps.addBatch();
 int[] nu =ps.executeBatch();
for(int i=0;i<nu.length;i++)
{
System.err.println(" Rows affected by "+(i+1)+" sql statement"+ nu[i]);
}
con.close();
}
catch (BatchUpdateException bue)
{
 System.out.println (" batch error" +bue);
}

catch (SQLException sqle)
{
 System.out.println (" sql error" +sqle);
}
catch (Exception e)
{
 System.out.println (" error" +e);
}
}
}