//package backend;

import java.sql.*;
import java.util.*;

public class DatabaseModel {
   private String driverName;
   private String connectionURL;
   private Connection connection;
   private String username;
   private String password;

   public DatabaseModel(String driverName, String url, String username, String password) {
      this.driverName = driverName;
      this.connectionURL = url;
      this.username = username;
      this.password = password;
      this.connect(username, password);
   }

   private void connect(String username, String password) {
      try {
         TimeZone timeZone = TimeZone.getTimeZone("America/Chicago");
         TimeZone.setDefault(timeZone);
         Class.forName(driverName);
         this.connection = DriverManager.getConnection(connectionURL, username, password);
      } catch (Exception e) {
         System.out.println("Could not connection to database");
         System.out.println(e);
      }
   }

   public Connection getConnection() {
      return this.connection;
   }

   public String getProfilePicture(String username)
   {
      String query = "SELECT image_path FROM ProfilePicture AS P, User AS U, Account AS A WHERE A.username=? AND U.id = P.user_id AND A.id = U.account_id;";
      String path = "./User-Data/default.jpg";

      try
      {
         PreparedStatement stmt = this.connection.prepareStatement(query);
         stmt.setString(1, username);

         ResultSet rs = stmt.executeQuery();
         if (rs.next())
         {
            path = rs.getString("image_path");
         }
      }
      catch (SQLException e)
      {
         System.out.println(e);
         return "/User-Data/default.jpg";
      }

      return path;
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
