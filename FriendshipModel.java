import java.sql.*;
import java.util.*;

public class FriendshipModel
{
   private DatabaseModel model;

   public FriendshipModel(DatabaseModel model)
   {
      this.model = model;
   }

   public ArrayList<User> getFollowers(User user)
   {
      // find followers of given user

      // query to find user followers from followers table based on id

      // place followers into arraylist 

      // return arraylist

      // in the event of an exception or if no follower is found, return empty arraylist
   }

   public ArrayList<User> getFollowing(User user)
   {
      // find the people user is following

      // query to find people this user follows from followers table based on id and username

      // place following into arraylist 

      // return arraylist

      // in the event of an exception or if no follower is found, return empty arraylist
   }

   public boolean addFollowing(User follower, User followee)
   {
      // query to insert this following relationship into database

      // return true if created, false if exception
   }

   public boolean unfollow(User follower, User followee)
   {
      // query to remove this following relationship from database

      // return true if removed, false if exception
   }
}
