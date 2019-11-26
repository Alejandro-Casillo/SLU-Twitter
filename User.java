//package backend;

import java.util.*;

public class User
{
   private Account account;
   private Profile profile;

   public User(Account account, Profile profile)
   {
      this.account = account;
      this.profile = profile;
   }

   public Account getAccount()
   {
      return this.account;
   }

   public Profile getProfile()
   {
      return this.profile;
   }

   public String toString()
   {
      String str = "User\nAccount: %s\nProfile: %s\n";
      String out = String.format(str, account.getUsername(), profile.getName());
      return out;
   }

   public static void main(String[] args)
   {
      String username = "fakeusername";
      String password = "password";
      Account account = new Account(username, password);

      Calendar dob = Calendar.getInstance();
      dob.set(1999, 9, 3); 
      String name = "David Sarpong";
      Profile profile = new Profile(name, dob);

      User user = new User(account, profile);
      System.out.println(user);
   }
}
