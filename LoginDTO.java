//package backend;

public class LoginDTO
{
   protected String username, password;

   public LoginDTO(String username, String password)
   {
      this.username = username;
      this.password = password;
   }

   public String getPassword()
   {
      return this.password;
   }

   public String getUsername()
   {
      return this.username;
   }

   public Account getAccount()
   {
      return new Account(username, password);
   }

   public String toString()
   {
      String str = "LoginDTO\nUsername: %s\nPassword: %s\n";
      String out = String.format(str, username, password);
      return out;
   }

   public static void main(String[] args)
   {
      String username = "fakeusername";
      String password = "abcd";
      LoginDTO dto = new LoginDTO(username, password);
      System.out.println(dto);
      System.out.println(dto.getAccount());
   }
}

