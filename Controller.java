//package backend;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import java.sql.*;
import java.util.*;
import java.io.*;
//import view.*;

public class Controller
{
   private AuthenticationModel auth;
   private DatabaseModel db;
   private FriendshipModel friendModel;
   private TweetModel tweetModel;
   private MainFrame view;

   public Controller(DatabaseModel db, AuthenticationModel auth, FriendshipModel friendModel, TweetModel tweetModel, MainFrame view)
   {
      this.db = db;
      this.auth = auth;
      this.view = view;
      this.friendModel = friendModel;
      this.tweetModel = tweetModel;

      this.view.addOnCreateAccountListener(signUpListener);
      this.view.addOnLoginListener(loginListener);
   }

   private ActionListener signUpListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) 
      {
         SignUpDTO dto = view.getSignUpInfo();
         Profile profile = dto.getProfile();
         Account account = dto.getAccount();

         User newUser = new User(account, profile);
         
         boolean registered = false;
         
         try
         {
            registered = auth.registerUser(newUser);
         }
         catch (SQLException ex)
         {
            System.out.println(ex);
            registered = false;
         }

         // failed to register
         if (!registered)
         {
            System.out.println("Failed to register user"); // debug
            view.displaySignUpError();
            return;
         }

         // TODO: Switch to user profile panel       
         view.hideSignUpError();
         view.switchToLoginScreen();
         System.out.println("User has been registered!"); // debug
      }
   };

   private ActionListener loginListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) 
      {
         LoginDTO dto = view.getLoginInfo();
         
         String username = dto.getUsername();
         String password = dto.getPassword();

         boolean authenticated = auth.authenticate(username, password);
         if (!authenticated)
         {
            System.out.println("Failed to authenticate user"); // debug
            view.displayLoginError();
            return;  
         }

         // TODO: Switch to user profile panel
         view.hideLoginError();
         
         String imgPath = db.getProfilePicture(username); 
         //String imgPath = "../User-Data/default.jpg"; 
         ImageIcon pic = getImage(imgPath, 175, 175);
         ArrayList<String> tweets = tweetModel.getUserTweets(username);
         ArrayList<String> following = friendModel.getFollowing(username);
         ArrayList<String> followers = friendModel.getFollowers(username);
         int numFollowing = friendModel.getNumberFollowing(username);
         int numOfFollowers = friendModel.getNumberOfFollowers(username);

         UserDTO userDto = new UserDTO(username, following, tweets, pic);
         view.switchToUserPage(userDto);
         //System.out.println("User logged in!");

      }
   };

   private ImageIcon getImage(String path, int width, int height) 
   {
      BufferedImage image = null;
      ImageIcon icon = null;

      try
      {
         image = ImageIO.read(new File(path));
         Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
         icon = new ImageIcon(newimg);
      }
      catch (IOException e)
      {
         System.out.println(e);
      }

      return icon;
   }
   
   public static void main(String[] args)
   {
      String driverName = "org.mariadb.jdbc.Driver";
      String jdbcUrl = "jdbc:mariadb://db1.mcs.slu.edu:3306/sarpongdk?user=%s&password=%s";
      String username = "sarpongdk";
      String password = "7E!9DMewEm";
      String connectionURL = String.format(jdbcUrl, username, password);
      
      DatabaseModel dbModel = new DatabaseModel(driverName, connectionURL, username, password);
      AuthenticationModel authModel = new AuthenticationModel(dbModel);
      FriendshipModel friendModel = new FriendshipModel(dbModel);
      TweetModel tweetModel = new TweetModel(dbModel);
      MainFrame view = new MainFrame();
      

      Controller controller = new Controller(dbModel, authModel, friendModel, tweetModel, view);
   }

}
