
package config;

import java.sql.*;


public class conexion {
    Connection con;
    
    public conexion(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia","root","1995");
        }
        catch(Exception e)
        {
           System.err.println("Error: "+ e);
        }
    }
    public Connection getConnection(){
        return con;
    }

}
