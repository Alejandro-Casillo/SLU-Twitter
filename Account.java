//package backend;

import java.util.Calendar;

public class Account
{
   private String username, password;
   private Calendar dateCreated;
   private User user;

   public Account(String username, String password)
   {
      this.username = username;
      this.password = password;
      this.dateCreated = Calendar.getInstance();
   }

   public void setUser(User user)
   {
      this.user = user;
   }

   public User getUser()
   {
      return this.user;
   }

   public Calendar getDateCreated()
   {
      return dateCreated;
   }

   public String getUsername()
   {
      return username;
   }

   public String getPassword()
   {
      return password;
   }

   public String toString()
   {
      String str = "User Account\nUsername: %s\nPassword: %s";
      String out = String.format(str, username, password);
   
      return out;
   }

   public static void main(String[] args)
   {
      String username = "fakeusername";
      String password = "password";
      Account account = new Account(username, password);

      System.out.println(account);
   }
}
