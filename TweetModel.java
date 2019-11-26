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

   private Image[] getTweetImages(int[] tweetIds)
   {
      // retrieve images from database based on id

      // convert into images to be rendered by tweet

      // put images in arrayList and return
   }

   public ArrayList<Tweet> getUserTweets(User user)
   {
      // retrieve tweets based on username and user id

      // obtain user images per tweet using above private method

      // create tweet objects for each tweet

      // put tweets in arrayList and return them
   }

   public boolean deleteTweet(Tweet tweet)
   {
      // query to delete tweet from database

      // return true if deleted, false otherwise and in exception
   }

   public boolean createTweet(Tweet tweet)
   {
      // query to add tweet to database

      // return true if create, false otherwise or in case of exception
   }

   public boolean updateTweet(Tweet oldTweet, Tweet newTweet)
   {
      // query to find old tweet

      // update tweet

      // query to insert new tweet

      // return true if update, false otherwise and in exception
   }

   public static void main(String[] args)
   {
   
   }
}
