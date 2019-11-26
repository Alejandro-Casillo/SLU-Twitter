import java.sql.*;
import java.util.*;
import java.awt.*;

public class Tweet
{
   private int likes;
   private String content;
   private User user;
   private Image image;
   private Calendar datePosted;
   private boolean hasImage;
   
   public Tweet(String content, User user, Image image)
   {
      this.content = content;
      this.user = user; 
      this.image = image;
      this.likes = 0;
      this.datePosted = Calendar.getInstance();
      this.hasImage = image != null ? true : false;
   }

   public Calendar getDatePosted()
   {
      return this.datePosted;
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

   public User getUser()
   {
      return this.user;
   }

   public void addImage(Image image)
   {
      if (!hasImage)
      {
         this.image = image;
         this.hasImage = true;
      }

      return;
   }

   public Image getImage()
   {
      return this.image;
   }

   // TODO: Tweet render method
   public void render()
   {
      // create tweet ui and return it or add it to panel
   }

   public String toString()
   {
      String str = "Tweet\nUser: %s\nContent: %s\n";
      String out = String.format(str, user.getUsername(), content);

      return out;
   }

   public static void main(String[] args)
   {
   
   }
}
