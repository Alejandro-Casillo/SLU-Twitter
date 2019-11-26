//package backend;

import java.util.*;
import java.text.*;

public class Profile
{
   private String name;
   private Calendar dateOfBirth;
   private int numOfFollowers, numFollowing;
   private User user;

   public Profile(String name, Calendar dob)
   {
      this.name = name;
      this.dateOfBirth = dob;
      this.numOfFollowers = 0;
      this.numFollowing = 0;
      this.user = null;
   }

   public void setUser(User user)
   {
      this.user = user;
   }

   public User getUser()
   {
      return this.user;
   }

   public int getNumFollowing()
   {
      return this.numFollowing;
   }

   public void setNumFollowing(int following)
   {
      this.numFollowing = following;
   }

   public int getNumOfFollowers()
   {
      return this.numOfFollowers;
   }

   public void setNumOfFollowers(int followers)
   {
      this.numOfFollowers = followers;
   }

   public String getName()
   {
      return this.name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Calendar getDateOfBirth()
   {
      return this.dateOfBirth;
   }

   public void setDateOfBirth(Calendar dob)
   {
      this.dateOfBirth = dob;
   }

   public String getFormattedDOB()
   {
      DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
      return formatter.format(this.dateOfBirth.getTime());
   }  

   public String toString()
   {
      String out = String.format("User profile\nName: %s\nFollowers: %d\nFollowing: %d\nDate of Birth: %s\n", this.getName(), this.getNumOfFollowers(), this.getNumFollowing(), this.getFormattedDOB() );
      
      return out;
   }

   public static void main(String[] args)
   {
      Calendar dob = Calendar.getInstance();
      dob.set(1999, 9, 3);
      String name = "David Sarpong";
      Profile profile = new Profile(name, dob);
      
      System.out.println(profile);
   }

}
