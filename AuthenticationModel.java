//package backend;

import java.sql.*;
import java.util.*;

//import backend.domain.*;

public class AuthenticationModel
{
   private DatabaseModel model;

   public AuthenticationModel(DatabaseModel model)
   {
      this.model = model;
   }

   public boolean authenticate(String username, String password)
   {
      try
      {
         String query = "SELECT * FROM sarpongdk.Account WHERE username=? AND password=?;";
         PreparedStatement stmt = model.getConnection().prepareStatement(query);
         stmt.setString(1, username);
         stmt.setString(2, password);
         ResultSet result = stmt.executeQuery();

         if (result.next())
         {
            return true;
         }

         return false;
      }
      catch (SQLException e)
      {
         System.out.println(e);
         return false;
      }
   }

   public boolean registerUser(User user) throws SQLException
   {
      try
      {
         // preparing transaction
         model.getConnection().setAutoCommit(false);

         Account account = user.getAccount();
         Profile profile = user.getProfile();

         // get account details
         String username = account.getUsername();
         String password = account.getPassword();
         Calendar dateCreated = account.getDateCreated();

         // get profile details
         String name = profile.getName();
         Calendar dob = profile.getDateOfBirth();
         int numFollowers = profile.getNumOfFollowers();
         int numFollowing = profile.getNumFollowing();

         // insert account into database
         String accountQuery = "INSERT INTO sarpongdk.Account (username, password, date_created) VALUES (?, ?, ?);";
         PreparedStatement aStmt = model.getConnection().prepareStatement(accountQuery, Statement.RETURN_GENERATED_KEYS);

         java.sql.Date accountDate = new java.sql.Date(dateCreated.getTime().getTime()); // conversion to sql date
         aStmt.setString(1, username);
         aStmt.setString(2, password);
         aStmt.setDate(3, accountDate);
         int accountID = aStmt.executeUpdate();
         ResultSet rs = aStmt.getGeneratedKeys();
         if (rs.next()) 
         {
            accountID = rs.getInt(1);
         }
         else
         {
            return false;
         }
         //System.out.println("Account ID: " + accountID); // debug

         try 
         {
            model.getConnection().commit();
         }
         catch (SQLException e)
         {
            //System.out.println(e);
            return false;
         }

         // insert user profile into database
         String profileQuery = "INSERT INTO sarpongdk.User (name, num_following, num_followers, dob, account_id) VALUES (?, ?, ?, ?, ?);";
         PreparedStatement pStmt = model.getConnection().prepareStatement(profileQuery, Statement.RETURN_GENERATED_KEYS);

         java.sql.Date userDOB = new java.sql.Date(dob.getTime().getTime()); // conversion to sql date from calendar
         pStmt.setString(1, name);
         pStmt.setInt(2, numFollowing);
         pStmt.setInt(3, numFollowers);
         pStmt.setDate(4, userDOB);
         pStmt.setInt(5, accountID);
         int userID = pStmt.executeUpdate();

         model.getConnection().commit();
         return true; // successfully registered user
      }
      catch (SQLException e)
      {
         //System.out.println(e);
         model.getConnection().rollback();
         return false; // unsuccessful registration
      }
      finally
      {
         model.getConnection().setAutoCommit(true);
      }
   }

   public static void main(String[] args)
   {
      // MariaDB Connection
      String driverName = "org.mariadb.jdbc.Driver";
      String jdbcUrl = "jdbc:mariadb://db1.mcs.slu.edu:3306/sarpongdk";
      String dbUsername = "sarpongdk";
      String dbPassword = "7E!9DMewEm";
      String connectionURL = String.format(jdbcUrl, dbUsername, dbPassword);
      DatabaseModel model = new DatabaseModel(driverName, connectionURL, dbUsername, dbPassword);

      // User obj creation
      String username = "fakeusername";
      String password = "password";
      Account account = new Account(username, password);
      Calendar dob = Calendar.getInstance();
      dob.set(1999, 9, 3);
      String name = "David Sarpong";
      Profile profile = new Profile(name, dob);
      User user = new User(account, profile);

      // AuthenticationModel
      AuthenticationModel authentication = new AuthenticationModel(model);

      try 
      {
         boolean registered = authentication.registerUser(user); // account creation and registration
         System.out.println(String.format("Registration: %s", registered));
      }
      catch (SQLException e)
      {
         System.out.println(e);
      }

      boolean authenticated = authentication.authenticate(username, password);
      System.out.println(String.format("Authenticated: %s", authenticated));
   }
}
