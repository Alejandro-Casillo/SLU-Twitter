import javax.swing.*;
import java.awt.*;
import java.util.*;

public class LogIn extends JPanel
{
	public JTextField usernametxt, passwordtxt;
	public JLabel username, password, title, logInTitle, needAccount;
	public JButton logIn, createAccount;
	public JPanel logInInfo, titlePanel, miniTitlePanel, needsSignup;

	public LogIn()
	{
		title = new JLabel("SLU Twitter");
		needAccount = new JLabel("Don't have an account yet? Make one here!");
		needAccount.setHorizontalAlignment(SwingConstants.CENTER);
		needAccount.setVerticalAlignment(SwingConstants.CENTER);

		titlePanel = new JPanel();

		logIn = new JButton("Log in");
		createAccount = new JButton("Create Account");

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

		logInTitle = new JLabel("Log In");
		logInTitle.setFont(new Font("Tahoma", Font.PLAIN, 40));
		logInTitle.setForeground(Color.WHITE);
		logInTitle.setHorizontalAlignment(SwingConstants.CENTER);
		logInTitle.setVerticalAlignment(SwingConstants.CENTER);

		miniTitlePanel = new JPanel();
		miniTitlePanel.setBounds(0, 200, 750, 100);
		miniTitlePanel.setLayout(null);
		miniTitlePanel.setBackground(new Color(51, 153, 255));

		username = new JLabel("Username: ");
		password = new JLabel("Password: ");

		usernametxt = new JTextField();
		passwordtxt = new JTextField();

		logInInfo = new JPanel();
		logInInfo.setLayout(new GridLayout(2, 2));
		logInInfo.setBounds(255, 350, 250, 50);
		logInInfo.setBackground(new Color(51, 153, 255));

		needsSignup = new JPanel();
		needsSignup.setLayout(new GridLayout(3, 1));
		needsSignup.setBounds(250, 425, 300, 100);
		needsSignup.setBackground(new Color(51, 153, 255));

		miniTitlePanel.add(logInTitle);

		logInInfo.add(username);
		logInInfo.add(usernametxt);
		logInInfo.add(password);
		logInInfo.add(passwordtxt);

		needsSignup.add(logIn);
		needsSignup.add(needAccount);
		needsSignup.add(createAccount);

		titlePanel.add(title);

		add(miniTitlePanel);
		add(needsSignup);
		add(logInInfo);
		add(titlePanel);
	}
}