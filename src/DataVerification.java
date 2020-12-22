import java.sql.*;
import java.util.Scanner;
public class DataVerification{
    public static String password1;
    public static boolean Verify() {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter your password :");
        password1 = input.next();
        boolean status=false;
        try {
            String myUrl = "jdbc:mysql://localhost/UserRegisteration";
            Class.forName("com.mysql.jdbc.Driver");
            Connection Verification = DriverManager.getConnection(myUrl, "root", "");
            PreparedStatement ps=Verification.prepareStatement("Select * from UserInfo where password =?");
            ps.setString(1, password1);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            Verification.close();
        } catch (Exception e) {
            System.err.println("There is an error\nPlease try later ...");
            System.err.println(e.getMessage());
        }
        return status;
    }
}