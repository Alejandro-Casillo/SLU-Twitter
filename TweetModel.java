import java.sql.*;
import java.util.*;
import java.awt.*;

public class TweetModel
{
   private DatabaseModel model;

   public TweetModel(DatabaseModel model)
   {
      this.model = model;
   }

   public ArrayList<String> getUserTweets(String username)
   {
      String query = "SELECT T.content, T.date_created, T.likes, A.username FROM Tweet AS T, User AS U, Account AS A WHERE U.id = T.user_id AND A.username = ? AND A.id = U.account_id;";
      ArrayList<String> tweets = new ArrayList<>();

      try
      {
         PreparedStatement stmt = model.getConnection().prepareStatement(query);
         stmt.setString(1, username);
         ResultSet rs = stmt.executeQuery();

         while (rs.next())
         {
            int likes = rs.getInt("likes");
            String content = rs.getString("content");
            String tUsername = rs.getString("username");
            java.sql.Date date = rs.getDate("date_create");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            
            tweets.add(content);
         }
      }
      catch (SQLException e)
      {
         System.out.println(e);
         return new ArrayList<String>();
      }

      return tweets;
   }

   public boolean createTweet(Tweet tweet)
   {
      try
      {
         String query = "INSERT INTO Tweet (content, date_created, likes, user_id) VALUES (?, ?, ?, (SELECT U.id FROM User AS U, Account AS A WHERE A.username = ? AND U.account_id = A.id));";

         int likes = tweet.getLikes();
         String username = tweet.getUsername();
         String content = tweet.getContent();
         Calendar date = tweet.getDatePosted();
         java.sql.Date tweetDate = new java.sql.Date(date.getTime().getTime());

         PreparedStatement stmt = model.getConnection().prepareStatement(query);
         stmt.setString(1, content);
         stmt.setDate(2, tweetDate);
         stmt.setInt(3, likes);
         stmt.executeUpdate();
         return true;
      }
      catch (SQLException e)
      {
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
   
      TweetModel tweetModel = new TweetModel(model);
      Tweet tweet = new Tweet("My first tweet", "sarpongdk");
      tweetModel.createTweet(tweet);
   }
}
