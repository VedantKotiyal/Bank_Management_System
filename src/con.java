import java.io.*;
import java.sql.*;
public class con {
    Connection c;
    Statement s;
    public con()throws IOException
    {
        try
        {
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagment","root","123");
            s=c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
