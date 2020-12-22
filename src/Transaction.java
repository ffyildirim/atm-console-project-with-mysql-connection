import java.io.*;
import java.util.Scanner;
import java.sql.*;
public class Transaction {
    private static String pass;
    public static void getPwd(String pwd) {
        pass = pwd;
    }
    public static void Transact() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the transaction number :");
        int TransactionNumber = input.nextInt();
        switch (TransactionNumber) {
            case 1: {
                System.out.print("Please enter the amount :");
                double amount = input.nextDouble();
                try {
                    String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection Transaction1 = DriverManager.getConnection(myUrl, "root", "");
                    Statement smt = Transaction1.createStatement();
                    String q = "Select BankAccount,user_name from UserInfo where password = '" + pass + "';";
                    ResultSet rs = smt.executeQuery(q);
                    if (rs.next()) {
                        String Trans_past="Putting money into the bank account\n";
                        String name=rs.getString("user_name");
                        File file = new File(name+".txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bWriter = new BufferedWriter(fileWriter);
                        bWriter.write(Trans_past);
                        bWriter.close();
                        double currentbal = rs.getDouble("BankAccount");
                        double newbalance = currentbal + amount;
                        String sql = "update UserInfo SET BankAccount =" + newbalance + " where password ='" + pass + "' ;";
                        smt.executeUpdate(sql);
                    }
                    Transaction1.close();
                } catch (Exception e) {
                    System.out.println("There is an error\nPlease try later ...");
                    System.out.println(e);
                }
                System.out.println("Transaction is successful");
                break;
            }
            case 2: {
                System.out.print("Please enter the amount :");
                double amount2 = input.nextDouble();
                try {
                    String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection Transaction2 = DriverManager.getConnection(myUrl, "root", "");
                    Statement smt = Transaction2.createStatement();
                    String query = "Select BankAccount,user_name from UserInfo where password = '" + pass + "';";
                    ResultSet rs = smt.executeQuery(query);
                    if (rs.next()) {
                        String Trans_past="Withdraw money from the bank account\n";
                        String name=rs.getString("user_name");
                        File file = new File(name+".txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bWriter = new BufferedWriter(fileWriter);
                        bWriter.write(Trans_past);
                        bWriter.close();
                        double currentbal = rs.getDouble("BankAccount");
                        double newbalance = currentbal - amount2;
                        String sql = "update UserInfo SET BankAccount =" + newbalance + " where password ='" + pass + "' ;";
                        smt.executeUpdate(sql);
                    }
                    Transaction2.close();
                } catch (Exception e) {
                    System.out.println("There is an error\nPlease try later ...");
                    System.out.println(e);
                }
                System.out.println("Transaction is successful");
                break;
            }
            case 3: {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection Transaction3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserRegisteration", "root", "");
                    Statement smt = Transaction3.createStatement();
                    String q = "Select user_name, BankAccount , Dolar_Account , Gold_Account from UserInfo where password = '" + pass + "';";
                    ResultSet rs = smt.executeQuery(q);
                    if (rs.next()) {
                        String Trans_past="Checking the account balance\n";
                        String name=rs.getString("user_name");
                        File file = new File(name+".txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bWriter = new BufferedWriter(fileWriter);
                        bWriter.write(Trans_past);
                        bWriter.close();
                        System.out.println("Your TL account     :"+rs.getDouble("BankAccount"));
                        System.out.println("Your Dolar account  :"+rs.getDouble("Dolar_Account"));
                        System.out.println("Your Gold account   :"+rs.getDouble("Gold_Account"));
                    }
                    Transaction3.close();
                } catch (Exception e) {
                    System.out.println("There is an error\nPlease try later ...");
                    System.out.println(e);
                }
                break;
            }
            case 4: {
                System.out.println("Please enter the name which you send money     :");
                String name_Sending = input.next();
                System.out.println("Please enter the surname which you send money  :");
                String surname_sending = input.next();
                System.out.println("Please enter the amount   :");
                double amount4 = input.nextDouble();
                try {
                    String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection Transaction4 = DriverManager.getConnection(myUrl, "root", "");
                    Statement smt = Transaction4.createStatement();
                    String query4 = "Select user_name, BankAccount from UserInfo where password = '" + pass + "';";
                    ResultSet rs = smt.executeQuery(query4);
                    if (rs.next()) {
                        String Trans_past="Sending money\n";
                        String name=rs.getString("user_name");
                        File file = new File(name+".txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bWriter = new BufferedWriter(fileWriter);
                        bWriter.write(Trans_past);
                        bWriter.close();
                        double currentbal = rs.getDouble("BankAccount");
                        double newbalance = currentbal - amount4;
                        String sql = "update UserInfo SET BankAccount =" + newbalance + " where password ='" + pass + "' ;";
                        smt.executeUpdate(sql);
                    }
                    Transaction4.close();
                } catch (Exception e) {
                    System.out.println("There is an error\nPlease try later ...");
                    System.out.println(e);
                }
                try {
                    String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection Transaction4_2 = DriverManager.getConnection(myUrl, "root", "");
                    Statement smt = Transaction4_2.createStatement();
                    String q = "Select BankAccount from UserInfo where user_name = '" + name_Sending + "' and user_surname= '" + surname_sending + "';";
                    ResultSet rs = smt.executeQuery(q);
                    if (rs.next()) {
                        double currentbal = rs.getDouble("BankAccount");
                        double newbalance = currentbal + amount4;
                        String sql = "update UserInfo SET BankAccount =" + newbalance + " where user_name = '" + name_Sending + "' and user_surname= '" + surname_sending + "';";
                        smt.executeUpdate(sql);
                    }
                    Transaction4_2.close();
                } catch (Exception e) {
                    System.out.println("There is an error\nPlease try later ...");
                    System.out.println(e);
                }
                System.out.println("Transaction is successful");
                break;
            }
            case 5: {
                System.out.println("Dolar :1");
                System.out.println("Gold  :2");
                int selection_transit=input.nextInt();
                if(selection_transit==1) {
                    System.out.println("Enter the amount that you want to transit dolar :");
                    double amount_change_dolar = input.nextDouble();
                    double amount_change_dolar2 = amount_change_dolar;
                    try {
                        String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection Transaction5 = DriverManager.getConnection(myUrl, "root", "");
                        Statement smt = Transaction5.createStatement();
                        String query4 = "Select user_name, BankAccount from UserInfo where password = '" + pass + "';";
                        ResultSet rs = smt.executeQuery(query4);
                        if (rs.next()) {
                            double currentbal = rs.getDouble("BankAccount");
                            double newbalance = currentbal - amount_change_dolar;
                            String sql = "update UserInfo SET BankAccount =" + newbalance + " where password ='" + pass + "' ;";
                            smt.executeUpdate(sql);
                        }
                        Transaction5.close();
                    } catch (Exception e) {
                        System.out.println("There is an error\nPlease try later ...");
                        System.out.println(e);
                    }
                    try {
                        String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection Transaction5_2 = DriverManager.getConnection(myUrl, "root", "");
                        Statement smt2 = Transaction5_2.createStatement();
                        String query5 = "Select user_name, Dolar_Account from UserInfo where password = '" + pass + "';";
                        ResultSet rs2 = smt2.executeQuery(query5);
                        if (rs2.next()) {
                            String Trans_past="Transiting the deposit to the dolar\n";
                            String name=rs2.getString("user_name");
                            File file = new File(name+".txt");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bWriter = new BufferedWriter(fileWriter);
                            bWriter.write(Trans_past);
                            bWriter.close();
                            double currentbal_dolar = rs2.getDouble("Dolar_Account");
                            double newbalance_dolar = currentbal_dolar + amount_change_dolar2 / 5.71;
                            String sql2 = "update UserInfo SET Dolar_Account =" + newbalance_dolar + " where password ='" + pass + "' ;";
                            smt2.executeUpdate(sql2);
                        }
                        Transaction5_2.close();
                    } catch (Exception e) {
                        System.out.println("There is an error\nPlease try later ...");
                        System.out.println(e);
                    }
                    System.out.println("Transaction is successful");
                }
                else if(selection_transit==2){
                    System.out.println("Enter the amount that you want to transit gold :");
                    double amount_change_gold = input.nextDouble();
                    double amount_change_gold2 = amount_change_gold;
                    try {
                        String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection Transaction5_3 = DriverManager.getConnection(myUrl, "root", "");
                        Statement smt = Transaction5_3.createStatement();
                        String query4 = "Select BankAccount from UserInfo where password = '" + pass + "';";
                        ResultSet rs = smt.executeQuery(query4);
                        if (rs.next()) {
                            double currentbal = rs.getDouble("BankAccount");
                            double newbalance = currentbal - amount_change_gold;
                            String sql = "update UserInfo SET BankAccount =" + newbalance + " where password ='" + pass + "' ;";
                            smt.executeUpdate(sql);
                        }
                        Transaction5_3.close();
                    } catch (Exception e) {
                        System.out.println("There is an error\nPlease try later ...");
                        System.out.println(e);
                    }
                    try {
                        String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection Transaction5_4 = DriverManager.getConnection(myUrl, "root", "");
                        Statement smt2 = Transaction5_4.createStatement();
                        String query5 = "Select user_name, Gold_Account from UserInfo where password = '" + pass + "';";
                        ResultSet rs2 = smt2.executeQuery(query5);
                        if (rs2.next()) {
                            String Trans_past="Transiting the deposit to the gold\n";
                            String name=rs2.getString("user_name");
                            File file = new File(name+".txt");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bWriter = new BufferedWriter(fileWriter);
                            bWriter.write(Trans_past);
                            bWriter.close();
                            double currentbal_gold = rs2.getDouble("Gold_Account");
                            double newbalance_gold = currentbal_gold + amount_change_gold2 / 280;
                            String sql2 = "update UserInfo SET Gold_Account =" + newbalance_gold + " where password ='" + pass + "' ;";
                            smt2.executeUpdate(sql2);
                        }
                        Transaction5_4.close();
                    } catch (Exception e) {
                        System.out.println("There is an error\nPlease try later ...");
                        System.out.println(e);
                    }
                    System.out.println("Transaction is successful");
                }
                else{
                    System.out.println("Invalid enterence ...");
                }
                break;
            }
            case 6: {
                System.out.println("Electric bill  :1");
                System.out.println("Water bill     :2");
                System.out.println("Internet bill  :3");
                System.out.println("Please enter the number the one you want to pay  :");
                int selection = input.nextInt();
                if (selection == 1) {
                    double Electric_bill = Math.random() * 60 + 200;
                    System.out.println("Your electric bill :" + Electric_bill);
                    System.out.println("Do you want to pay?");
                    System.out.println("Please enter yes or no  :");
                    String answer = input.next();
                    switch (answer) {
                        case "yes": {
                            try {
                                String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection Transaction6 = DriverManager.getConnection(myUrl, "root", "");
                                Statement smt = Transaction6.createStatement();
                                String query = "Select user_name, BankAccount from UserInfo where password = '" + pass + "';";
                                ResultSet rs = smt.executeQuery(query);
                                if (rs.next()) {
                                    String Trans_past="Paying electric bill\n";
                                    String name=rs.getString("user_name");
                                    File file = new File(name+".txt");
                                    if (!file.exists()) {
                                        file.createNewFile();
                                    }
                                    FileWriter fileWriter = new FileWriter(file, true);
                                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                                    bWriter.write(Trans_past);
                                    bWriter.close();
                                    double currentbal = rs.getDouble("BankAccount");
                                    double newbalance = currentbal - Electric_bill;
                                    String sql = "update UserInfo SET BankAccount =" + newbalance + " where password ='" + pass + "' ;";
                                    smt.executeUpdate(sql);
                                }
                                Transaction6.close();
                            } catch (Exception e) {
                                System.out.println("There is an error\nPlease try later ...");
                                System.out.println(e);
                            }
                            System.out.println("Payment is successful");
                            break;
                        }
                        case "no": {
                            System.out.println("Thank you for visitation ...");
                            break;
                        }
                        default: {
                            System.out.println("Invalid enterence ...");
                            break;
                        }
                    }
                } else if (selection == 2) {
                    double Water_bill = Math.random() * 30 + 150;
                    System.out.println("Your water bill :" + Water_bill);
                    System.out.println("Do you want to pay?");
                    System.out.println("Please enter yes or no  :");
                    String answer2 = input.next();
                    switch (answer2) {
                        case "yes": {
                            try {
                                String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection Transaction6_1 = DriverManager.getConnection(myUrl, "root", "");
                                Statement smt = Transaction6_1.createStatement();
                                String query = "Select user_name, BankAccount from UserInfo where password = '" + pass + "';";
                                ResultSet rs = smt.executeQuery(query);
                                if (rs.next()) {
                                    String Trans_past="Paying water bill\n";
                                    String name=rs.getString("user_name");
                                    File file = new File(name+".txt");
                                    if (!file.exists()) {
                                        file.createNewFile();
                                    }
                                    FileWriter fileWriter = new FileWriter(file, true);
                                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                                    bWriter.write(Trans_past);
                                    bWriter.close();
                                    double currentbal = rs.getDouble("BankAccount");
                                    double newbalance = currentbal - Water_bill;
                                    String sql = "update UserInfo SET BankAccount =" + newbalance + " where password ='" + pass + "' ;";
                                    smt.executeUpdate(sql);
                                }
                                Transaction6_1.close();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            System.out.println("Payment is successful");
                            break;
                        }
                        case "no": {
                            System.out.println("Thank you for visitation ...");
                            break;
                        }
                        default: {
                            System.out.println("Invalid enterence ...");
                            break;
                        }
                    }
                } else if (selection == 3) {
                    double internet_bill = Math.random() * 30 + 100;
                    System.out.println("Your internet bill :" + internet_bill);
                    System.out.println("Do you want to pay?");
                    System.out.println("Please enter yes or no  :");
                    String answer2 = input.next();
                    switch (answer2) {
                        case "yes": {
                            try {
                                String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection Transaction6_2 = DriverManager.getConnection(myUrl, "root", "");
                                Statement smt = Transaction6_2.createStatement();
                                String query = "Select user_name, BankAccount from UserInfo where password = '" + pass + "';";
                                ResultSet rs = smt.executeQuery(query);
                                if (rs.next()) {
                                    String Trans_past="Paying internet bill\n";
                                    String name=rs.getString("user_name");
                                    File file = new File(name+".txt");
                                    if (!file.exists()) {
                                        file.createNewFile();
                                    }
                                    FileWriter fileWriter = new FileWriter(file, true);
                                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                                    bWriter.write(Trans_past);
                                    bWriter.close();
                                    double currentbal = rs.getDouble("BankAccount");
                                    double newbalance = currentbal - internet_bill;
                                    String sql = "update UserInfo SET BankAccount =" + newbalance + " where password ='" + pass + "' ;";
                                    smt.executeUpdate(sql);
                                }
                                Transaction6_2.close();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            System.out.println("Payment is successful");
                            break;
                        }
                        case "no": {
                            System.out.println("Thank you for visitation ...");
                            break;
                        }
                        default: {
                            System.out.println("Invalid enterence ...");
                            break;
                        }
                    }
                }
                break;
            }
            case 8: {
                try {
                    String myUrl = "jdbc:mysql://localhost/UserRegisteration";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection Transaction8 = DriverManager.getConnection(myUrl, "root", "");
                    Statement smt = Transaction8.createStatement();
                    String query4 = "Select BankAccount from UserInfo where password = '" + pass + "';";
                    ResultSet rs = smt.executeQuery(query4);
                    if (rs.next()) {
                        double currentbal = rs.getDouble("BankAccount");
                        if(currentbal>2000) {
                            System.out.println("You can take a 1000 TL loan.");
                            System.out.println("Do you want to take?");
                            System.out.println("Answer(please enter yes or no)  :");
                            String answer_loan = input.next();
                            switch (answer_loan) {
                                case "yes": {
                                    try {
                                        String myUrl1 = "jdbc:mysql://localhost/UserRegisteration";
                                        Class.forName("com.mysql.jdbc.Driver");
                                        Connection Transaction8_1 = DriverManager.getConnection(myUrl1, "root", "");
                                        Statement smt1 = Transaction8_1.createStatement();
                                        String query = "Select user_name, BankAccount from UserInfo where password = '" + pass + "';";
                                        ResultSet rs1 = smt.executeQuery(query);
                                        if (rs1.next()) {
                                            String Trans_past="Taking a loan\n";
                                            String name=rs1.getString("user_name");
                                            File file = new File(name+".txt");
                                            if (!file.exists()) {
                                                file.createNewFile();
                                            }
                                            FileWriter fileWriter = new FileWriter(file, true);
                                            BufferedWriter bWriter = new BufferedWriter(fileWriter);
                                            bWriter.write(Trans_past);
                                            bWriter.close();
                                            double currentbal1 = rs1.getDouble("BankAccount");
                                            double newbalance = currentbal + 1000;
                                            String sql = "update UserInfo SET BankAccount =" + newbalance + " where password ='" + pass + "' ;";
                                            smt1.executeUpdate(sql);
                                        }
                                        Transaction8_1.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                    Transaction8.close();
                                    System.out.println("Transaction is successful");
                                    break;
                                }
                                case "no": {
                                    System.out.println("Thank you for visitation ...");
                                    break;
                                }
                            }
                        }
                        else{
                            System.out.println("Your credit is not appropriate to take a loan...");
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }
            case 7: {
                try {
                    String myUrl1 = "jdbc:mysql://localhost/UserRegisteration";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection Transaction8_1 = DriverManager.getConnection(myUrl1, "root", "");
                    Statement smt1 = Transaction8_1.createStatement();
                    String query = "Select user_name, BankAccount from UserInfo where password = '" + pass + "';";
                    ResultSet rs1 = smt1.executeQuery(query);
                    if (rs1.next()) {
                        String name=rs1.getString("user_name");
                        File file = new File(name+".txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileReader fileReader = new FileReader(file);
                        String line;
                        BufferedReader br = new BufferedReader(fileReader);
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close();
                    }
                    Transaction8_1.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }
        }
    }
}