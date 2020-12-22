import java.sql.*;
import java.util.Scanner;
public class RegisterUser
{
    public static int account_situation;
    public static double account_situation_dolar;
    public static double account_situation_gold;
    public static void Registeration()
    {
        Scanner input=new Scanner(System.in);
        try
        {
            String myUrl = "jdbc:mysql://localhost/UserRegisteration";
            Class.forName("com.mysql.jdbc.Driver");
            Connection Register = DriverManager.getConnection(myUrl, "root", "");
            String query = " insert into UserInfo (user_name,user_surname,password,mailAdress,BankAccount,Dolar_Account,Gold_Account)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";
            System.out.println("Please begin with capital letters to name and surname");
            System.out.println("Please do not use turkish characters\n");
            System.out.print("Enter your name         :");
            String name=input.next();
            System.out.print("Enter your surname      :");
            String surname=input.next();
            System.out.print("Enter your password     :");
            String password=input.next();
            System.out.print("Enter your mail adress  :");
            String mailAdress=input.next();
            account_situation=0;
            account_situation_dolar=0;
            account_situation_gold=0;
            PreparedStatement NewAccount = Register.prepareStatement(query);
            NewAccount.setString (1, name);
            NewAccount.setString (2,surname);
            NewAccount.setString (3, password);
            NewAccount.setString(4, mailAdress);
            NewAccount.setInt(5, account_situation);
            NewAccount.setDouble(6, account_situation_dolar);
            NewAccount.setDouble(7, account_situation_gold);
            NewAccount.execute();
            Register.close();
        }
        catch (Exception e)
        {
            System.err.println("There is an error\nPlease try later ...");
            System.err.println(e.getMessage());
        }
    }
}