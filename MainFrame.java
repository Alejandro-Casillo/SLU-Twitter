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
   private LoginPanel loginPanel;
   private SignUpPanel signUpPanel;

   public MainFrame()
   {
      super(TITLE);
      loginPanel = new LoginPanel();
      signUpPanel = new SignUpPanel();

      this.add(loginPanel);

      this.setBounds(0, 0, 750, 750);
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      this.setVisible(true);

      onSwitchToSignUpPanel();
      onSwitchToLoginPanel();
   }

   public SignUpDTO getSignUpInfo()
   {
      // TODO: fix dob
      String username = signUpPanel.getUsername(); 
      String password = signUpPanel.getPassword();
      String name = signUpPanel.getName();
      Calendar dob = signUpPanel.getDateOfBirth();
      SignUpDTO dto = new SignUpDTO(username, password, name, dob);

      return dto;   
   }

   public void displaySignUpError()
   {
      String msg = "Username already in use!";
      signUpPanel.displayError(msg);
   }

   public void hideSignUpError()
   {
      signUpPanel.hideError();
   }

   public LoginDTO getLoginInfo()
   {
      String username = loginPanel.getUsername();
      String password = loginPanel.getPassword();
      LoginDTO dto = new LoginDTO(username, password);

      return dto;
   }

   public void displayLoginError()
   {
      String msg = "Username/password do not match!";
      loginPanel.displayError(msg);
   }

   public void hideLoginError()
   {
      loginPanel.hideError();
   }

   public void addOnCreateAccountListener(ActionListener listener)
   {
      signUpPanel.addCreateAccountListener(listener);
   }

   public void addOnLoginListener(ActionListener listener)
   {
      loginPanel.addLoginListener(listener);
   }

   public void onSwitchToSignUpPanel()
   {
      loginPanel.addCreateAccountListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            setVisible(false);
            remove(loginPanel);
            add(signUpPanel);
            setVisible(true);
         }
      });
   }

   public void onSwitchToLoginPanel()
   {
      signUpPanel.addLoginActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            setVisible(false);
            remove(signUpPanel);
            add(loginPanel);
            setVisible(true);
         }
      });
   }

   public static void main(String[] args)
   {
      MainFrame mainframe = new MainFrame();
   }
}
