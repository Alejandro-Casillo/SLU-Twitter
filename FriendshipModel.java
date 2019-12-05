import java.sql.*;
import java.util.*;

public class FriendshipModel
{
   private DatabaseModel model;

   public FriendshipModel(DatabaseModel model)
   {
      this.model = model;
   }

   public int getNumberFollowing(String username)
   {
      int numFollowing = 0;
      String query = "SELECT COUNT(*) AS num_following FROM Follows AS F, Account AS A, User AS U WHERE A.username=? AND F.follower=U.id AND U.account_id = A.id;";
      try
      {
         PreparedStatement stmt = model.getConnection().prepareStatement(query); 
         stmt.setString(1, username);
         ResultSet rs = stmt.executeQuery();
         if (rs.next())
         {
            numFollowing = rs.getInt("num_following");
         }
         else 
         {
            numFollowing = 0;
         }

         return numFollowing;
      }
      catch (SQLException ex)
      {
         System.out.println("Give me a following count goddamnit");
         System.out.println(ex);
         return 0;
      }
   }

   public int getNumberOfFollowers(String username)
   {
      int numFollowers = 0;
      String query = "SELECT COUNT(*) AS num_followers FROM Follows AS F, Account AS A, User AS U WHERE A.username=? AND F.followee=U.id AND A.id = U.account_id;";
      try
      {
         PreparedStatement stmt = model.getConnection().prepareStatement(query); 
         stmt.setString(1, username);
         ResultSet rs = stmt.executeQuery();
         if (rs.next())
         {
            numFollowers = rs.getInt("num_followers");
         }
         else 
         {
            numFollowers = 0;
         }

         return numFollowers;
      }
      catch (SQLException ex)
      {
         System.out.println("Give me a followers count goddamnit");
         System.out.println(ex);
         return 0;
      }
   
   }

   public ArrayList<String> getFollowers(String username)
   {
      ArrayList<String> following = new ArrayList<>();
      String query = "SELECT A.username FROM Follows AS F, Account AS A, User AS U WHERE A.username=? AND F.followee=U.id AND A.id = U.account_id;";

      try
      {
         PreparedStatement stmt = model.getConnection().prepareStatement(query); 
         stmt.setString(1, username);
         ResultSet rs = stmt.executeQuery();
         while (rs.next())
         {
            String friend = rs.getString("username");
            following.add(friend);
         }

         return following;
      }
      catch (SQLException ex)
      {
         System.out.println(ex);
         return new ArrayList<String>();
      }
   }

   public ArrayList<String> getFollowing(String username)
   {
      ArrayList<String> following = new ArrayList<>();
      String query = "SELECT A.username FROM Follows AS F, Account AS A, User AS U WHERE A.username=? AND F.follower=U.id AND U.account_id = A.id;";

      try
      {
         PreparedStatement stmt = model.getConnection().prepareStatement(query); 
         stmt.setString(1, username);
         ResultSet rs = stmt.executeQuery();
         while (rs.next())
         {
            String friend = rs.getString("username");
            following.add(friend);
         }

         return following;
      }
      catch (SQLException ex)
      {
         System.out.println("I want friends, WTF!");
         System.out.println(ex);
         return new ArrayList<String>();
      }
   }

   public boolean follow(String follower, String followee)
   {
      // query to insert this following relationship into database
      try
      {
         String query = "INSERT INTO TABLE Follows (follower, followee) VALUES ( (SELECT U.id FROM User AS U, Account AS A WHERE A.username=? AND A.id = U.account_id), (SELECT U.id FROM User AS U, Account AS A WHERE A.username=? AND A.id = U.account_id) );";
         PreparedStatement stmt = model.getConnection().prepareStatement(query);
         stmt.setString(1, follower);
         stmt.setString(2, followee);
         stmt.executeUpdate();
         return true;
      }
      catch (SQLException e)
      {
         return false;
      }
   }

   public boolean unfollow(String follower, String followee)
   {
      try
      {
         String query = "DELETE FROM TABLE Follows WHERE follower IN (SELECT U.id FROM User AS U, Account AS A WHERE A.username = ? AND U.account_id = A.id) AND followee IN (SELECT U.id FROM User AS U, Account AS A WHERE A.username=? AND U.account_id = A.id);";
         PreparedStatement stmt = model.getConnection().prepareStatement(query);
         stmt.setString(1, follower);
         stmt.setString(2, followee);
         stmt.executeUpdate();
         return true;
      }
      catch (SQLException e)
      {
         System.out.println("Lmao, can't unfollow me!");
         System.out.println(e);
         return false;
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

      String followee = "osbornej";
      FriendshipModel friendModel = new FriendshipModel(model);
      System.out.println("Num Followers: " + friendModel.getNumberOfFollowers(dbUsername));
      System.out.println("Num Following: " + friendModel.getNumberFollowing(dbUsername));
      System.out.println("Followers: " + friendModel.getFollowers(dbUsername));
      System.out.println("Following: " + friendModel.getFollowing(dbUsername));
      System.out.println("Follow: " + friendModel.follow(dbUsername, followee));
   }
}
