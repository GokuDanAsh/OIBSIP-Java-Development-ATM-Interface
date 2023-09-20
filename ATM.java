import java.util.*;

class BankAccount {
    static void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Enter your name:");
        ATM.name = sc.nextLine();
        System.out.println("Enter your Account number:");
        ATM.accnumber = sc.nextLine();
        System.out.println("REGISTRATION SUCCESSFULL!");
        System.out.println("---------------------------");
        ATM.prompt();
    }
}

class Transaction {
    static void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Enter amount to withdraw:");
        int wcash = sc.nextInt();
        if (wcash <= ATM.balance) {
            ATM.balance -= wcash;
            ATM.updateHistory(wcash, "Withdraw");
            System.out.println("Amount Rs" + wcash + "/- withdrawn successfully");
            System.out.println("---------------------------");
        } else {
            System.out.println("Insufficient balance to withdraw the cash");
            System.out.println("---------------------------");
        }
        ATM.prompt();
    }

    static void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Enter amount to deposit:");
        int dcash = sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.updateHistory(dcash, "Deposit");
        System.out.println("Amount Rs." + dcash + "/- deposited successfully!");
        System.out.println("---------------------------");
        ATM.prompt();
    }

    static void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account name to transfer the Amount:");
        String s = sc.nextLine();
        System.out.println("Enter their account number:");
        int num = sc.nextInt();
        System.out.println("Enter the amount to be transferred:");
        int tcash = sc.nextInt();
        if (tcash <= ATM.balance) {
            ATM.balance -= tcash;
            ATM.updateHistory(tcash, "Transferred");
            System.out.println("Amount Rs." + tcash + "/- transferred successfully");
            System.out.println("---------------------------");
        } else {
            System.out.println("Insufficient balance to transfer the cash");
            System.out.println("---------------------------");
        }
    }
}

class Check {
    static void checkbalance() {
        System.out.println("------------------");
        System.out.println("Available in account:");
        System.out.println(ATM.balance);
        System.out.println("---------------------------");
        ATM.prompt();
    }
}

class History {
    static void transactionhistory() {
        System.out.println("---------------------");
        System.out.println("Transaction History :");
        int k = 0;
        if (ATM.balance > 0) {
            for (int i = 0; i < (ATM.history.size() / 2); i++) {
                System.out.println(ATM.history.get(k++) + " " + ATM.history.get(k++));
            }
        } else {
            System.out.println("Your account is empty");
        }
        ATM.prompt();
    }
}

public class ATM {
    public static String name;
    public static int balance = 0;
    public static String accnumber;
    public static ArrayList<String> history = new ArrayList<>();

    static void updatebalance(int dcash) {
        balance += dcash;
    }

    static void updateHistory(int amount, String action) {
        history.add(amount + "");
        history.add(action);
    }

    public static void homepage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\033[H\033[2J"); //for clearing screen
        System.out.println("WELCOME TO ATM");
        System.out.println("--------------------------");
        System.out.println("select option :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice");
        int choice = sc.nextInt();
        if (choice == 1) {
            BankAccount.register();
        } else if (choice == 2) {
            System.exit(0);
        } else {
            System.out.println("invalid choice :");
            homepage();
        }
    }

    public static void prompt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE ATM Mr."+ATM.name);
        System.out.println("---------------------");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Transaction.withdraw();
                break;
            case 2:
                Transaction.deposit();
                break;
            case 3:
                Transaction.transfer();
                break;
            case 4:
                Check.checkbalance();
                break;
            case 5:
                History.transactionhistory();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}
