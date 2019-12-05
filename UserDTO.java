import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

public class UserDTO
{
   private String username;
   private ArrayList<String> following, tweets;
   private ImageIcon pic;

   public UserDTO(String username, ArrayList<String> following, ArrayList<String> tweets, ImageIcon pic)
   {
      this.username = username;
      this.following = following;
      this.pic = pic;
      this.tweets = tweets;
   }

   public String getUsername()
   {
      return username;
   }

   public ImageIcon getProfilePicture()
   {
      return pic;
   }
   
   public ArrayList<String> getFollowing()
   {
      return this.following;
   }

   public ArrayList<String> getTweets()
   {
      return this.tweets;
   }
}
