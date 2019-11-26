import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MainFrame 
{
   public JFrame mainframe = new JFrame("SLU Twitter");
   public LogIn login;
   public SignUp signup;

   public MainFrame()
   {
      login = new LogIn();
      signup = new SignUp();

      mainframe.add(login);

      mainframe.setBounds(0, 0, 750, 750);
      mainframe.setDefaultCloseOperation(mainframe.EXIT_ON_CLOSE);
		
      mainframe.setVisible(true);

      switchToSignUp();
      switchToLogIn();
   }

   public void switchToSignUp()
   {
      login.createAccount.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            mainframe.setVisible(false);
            mainframe.remove(login);
            mainframe.add(signup);
            mainframe.setVisible(true);
         }
      });
   }

   public void switchToLogIn()
   {
      signup.logIn.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            mainframe.setVisible(false);
            mainframe.remove(signup);
            mainframe.add(login);
            mainframe.setVisible(true);
         }
      });
   }
}
