import javax.swing.*;

public class User
{
	private String fname, lname, username, password, dateofBirth;

	public User(String fname, String lname, String username, String password, String dateofBirth)
	{
		this.fname = fname;
		this.lname = lname; 
		this.username = username; 
		this.password = password;
		this.dateofBirth = dateofBirth;
	}

	public String getFName()
	{
		return fname; 
	}
	public String getLName()
	{
		return lname;
	}
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public String getDateOfBirth()
	{
		return dateofBirth;
	}
}