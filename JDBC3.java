import java.io.*;
import java.sql.*;

class JDBC3
{
	public static void main(String[] args) throws NumberFormatException, IOException {
			// TODO Auto-generated method stub
			Connection con;
			ResultSet rs;
			Statement st;
			int num=0,age=0,ch=0,i=0;
			String nam;
			DataInputStream ip=new DataInputStream(System.in);
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				
			}
			catch(Exception e)
			{
				System.out.println("Error 1:"+e);
				
			}
	do
	{
		System.out.println("\n\t\t1.Create");
		System.out.println("\n\t\t2.Add");
		System.out.println("\n\t\t3.Modify");
		System.out.println("\n\t\t4.Display");
		System.out.println("\n\t\t5.Delete");
		System.out.println("\n\t\t6.Exit");
		System.out.println("\n\t\t1.Enter your code");
		ch=Integer.parseInt(ip.readLine());
		switch(ch)
		{
		case 1:
			System.out.println("\n\t\tCreation \n");
			try
			{
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/nexadb","root","");
				st=con.createStatement();
				i=st.executeUpdate("create table Freshers(ecode int,name nvarchar(25),age int)");
				System.out.println("\t\t\ttable Created . ");
				st.close();
				con.close();
			}
			catch (Exception e)
			{
				System.out.println("creation error:"+e);
			}
			break;
		case 2:
			System.out.print("\n\t\tAdd Record\n");
			System.out.print("Emp Code : ");
			num=Integer.parseInt(ip.readLine());
			System.out.print("Name  :");
			nam=ip.readLine();
			System.out.print("Age  : ");
			age=Integer.parseInt(ip.readLine());
			try
			{
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/nexadb","root","");
			st=con.createStatement();
			i=st.executeUpdate("insert into Freshers values("+num+",'"+nam+"',"+age+")");
			System.out.println("\t\tRecord Added ");
			st.close();
			con.close();
			}
			catch(Exception e)
			{
			System.out.println("Add record Error : "+e);
			}
			break;
			
		case 3:
			System.out.println("\n\t\tModification \n");
			System.out.print("\t\tEmp Number : ");
			num=Integer.parseInt(ip.readLine());                                               
			System.out.print("Name  :");
			nam=ip.readLine();
			System.out.print("Age  : ");
			age=Integer.parseInt(ip.readLine());
			try
			{
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/nexadb","root","");
			st=con.createStatement();
			i=st.executeUpdate("update Freshers set name='"+nam+"',age="+age+" where ecode="+num);

			if(i==1)
			System.out.println("\t\tRecord Modified ");
			st.close();
			con.close();
			}
			catch(Exception e)
			{
			System.out.println("Modification Error : "+e);
			}
			break;
			
		case 4:
			System.out.println("\n\t\tTable View \n");
			try
			{
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/nexadb","root","");
			st=con.createStatement();
			rs=st.executeQuery("select * from Freshers");
			int j=1;
			while(rs.next())
			{
			System.out.println("\tRecord :  "+j);
			System.out.println("\tEmp Number : "+rs.getInt(1));
			System.out.println("\tName  : "+rs.getString(2));
			System.out.println("\tAge : "+rs.getInt(3)+"\n");
			j+=1;
			}
			st.close();
			con.close();
			}
			catch(Exception e)
			{
			System.out.println("View Error : "+e);
			}
			break;
		case 5:
			System.out.println("\n\t\tDeletion \n");
			System.out.println("\nRoll Number : \n");
			num=Integer.parseInt(ip.readLine());
			try
			{
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/nexadb","root","");
					st=con.createStatement();
			i=st.executeUpdate("delete from Freshers where ecode="+num);
			if(i==1)
			System.out.println("\t\t Record Deleted");
			st.close();
			con.close();
			}
			catch(Exception e)
			{
			System.out.println("Deletion Error : "+e);
			}
			break;		
		}
	}
	while(ch<6);
		}
	}