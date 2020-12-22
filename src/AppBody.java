import java.io.IOException;
import java.util.Scanner;
import java.sql.*;
public class AppBody {
    public static void main(String[] args) throws IOException {
        System.out.println("\n-----------------------WELCOME TO THE SYSTEM-----------------------\n\n");
        Scanner input=new Scanner(System.in);
        System.out.println("Do you have an account?");
        System.out.print("Answer(Please enter yes or no) :");
        String answer=input.next();
        switch(answer){
            case "yes": {
                if (DataVerification.Verify() == true) {
                    System.out.println("Account verified\nYou are connecting to system...\n\n");
                    while (true) {
                        System.out.println("\nDo you want to make a transaction?");
                        System.out.println("Answer(Please enter yes or no)  :");
                        String answer_transaction = input.next();
                        if (answer_transaction.equals("yes")) {
                            String pwd = DataVerification.password1;
                            Menu.Display_Menu();
                            Transaction.getPwd(pwd);
                            Transaction.Transact();
                        } else if (answer_transaction.equals("no")) {
                            System.out.println("Thank you for visitation ...");
                            break;
                        } else {
                            System.out.println("Invalid enterence ...");
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.println("Account is not verifired\nPlease enter later...");
                    break;
                }
            }
        case "no":{
            System.out.println("Do you want to enroll the system?");
            System.out.print("Answer(Please enter yes or no) :");
            String answer2=input.next();
            switch(answer2){
                case "no":{
                    System.out.println("Thank you to visit our system");
                    break;
                }
                case "yes":{
                    RegisterUser.Registeration();
                    System.out.println("Registeration is successful");
                    break;
                }
                default: System.out.println("Invalid answer...");
            }
        }
        }
    }
}
