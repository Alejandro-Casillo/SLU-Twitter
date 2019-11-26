//package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LogIn extends JPanel
{
   private JTextField usernameField;
   private JPasswordField passwordField;
   private JLabel username, password, title, loginTitle, needAccount;
   private JLabel errorMsg;
   private JButton loginBtn, createAccountBtn;
   private JPanel loginPanel, titlePanel, miniTitlePanel, signUpPanel;

   public LogIn()
   {
      title = new JLabel("SLU Twitter");
      needAccount = new JLabel("Don't have an account yet? Make one here!");
      needAccount.setHorizontalAlignment(SwingConstants.CENTER);
      needAccount.setVerticalAlignment(SwingConstants.CENTER);

      errorMsg = new JLabel("Username and password do not match!!");
      errorMsg.setHorizontalAlignment(SwingConstants.CENTER);
      errorMsg.setVerticalAlignment(SwingConstants.CENTER);
      errorMsg.setFont(new Font("Tahoma", Font.BOLD, 10));
      errorMsg.setForeground(Color.RED);
      errorMsg.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
      errorMsg.setVisible(false);      

      titlePanel = new JPanel();

      loginBtn = new JButton("Log in");
      createAccountBtn = new JButton("Create Account");

      setLayout(null);
      setBackground(new Color(51, 153, 255));

      titlePanel.setBounds(0, 0, 750, 200);
      titlePanel.setLayout(null);
      titlePanel.setBackground(new Color(0, 0, 204));

      title.setBounds(0, 0, 750 ,200);
      title.setFont(new Font("Tahoma", Font.PLAIN, 50));
      title.setForeground(Color.WHITE);
      title.setHorizontalAlignment(SwingConstants.CENTER);
      title.setVerticalAlignment(SwingConstants.CENTER);

      loginTitle = new JLabel("Log In");
      loginTitle.setFont(new Font("Tahoma", Font.PLAIN, 40));
      loginTitle.setForeground(Color.WHITE);
      loginTitle.setHorizontalAlignment(SwingConstants.CENTER);
      loginTitle.setVerticalAlignment(SwingConstants.CENTER);

      miniTitlePanel = new JPanel();
      miniTitlePanel.setBounds(0, 200, 750, 100);
      miniTitlePanel.setLayout(null);
      miniTitlePanel.setBackground(new Color(51, 153, 255));

      username = new JLabel("Username: ");
      password = new JLabel("Password: ");

      usernameField = new JTextField();
      passwordField = new JPasswordField();

      loginPanel = new JPanel();
      loginPanel.setLayout(new GridLayout(2, 2));
      loginPanel.setBounds(255, 350, 250, 50);
      loginPanel.setBackground(new Color(51, 153, 255));

      signUpPanel = new JPanel();
      signUpPanel.setLayout(new GridLayout(4, 1));
      signUpPanel.setBounds(250, 425, 300, 100);
      signUpPanel.setBackground(new Color(51, 153, 255));

      miniTitlePanel.add(loginTitle);

      loginPanel.add(username);
      loginPanel.add(usernameField);
      loginPanel.add(password);
      loginPanel.add(passwordField);

      signUpPanel.add(loginBtn);
      signUpPanel.add(errorMsg);
      signUpPanel.add(needAccount);
      signUpPanel.add(createAccountBtn);

      titlePanel.add(title);

      add(miniTitlePanel);
      add(signUpPanel);
      add(loginPanel);
      add(titlePanel);
   }

   public String getUsername()
   {
      return usernameField.getText();
   }

   public String getPassword()
   {
      return String.valueOf(passwordField.getPassword());
   }

   public void displayError(String txt)
   {
      errorMsg.setText(txt);
      errorMsg.setVisible(true);
   }

   public void addCreateAccountListener(ActionListener listener)
   {
      createAccountBtn.addActionListener(listener);
   }

   public void addLoginListener(ActionListener listener)
   {
      loginBtn.addActionListener(listener);
   }
}
