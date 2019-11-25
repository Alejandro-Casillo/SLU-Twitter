//package backend.db;

import java.sql.*;
import java.util.*;

public class DatabaseModel 
{
   private String driverName;
   private String connectionURL;
   private Connection connection;
   private String username;
   private String password;

   public DatabaseModel(String driverName, String url, String username, String password) 
   {
      this.driverName = driverName;
      this.connectionURL = url;
      this.username = username;
      this.password = password;
      this.connect(username, password);
   }

   private void connect(String username, String password)
   {
      try
      {
         TimeZone timeZone = TimeZone.getTimeZone("America/Chicago");
	 TimeZone.setDefault(timeZone);
         Class.forName(driverName);
         this.connection = DriverManager.getConnection(connectionURL, username, password);
      }
	  catch (Exception e)
      {
         System.out.println("Could not connection to database");
         System.out.println(e);
      }
   }

   public Connection getConnection()
   {
      return this.connection;
   }

   public static void main(String[] args)
   {
      String driverName = "org.mariadb.jdbc.Driver";
      String jdbcUrl = "jdbc:mariadb://db1.mcs.slu.edu:3306/sarpongdk?user=%s&password=%s";
      String username = "sarpongdk";
      String password = "7E!9DMewEm";
      String connectionURL = String.format(jdbcUrl, username, password);
      System.out.println(connectionURL);
      
      DatabaseModel model = new DatabaseModel(driverName, connectionURL, username, password);
      model.getConnection();
   }

}
