/*
 * Author:
 * @Amol Mhamane
 * Oasis Infobyte Internship
 */

import java.util.Scanner;

class UserAccount {

    String fullName;
    String username;
    String password;
    String accountNumber;
    float balance = 100000f;
    int transactionCount = 0;
    String transactionHistory = "";

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Your Name - ");
        this.fullName = scanner.nextLine();
        System.out.print("\nEnter Your Username - ");
        this.username = scanner.nextLine();
        System.out.print("\nEnter Your Password - ");
        this.password = scanner.nextLine();
        System.out.print("\nEnter Your Account Number - ");
        this.accountNumber = scanner.nextLine();
        System.out.println("\nRegistration completed..Now You Can Login....Welcome to My ATM");
    }

    public boolean loginUser() {
        boolean isLoggedIn = false;
        Scanner scanner = new Scanner(System.in);
        while (!isLoggedIn) {
            System.out.print("\nEnter Your Username - ");
            String inputUsername = scanner.nextLine();
            if (inputUsername.equals(username)) {
                while (!isLoggedIn) {
                    System.out.print("\nEnter Your Password - ");
                    String inputPassword = scanner.nextLine();
                    if (inputPassword.equals(password)) {
                        System.out.print("\nLogin successful!!");
                        isLoggedIn = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("\nUsername not found");
            }
        }
        return isLoggedIn;
    }

    public void withdrawAmount() {
        System.out.print("\nEnter amount to withdraw - ");
        Scanner scanner = new Scanner(System.in);
        float amount = scanner.nextFloat();
        try {
            if (balance >= amount) {
                transactionCount++;
                balance -= amount;
                System.out.println("\nWithdraw Successful");
                String str = amount + " Rs Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input");
        }
    }

    public void depositAmount() {
        System.out.print("\nEnter amount to deposit - ");
        Scanner scanner = new Scanner(System.in);
        float amount = scanner.nextFloat();
        try {
            if (amount <= 100000f) {
                transactionCount++;
                balance += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + " Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry...Limit is 100000.00");
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input");
        }
    }

    public void transferAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Recipient's Name - ");
        String recipient = scanner.nextLine();
        System.out.print("\nEnter amount to transfer - ");
        float amount = scanner.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transactionCount++;
                    balance -= amount;
                    System.out.println("\nSuccessfully Transferred to " + recipient);
                    String str = amount + " Rs transferred to " + recipient + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry...Limit is 50000.00");
                }
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input");
        }
    }

    public void checkAccountBalance() {
        System.out.println("\n" + balance + " Rs");
    }

    public void showTransactionHistory() {
        if (transactionCount == 0) {
            System.out.println("\nEmpty");
        } else {
            System.out.println("\n" + transactionHistory);
        }
    }
}


public class mytask2 {

    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                flag = true;

                if (input > limit || input < 1) {
                    System.out.println("Choose a number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n**********WELCOME TO MY ATM SYSTEM**********\n");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter Your Choice - ");
        int choice = takeIntegerInput(2);

        if (choice == 1) {
            UserAccount userAccount = new UserAccount();
            userAccount.registerUser();
            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter Your Choice - ");
                int ch = takeIntegerInput(2);
                if (ch == 1) {
                    if (userAccount.loginUser()) {
                        System.out.println("\n\n**********WELCOME BACK " + userAccount.fullName + " **********\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("\nEnter Your Choice - ");
                            int c = takeIntegerInput(6);
                            switch (c) {
                                case 1:
                                    userAccount.withdrawAmount();
                                    break;
                                case 2:
                                    userAccount.depositAmount();
                                    break;
                                case 3:
                                    userAccount.transferAmount();
                                    break;
                                case 4:
                                    userAccount.checkAccountBalance();
                                    break;
                                case 5:
                                    userAccount.showTransactionHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
