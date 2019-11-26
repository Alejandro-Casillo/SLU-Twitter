import javax.swing.*;
import java.awt.*;

public class SignUp extends JPanel
{
   private JTextField fnametxt, lnametxt, usernametxt, passwordtxt, dateOfBirthtxt;
   private JLabel title, fname, lname, username, password, dateOfBirth, hasAccount;
   private JLabel errorMsg;
   private JButton signUp, logIn;
   private JPanel info, titlePanel, needsLogIn;

   public SignUp()
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
      dateOfBirth = new JLabel("Birthday: ");

      fnametxt = new JTextField();
      lnametxt = new JTextField();
      usernametxt = new JTextField();
      passwordtxt = new JPasswordField();
      dateOfBirthtxt = new JTextField();

      info = new JPanel();
      info.setLayout(new GridLayout(5, 2));
      info.setBounds(255, 350, 250, 150);
      info.setBackground(new Color(51, 153, 255));

      needsLogIn = new JPanel();
      needsLogIn.setLayout(new GridLayout(3, 1));
      needsLogIn.setBounds(250, 525, 300, 100);
      needsLogIn.setBackground(new Color(51, 153, 255));

      needsLogIn.add(signUp);
      needsLogIn.add(errorMsg);
      needsLogIn.add(hasAccount);
      needsLogIn.add(logIn);

      info.add(fname);
      info.add(fnametxt);
      info.add(lname);
      info.add(lnametxt);
      info.add(username);
      info.add(usernametxt);
      info.add(password);
      info.add(passwordtxt);
      info.add(dateOfBirth);
      info.add(dateOfBirthtxt);

      setLayout(null);
      setBackground(new Color(51, 153, 255));
      add(titlePanel);
      add(needsLogIn);
      add(info);
   }

   public void displayError(String txt)
   {
      errorMsg.setText(txt);
      errorMsg.setVisible(true);
   }

   public String getUsername()
   {
      return usernametxt.getText();
   }

   public String getPassword()
   {
      return String.valueOf(passwordtxt.getPassword());
   }

   private String capitalize(String word)
   {
      String capitalized = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
      return capitalized;
   }

   public String getName()
   {
      String firstName = this.capitalize(fnametxt.getText());
      String lastName = this.capitalize(lnametxt.getText());

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
}
