import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;

public class UserPagePanel extends JPanel
{
   public static final int FONT_SIZE = 54;
	public JPanel upperPanel, lowerPanel, profilePicPanel, friendPanel, mainPanel, usernamePanel;
	public JLabel profilePic, friendText, mainText, usernameLabel;
	private Image image;
	private ArrayList <String> friendList;
	public JScrollPane scroller, friendScroll;

	public UserPagePanel()
	{
		upperPanel = new JPanel();
		lowerPanel = new JPanel(); 
      usernamePanel = new JPanel();
		profilePicPanel = new JPanel();
		friendPanel = new JPanel();
		mainPanel = new JPanel();


      usernameLabel = new JLabel("Welcome");
      usernameLabel.setForeground(Color.WHITE);
      usernameLabel.setFont(new Font("Tahoma", FONT_SIZE, Font.BOLD));
      usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);

		profilePic = new JLabel();
		//friendText = new JLabel("Friend List");
		//mainText = new JLabel("This is where main tweets go");

		friendList = new ArrayList<>();
		scroller = new JScrollPane();

		upperPanel.setBounds(0, 0, MainFrame.MAX_WIDTH, 250);
		upperPanel.setLayout(null);
		upperPanel.setBackground(new Color(0, 0, 204));

		lowerPanel.setBounds(0, 250, MainFrame.MAX_WIDTH, MainFrame.MAX_HEIGHT);
		lowerPanel.setLayout(null);
		lowerPanel.setBackground(new Color(51, 153, 255));

		mainPanel.setBounds(50, 95, 450, 400);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBackground(Color.WHITE);

		profilePicPanel.setBounds(50, 150, 175, 175);
		profilePicPanel.setLayout(new FlowLayout());
		//profilePicPanel.setBackground(Color.WHITE);

		friendPanel.setBounds(525, 95, 200, 300);
		friendPanel.setLayout(new FlowLayout());
      friendScroll = new JScrollPane(friendPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      friendScroll.setBounds(525, 95, 200, 350);

		profilePic.setHorizontalAlignment(SwingConstants.CENTER) ;
		profilePic.setVerticalAlignment(SwingConstants.CENTER);
		profilePic.setFont(new Font("Tahoma", Font.PLAIN, 30));

		profilePicPanel.add(profilePic);
      //profilePicPanel.add(usernameLabel);
		profilePicPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

      upperPanel.add(usernameLabel);

		//friendPanel.add(friendText);
		//mainPanel.add(mainText);

		lowerPanel.add(friendScroll);
		lowerPanel.add(mainPanel);
      //lowerPanel.add(new JLabel("SLU-Twitter"));

		add(profilePicPanel);
		add(upperPanel);
		add(lowerPanel);
		
		setLayout(null);
		setBounds(0, 0, MainFrame.MAX_WIDTH, MainFrame.MAX_HEIGHT);
	}

   public void setProfileImage(ImageIcon icon)
   {
      profilePic.setIcon(icon);
   }

   public void setUsername(String username)
   {
      usernameLabel.setText("Welcome, " + username);
   }

   public void setTweets(ArrayList<String> tweets)
   {
      for (int i = 0; i < tweets.size(); i++)
      {
         String tweet = tweets.get(i);
         JLabel message = new JLabel(tweet);
         JPanel tweetPanel = new JPanel();
         tweetPanel.add(message);
         mainPanel.add(tweetPanel);
      }
   }

   public void setFollowing(ArrayList<String> following)
   {
      for (int i = 0; i < following.size(); i++)
      {
         JPanel friend = new JPanel();
         JButton unfollow = new JButton("Unfollow");
         JLabel username = new JLabel(following.get(i));

         friend.add(username);
         friend.add(unfollow);
         friendPanel.add(friend);
      } 
   }
}
