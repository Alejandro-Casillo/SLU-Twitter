import java.awt.*;
import java.util.*;

public class UserDTO
{
   private String username;
   private ArrayList<String> following;
   private Image pic;

   public UserDTO(String username, ArrayList<String> following, Image pic)
   {
      this.username = username;
      this.following = following;
      this.pic = pic;
   }

   public String getUsername()
   {
      return username;
   }

   public Image getProfilePicture()
   {
      return pic;
   }
   
   public ArrayList<String> getFollowing()
   {
      return this.following;
   }
}
