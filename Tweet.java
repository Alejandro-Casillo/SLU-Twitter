import java.sql.*;
import java.util.*;

public class Tweet
{
   private int likes;
   private String content, username;
   private Calendar datePosted;
   
   public Tweet(String content, String username)
   {
      this.content = content;
      this.username = username; 
      this.likes = 0;
      this.datePosted = Calendar.getInstance();
   }

   public Tweet(String content, String username, Calendar datePosted)
   {
      this.content = content;
      this.username = username;
      this.likes = 0;
      this.datePosted = datePosted;
   }

   public Calendar getDatePosted()
   {
      return this.datePosted;
   }

   public void setDatePosted(Calendar date)
   {
      this.datePosted = date;
   }

   public int getLikes()
   {
      return likes;
   }

   public void setLikes(int likes)
   {
      this.likes = likes;
   }

   public String getContent()
   {
      return this.content;
   }

   public String getUsername()
   {
      return this.username;
   }

   // TODO: Tweet render method
   public void render()
   {
      // create tweet ui and return it or add it to panel
   }

   public String toString()
   {
      String str = "Tweet\nUser: %s\nContent: %s\n";
      String out = String.format(str, username, content);

      return out;
   }

   public static void main(String[] args)
   {
   
   }
}
