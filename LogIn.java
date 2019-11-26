//package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LogIn extends JPanel
{
   private JTextField usernametxt;
   private JPasswordField passwordtxt;
   private JLabel username, password, title, loginBtnTitle, needAccount;
   private JLabel errorMsg;
   private JButton loginBtn, createAccountBtn;
   private JPanel loginBtnInfo, titlePanel, miniTitlePanel, needsSignup;

   public LogIn()
   {
      title = new JLabel("SLU Twitter");
      needAccount = new JLabel("Don't have an account yet? Make one here!");
      needAccount.setHorizontalAlignment(SwingConstants.CENTER);
      needAccount.setVerticalAlignment(SwingConstants.CENTER);

      errorMsg = new JLabel("Username and password do not match!!");
      errorMsg.setHorizontalAlignment(SwingConstants.CENTER);
      errorMsg.setVerticalAlignment(SwingConstants.CENTER);
      errorMsg.setForeground(Color.RED);
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

      loginBtnTitle = new JLabel("Log In");
      loginBtnTitle.setFont(new Font("Tahoma", Font.PLAIN, 40));
      loginBtnTitle.setForeground(Color.WHITE);
      loginBtnTitle.setHorizontalAlignment(SwingConstants.CENTER);
      loginBtnTitle.setVerticalAlignment(SwingConstants.CENTER);

      miniTitlePanel = new JPanel();
      miniTitlePanel.setBounds(0, 200, 750, 100);
      miniTitlePanel.setLayout(null);
      miniTitlePanel.setBackground(new Color(51, 153, 255));

      username = new JLabel("Username: ");
      password = new JLabel("Password: ");

      usernametxt = new JTextField();
      passwordtxt = new JPasswordField();

      loginBtnInfo = new JPanel();
      loginBtnInfo.setLayout(new GridLayout(2, 2));
      loginBtnInfo.setBounds(255, 350, 250, 50);
      loginBtnInfo.setBackground(new Color(51, 153, 255));

      needsSignup = new JPanel();
      needsSignup.setLayout(new GridLayout(3, 1));
      needsSignup.setBounds(250, 425, 300, 100);
      needsSignup.setBackground(new Color(51, 153, 255));

      miniTitlePanel.add(loginBtnTitle);

      loginBtnInfo.add(username);
      loginBtnInfo.add(usernametxt);
      loginBtnInfo.add(password);
      loginBtnInfo.add(passwordtxt);

      needsSignup.add(loginBtn);
      needsSignup.add(errorMsg);
      needsSignup.add(needAccount);
      needsSignup.add(createAccountBtn);

      titlePanel.add(title);

      add(miniTitlePanel);
      add(needsSignup);
      add(loginBtnInfo);
      add(titlePanel);
   }

   public String getUsername()
   {
      return usernametxt.getText();
   }

   public String getPassword()
   {
      return String.valueOf(passwordtxt.getPassword());
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
