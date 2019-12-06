
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.*;
import javax.imageio.*;
import java.util.*;

public class Messenger1 extends JPanel implements ActionListener
{ 
	private JFrame frame;
	private JPanel user;
	private JTextField sender;
	private JButton enter;
	int a=0;
	public Messenger1()
	{
	frame = new JFrame();
	frame.setSize(new Dimension(750,750));
    user = new JPanel();
	user.setLayout(null);
	user.setBackground(Color.BLUE);
	enter = new JButton("Enter!");
	sender = new JTextField();
	sender.setBounds(-4,680,650,50);
	enter.setBounds(650,680,50,50);
	user.add(sender);
	user.add(enter);
	enter.addActionListener(this);
	frame.add(user);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);

	
	}

    public void actionPerformed(ActionEvent e)
    {
    	String message = sender.getText();
    	System.out.println(message);
    	JLabel text = new JLabel(message);
    	JPanel message1 = new JPanel();
    	setBounds(a,a,750,50);
    	message1.add(text);
    	user.add(message1);
    	a=a+50;
    }
    public static void main(String args[])
    {
    	Messenger1 messenger = new Messenger1();

    }


}
