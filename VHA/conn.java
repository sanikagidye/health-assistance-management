package VHA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    conn()
    {
        String url="jdbc:mysql://localhost:3306/vha_sys";
        String username="root";
        String password = "Minnu%1122";

        try
        {
            c= DriverManager.getConnection(url,username,password);
            s=c.createStatement();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {

        new conn();
    }

}
