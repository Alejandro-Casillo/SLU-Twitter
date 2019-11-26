//package backend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
//import view.*;

public class Controller
{
   private AuthenticationModel auth;
   private DatabaseModel db;
   private MainFrame view;

   public Controller(DatabaseModel db, AuthenticationModel auth, MainFrame view)
   {
      this.db = db;
      this.auth = auth;
      this.view = view;

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
            view.displaySignUpError();
            return;
         }

         // TODO: Switch to user profile panel       
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
            view.displayLoginError();
            return;  
         }

         // TODO: Switch to user profile panel
         System.out.println("User logged in!");
      }
   };
   
   public static void main(String[] args)
   {
      String driverName = "org.mariadb.jdbc.Driver";
      String jdbcUrl = "jdbc:mariadb://db1.mcs.slu.edu:3306/sarpongdk?user=%s&password=%s";
      String username = "sarpongdk";
      String password = "7E!9DMewEm";
      String connectionURL = String.format(jdbcUrl, username, password);
      
      DatabaseModel dbModel = new DatabaseModel(driverName, connectionURL, username, password);
      AuthenticationModel authModel = new AuthenticationModel(dbModel);
      MainFrame view = new MainFrame();
      
      Controller controller = new Controller(dbModel, authModel, view);
   }

}