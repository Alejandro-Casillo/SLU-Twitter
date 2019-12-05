import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

public class UserDTO
{
   private String username;
   private ArrayList<String> following;
   private ImageIcon pic;

   public UserDTO(String username, ArrayList<String> following, ImageIcon pic)
   {
      this.username = username;
      this.following = following;
      this.pic = pic;
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
}
