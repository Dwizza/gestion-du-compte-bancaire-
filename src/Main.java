import model.Account;
import model.User;
import repository.AccountRepository;
import repository.impliment.InMemoryAccountRepository;
import repository.impliment.InMemoryUserRepository;
import service.AccountService;
import service.AuthService;
import service.impliment.InMemoryAccountService;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private  static AuthService authService = new AuthService(new InMemoryUserRepository());
    private static AccountRepository accountRepository = new InMemoryAccountRepository();
    private static AccountService accountService = new InMemoryAccountService(accountRepository);
    private static User currentUser;

    public static void main(String[] args) {
      authService.register("name", "email", "address", "password");
        showMainMenu();
    }

    public Main(AccountService accountService) {
        this.accountService = accountService;
    }

    public static void showMainMenu(){
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("Please select an option:");

        String option = scanner.nextLine();

        switch (option){
            case "1":
                registerUser();
                break;
            case "2":
                loginUser();
                break;
            case "3":
                System.out.println("Exit");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                showMainMenu();
                break;
        }
    }

    public static void showLoginMenu(){
        System.out.println("Welcome to your account");
        System.out.println("1. Create account");
        System.out.println("2. List my accounts");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Transfer");
        System.out.println("6. Transaction history");
        System.out.println("7. Update profile");
        System.out.println("8. Change password");
        System.out.println("9. Close account");
        System.out.println("10. Logout");
        System.out.println("11. Exit");
        System.out.println("Please select an option:");

        String option = scanner.nextLine();

        switch (option){
            case "1":
                createAccount();
                break;
            case "2":
                listAccounts();
                break;
            case "3":
                Deposit();
                break;
            case "4":
                Withdraw();
                break;
        }
    }


    public static void registerUser(){
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your address:");
        String address = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        try{
            authService.register(name, email, address, password);
            System.out.println("Registration successful!");
        }catch (Exception e){
            System.err.println("Registration failed: " + e.getMessage());
        }
        showMainMenu();
    }

    public static  void loginUser(){
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        try {
            if (!authService.login(email, password)) {
                System.out.println("Invalid email or password!");
            }else{
                System.out.println("Login successful!");
                showLoginMenu();
            }
        } catch (Exception e) {
            System.err.println("Login failed: " + e.getMessage());
            showMainMenu();
        }

    }



    public static void createAccount(){
        Account account = accountService.createAccount(authService.getCurrentUser().getId());
        System.out.println("Account created successfully!");
        System.out.println("account number: " + account.getAccountId());
        System.out.println("balance: " + account.getBalance() + "$");

    }

    public static void listAccounts(){

    }

    public static void Deposit(){

    }

    public static void Withdraw(){

    }

}