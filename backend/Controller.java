import java.swing.*;
import java.awt.*;
import java.awt.event.*;

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

   private ActionListener signUpListener = new ActionListener {
      public void actionPerformed(ActionEvent e) 
      {
         SignUpDTO dto = view.getSignUpInfo();
         Profile profile = dto.getProfile();
         Account account = dto.getAccount();

         User newUser = new User(account, profile);
         boolean registered = auth.registerUser(user);

         // failed to register
         if (!registered)
         {
            view.displaySignUpError();
            return;
         }

         // TODO: Switch to user profile panel       
      }
   }

   private ActionListener loginListenerListener = new ActionListener {
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
      }
   }


}
