//package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//import backend.*;

public class MainFrame extends JFrame 
{
   private static final String TITLE = "SLU Twitter";

   //private JFrame this = new JFrame("SLU Twitter");
   private LogIn loginPanel;
   private SignUp signUpPanel;

   public MainFrame()
   {
      super(TITLE);
      loginPanel = new LogIn();
      signUpPanel = new SignUp();

      this.add(loginPanel);

      this.setBounds(0, 0, 750, 750);
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
      this.setVisible(true);

      onSwitchToSignUp();
      onSwitchToLogIn();
   }

   public SignUpDTO getSignUpInfo()
   {
      // TODO: fix dob
      String username = signUpPanel.getUsername(); 
      String password = signUpPanel.getPassword();
      String name = signUpPanel.getName();
      Calendar dob = null;
      SignUpDTO dto = new SignUpDTO(username, password, name, dob);

      return dto;   
   }

   public void displaySignUpError()
   {
      String msg = "Username already in use!";
      signUpPanel.displayError(msg);
   }

   public LoginInDTO getLoginInfo()
   {
      String username = loginPanel.getUsername();
      String password = loginPanel.getPassword();
      LoginInDTO dto = new LoginInDTO(username, password);

      return dto;
   }

   public void displayLoginError()
   {
      String msg = "Username/password do not match!";
      loginPanel.displayError(msg);
   }

   public void addOnCreateAccountListener(ActionListener listener)
   {
      signUpPanel.addCreateAccountListener(listener);
   }

   public void addOnLoginListener(ActionListener listener)
   {
      loginPanel.addLoginListener(listener);
   }

   public void onSwitchToSignUp()
   {
      loginPanel.addCreateAccountListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            this.setVisible(false);
            this.remove(loginPanel);
            this.add(signUpPanel);
            this.setVisible(true);
         }
      });
   }

   public void onSwitchToLogIn()
   {
      signUpPanel.addLoginActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            this.setVisible(false);
            this.remove(signUpPanel);
            this.add(loginPanel);
            this.setVisible(true);
         }
      });
   }

   public static void main(String[] args)
   {
      MainFrame mainframe = new MainFrame();
   }
}
