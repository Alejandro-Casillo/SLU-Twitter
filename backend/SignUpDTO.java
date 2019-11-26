import java.util.*;

public class SignUpDTO extends LoginDTO
{
   private String username, name, password;
   private Calendar dob;

   public SignUpDTO(String username, String password, String name, Calendar dob)
   {
      super(username, password);
      
      this.name = name;
      this.dob = dob;
   }

   public Profile getProfile()
   {
      return new Profile(name, dob);
   }

   public String getName()
   {
      return this.name;
   }

   public Calendar getDateOfBirth()
   {
      return this.dob;
   }

   public String toString()
   {
      String str = "SignUpDTO\nUsername: %s\nPassword: %s\nName: %s";
      String out = String.format(str, username, password, name);
      return out;
   }

   public static void main(String[] args)
   {
      String username = "fakeusername";
      String password = "abcd";
      String name = "Fake User";
      Calendar dob = Calendar.getInstance();
      dob.set(1999, 9, 3); 
      SignUpDTO dto = new SignUpDTO(username, password);
      System.out.println(dto);
      System.out.println(dto.getProfile());
   }
}
