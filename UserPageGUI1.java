import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.*;
import javax.imageio.*;
import java.util.*;
public class UserPageGUI1 extends JPanel implements ActionListener
{
	public JPanel upperPanel, lowerPanel, profilePic, friendPanel, mainPanel;
	public JLabel imageText, friendText;
	private Image image;
	private ArrayList <JButton> friendList;
	public JScrollPane scroller;
	public JTextField writer;
	public JButton tweet;
	public JLabel name1;
	public JLabel followers1;



	public UserPageGUI1()
	{
	   upperPanel = new JPanel();
		lowerPanel = new JPanel(); //redundant?
		profilePic = new JPanel();
		friendPanel = new JPanel();
		mainPanel = new JPanel();
		writer = new JTextField();
		tweet = new JButton("Tweet!");
		tweet.addActionListener(this);

		imageText = new JLabel("No Image :(");
		friendText = new JLabel("Friend List");



		friendList = new ArrayList<JButton>();
		scroller = new JScrollPane();

		upperPanel.setBounds(0, 0, 750, 250);
		upperPanel.setLayout(null);
		upperPanel.setBackground(new Color(0, 0, 204));

		lowerPanel.setBounds(0, 250, 750, 500);
		lowerPanel.setLayout(null);
		lowerPanel.setBackground(new Color(51, 153, 255));

		mainPanel.setBounds(50, 100, 450, 400);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBackground(Color.WHITE);

		profilePic.setBounds(50, 50, 175, 175);
		profilePic.setLayout(new FlowLayout());
		profilePic.setBackground(Color.WHITE);

		friendPanel.setBounds(525, 95, 200, 300);
		friendPanel.setLayout(new FlowLayout());

		profilePic.add(imageText);
		profilePic.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		friendPanel.add(friendText);

		writer.setBounds(50, 25, 400, 50);
		tweet.setBounds(450,25,55,50);

		lowerPanel.add(friendPanel);
		lowerPanel.add(mainPanel);
		lowerPanel.add(writer);
		lowerPanel.add(tweet);

		add(profilePic);
		add(upperPanel);
		add(lowerPanel);
		
		setLayout(null);
		setBounds(0, 0, 750, 750);

	}
	void friends(ArrayList<String> array)
	{
		for (int i=0; i<array.size(); i++)
		{
			JLabel username = new JLabel(array.get(i));
			JPanel friend = new JPanel();
			JButton unfollow = new JButton("Unfollow");
			friend.add(username);
			friend.add(unfollow);
			friendPanel.add(friend);

		}
	}
	void extracttweets(ArrayList<String> tweets)
	{
		for(int i=0; i<tweets.size(); i++)
		{
			JLabel message = new JLabel(tweets.get(i));
			JPanel tweet = new JPanel();
			tweet.add(message);
			mainPanel.add(tweet);


		}
	}
	public void actionPerformed(ActionEvent e)
	{
		String textFieldValue = writer.getText();
		System.out.println(textFieldValue);
		JLabel txt = new JLabel(textFieldValue);
		JPanel create = new JPanel();
		create.setLayout(null);
		txt.setBounds(0,0,400,50);
		JButton delete = new JButton("Delete!");
		create.add(txt);
		create.add(delete);
		mainPanel.add(create);

	}
	public void setprofile(String name, String followers )
	{
		name1 = new JLabel(name);
		followers1 = new JLabel(followers);
		upperPanel.add(name1);
		upperPanel.add(followers1);
	}
	public static void main(String args[])
	{	
		JFrame frame = new JFrame();
	     UserPageGUI1 user = new UserPageGUI1();
	     ArrayList<String> array = new ArrayList<String> (5);
	     for(int i=0; i<5; i++)
	     {
	     	array.add("Jenna");
	     }
	     ArrayList<String> tweets = new ArrayList<String> (5);
	     for(int i=0; i<5; i++)
	     {
	     	tweets.add("I HATE DONALD TRUMP!");
	     }
	     //user.extracttweets(tweets);
	     user.friends(array);
	     user.setprofile("priya","100000");
	     frame.add(user);
	     frame.setBounds(0, 0, 750, 750);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     //frame.pack();
	     frame.setVisible(true);
	}

}
