import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;

public class UserPagePanel extends JPanel
{
	public JPanel upperPanel, lowerPanel, profilePic, friendPanel, mainPanel;
	public JLabel imageText, friendText, mainText, usernameLabel;
	private Image image;
	private ArrayList <String> friendList;
	public JScrollPane scroller;

	public UserPagePanel()
	{
		upperPanel = new JPanel();
		lowerPanel = new JPanel(); //redundant?
		profilePic = new JPanel();
		friendPanel = new JPanel();
		mainPanel = new JPanel();

      usernameLabel = new JLabel();
		imageText = new JLabel("No Image :(");
		friendText = new JLabel("Friend List");
		mainText = new JLabel("This is where main tweets go");

		friendList = new ArrayList<>();
		scroller = new JScrollPane();

		upperPanel.setBounds(0, 0, 750, 250);
		upperPanel.setLayout(null);
		upperPanel.setBackground(new Color(0, 0, 204));

		lowerPanel.setBounds(0, 250, 750, 500);
		lowerPanel.setLayout(null);
		lowerPanel.setBackground(new Color(51, 153, 255));

		mainPanel.setBounds(50, 95, 450, 400);
		mainPanel.setLayout(new FlowLayout());
		mainPanel.setBackground(Color.WHITE);

		profilePic.setBounds(50, 150, 175, 175);
		profilePic.setLayout(new FlowLayout());
		profilePic.setBackground(Color.WHITE);

		friendPanel.setBounds(525, 95, 200, 300);
		friendPanel.setLayout(new FlowLayout());

		imageText.setHorizontalAlignment(SwingConstants.CENTER) ;
		imageText.setVerticalAlignment(SwingConstants.CENTER);
		imageText.setFont(new Font("Tahoma", Font.PLAIN, 30));

		profilePic.add(imageText);
      profilePic.add(usernameLabel);
		profilePic.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		friendPanel.add(friendText);
		mainPanel.add(mainText);

		lowerPanel.add(friendPanel);
		lowerPanel.add(mainPanel);

		add(profilePic);
		add(upperPanel);
		add(lowerPanel);
		
		setLayout(null);
		setBounds(0, 0, 750, 750);
	}

   public void setProfileImage(Image img)
   {
      ImageIcon icon = new ImageIcon(img);
      imageText.setIcon(icon);
   }

   public void setUsername(String username)
   {
      usernameLabel.setText(username);
   }

   public void setFriendsList(ArrayList<String> friendsList)
   {
      friendList = friendsList;
   }
}
