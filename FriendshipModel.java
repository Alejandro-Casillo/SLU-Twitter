import java.sql.*;
import java.util.*;

public class FriendshipModel
{
   private DatabaseModel model;

   public FriendshipModel(DatabaseModel model)
   {
      this.model = model;
   }

   public int getNumberFollowing(User user)
   {
      int numFollowing = -1;
      String username = user.getAccount().getUsername();
      String query = "SELECT COUNT(*) AS num_following FROM Follows AS F, Account AS A, User AS U WHERE A.username=? AND F.follower=U.id AND U.account_id = A.id;";
      try
      {
         PreparedStatement stmt = model.getConnection().prepareStatement(username); 
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
         System.out.println(ex);
         return -1;
      }
   }

   public int getNumberOfFollowers(User user)
   {
      int numFollowers = -1;
      String username = user.getAccount().getUsername();
      String query = "SELECT COUNT(*) AS num_followers FROM Follows AS F, Account AS A, User AS U WHERE A.username=? AND F.followee=U.id AND A.id = U.account_id;";
      try
      {
         PreparedStatement stmt = model.getConnection().prepareStatement(username); 
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
         System.out.println(ex);
         return -1;
      }
   
   }

   public ArrayList<String> getFollowers(User user)
   {
      String username = user.getAccount().getUsername();
      ArrayList<String> following = new ArrayList<>();
      String query = "SELECT username FROM Follows AS F, Account AS A, User AS U WHERE A.username=? AND F.followee=U.id;";
      try
      {
         PreparedStatement stmt = model.getConnection().prepareStatement(username); 
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

   public ArrayList<String> getFollowing(User user)
   {
      String username = user.getAccount().getUsername();
      ArrayList<String> following = new ArrayList<>();
      String query = "SELECT username FROM Follows AS F, Account AS A, User AS U WHERE A.username=? AND F.follower=U.id;";
      try
      {
         PreparedStatement stmt = model.getConnection().prepareStatement(username); 
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

   public boolean addFollowing(User follower, User followee)
   {
      // query to insert this following relationship into database
      return false;

      // return true if created, false if exception
   }

   public boolean unfollow(User follower, User followee)
   {
      // query to remove this following relationship from database
      return false;

      // return true if removed, false if exception
   }

   public static void main(String[] args)
   {
   
   }
}
