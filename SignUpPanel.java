//package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.util.*;

import org.jdatepicker.*;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;

public class SignUpPanel extends JPanel
{
   private JTextField fNameField, lNameField, usernameField, dobField;
   private JPasswordField passwordField;
   private JLabel title, fname, lname, username, password, dateOfBirth, hasAccount;
   private JLabel errorMsg;
   private JButton signUp, logIn;
   private JPanel infoPanel, titlePanel, needsLoginPanel;
   
   // Date picker
   private JDatePicker dobPicker;
   private JDatePanelImpl datePanel;
   private UtilDateModel dateModel;

   public SignUpPanel()
   {
      super();
      title = new JLabel("SLU Twitter");
      titlePanel = new JPanel();

      signUp = new JButton("Sign Up");
      hasAccount = new JLabel("Already have an account? Log in here!");
      hasAccount.setHorizontalAlignment(SwingConstants.CENTER);
      hasAccount.setVerticalAlignment(SwingConstants.CENTER);
      logIn = new JButton("Log In");

      // error message display
      errorMsg = new JLabel("Username is already in use!");
      errorMsg.setHorizontalAlignment(SwingConstants.CENTER);
      errorMsg.setVerticalAlignment(SwingConstants.CENTER);
      errorMsg.setForeground(Color.RED);
      errorMsg.setFont(new Font("Arial", Font.BOLD, 12));
      errorMsg.setVisible(false);      

      // title
      titlePanel.setBounds(0, 0, 750, 200);
      titlePanel.setLayout(null);
      titlePanel.setBackground(new Color(0, 0, 204));

      title.setBounds(0, 0, 750 ,200);
      title.setFont(new Font("Tahoma", Font.PLAIN, 50));
      title.setForeground(Color.WHITE);
      title.setHorizontalAlignment(SwingConstants.CENTER);
      title.setVerticalAlignment(SwingConstants.CENTER);

      titlePanel.add(title);

      fname = new JLabel("First Name: ");
      lname = new JLabel("Last Name: ");
      username = new JLabel("Username: ");
      password = new JLabel("Password: ");
      dateOfBirth = new JLabel("Birthday (mm/dd/yyyy): ");

      fNameField = new JTextField();
      lNameField = new JTextField();
      usernameField = new JTextField();
      passwordField = new JPasswordField();
      dobField = new JTextField();

      infoPanel = new JPanel();
      infoPanel.setLayout(new GridLayout(5, 2));
      infoPanel.setBounds(255, 350, 250, 150);
      infoPanel.setBackground(new Color(51, 153, 255));

      needsLoginPanel = new JPanel();
      needsLoginPanel.setLayout(new GridLayout(4, 1));
      needsLoginPanel.setBounds(250, 525, 300, 100);
      needsLoginPanel.setBackground(new Color(51, 153, 255));

      needsLoginPanel.add(signUp);
      needsLoginPanel.add(errorMsg);
      needsLoginPanel.add(hasAccount);
      needsLoginPanel.add(logIn);

      // date picker settings
      Properties properties = new Properties();
      properties.put("text.today", "Today");
      properties.put("text.month", "Month");
      properties.put("text.year", "Year");
      dateModel = new UtilDateModel();
      datePanel = new JDatePanelImpl(dateModel, properties);
      dobPicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

      infoPanel.add(fname);
      infoPanel.add(fNameField);
      infoPanel.add(lname);
      infoPanel.add(lNameField);
      infoPanel.add(username);
      infoPanel.add(usernameField);
      infoPanel.add(password);
      infoPanel.add(passwordField);
      infoPanel.add(dateOfBirth);
      infoPanel.add((JComponent) dobPicker);

      setLayout(null);
      setBackground(new Color(51, 153, 255));
      add(titlePanel);
      add(needsLoginPanel);
      add(infoPanel);
   }

   public void displayError(String txt)
   {
      errorMsg.setText(txt);
      errorMsg.setVisible(true);
   }

   public void hideError()
   {
      errorMsg.setVisible(false);
   }

   public String getUsername()
   {
      return usernameField.getText();
   }

   public String getPassword()
   {
      return String.valueOf(passwordField.getPassword());
   }

   private String capitalize(String word)
   {
      String capitalized = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
      return capitalized;
   }

   public String getName()
   {
      String firstName = this.capitalize(fNameField.getText());
      String lastName = this.capitalize(lNameField.getText());

      String fullname = String.format("%s %s", firstName, lastName);
      return fullname;
   }

   public void addLoginActionListener(ActionListener listener)
   {
      logIn.addActionListener(listener);
   } 

   public void addCreateAccountListener(ActionListener listener)
   {
      signUp.addActionListener(listener);
   }

   //TODO: get DOB
   public Calendar getDateOfBirth()
   {
      Date dob = (Date) dobPicker.getModel().getValue();
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(dob);
      return calendar;
   }

   public void clear()
   {
      fNameField.setText("");
      lNameField.setText("");
      usernameField.setText("");
      passwordField.setText("");
      //TODO: Reset JDatePicker
      //dobPicker.getJFormattedTextField().setText();
   }
}
