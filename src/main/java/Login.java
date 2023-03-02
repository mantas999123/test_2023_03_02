import com.mongodb.client.FindIterable;
import data.User;

import java.io.IOException;
import java.util.Scanner;

public class Login {
    private final Service service;

    public Login(Service service) {
        this.service = service;
    }

    public static void main(String[] args) {
        Login login = new Login(new Service());
        Scanner scanner = new Scanner(System.in);

        String select;
        do {
            login.registrationMenu();
            select = scanner.nextLine();
            login.userSelectFisrt(scanner, select);
        } while (!select.equals("3"));

    }

    public void login(Scanner scanner) {
        User user;
        do {
            System.out.println("Sveiki prasome prisijungti");
            System.out.println("Iveskite varda");
            String name = scanner.nextLine();
            System.out.println("Iveskite pavarde");
            String surname = scanner.nextLine();

            user = service.getLoginUser(name, surname);

            if (user == null) {
                System.out.println("Tokio userio nera");
            }
        } while (user == null);

        boolean forward = true;
        while (forward) {
            System.out.println("""
                    1. Patikrinti balanca
                    2. Pervesti pinigus
                    3. Uzdaryti programa
                    """);

            String selection = scanner.nextLine();
            switch (selection) {
                case "1" -> showBalance();
                case "2" -> transferMoney();
                case "3" -> System.out.println("Uzdaroma programa");
                case "4" -> forward = false;
                default -> System.out.println("Tokio pasirinkimo nera");
            }
        }
    }
        public void userRegistration (Scanner scanner){
            service.addUser();
            login(scanner);
        }

        private void registrationMenu () {
            System.out.println("""
                    1. Prisijungti prie sistemos
                    2. Prisiregistruoti
                    3. Exit
                    """);
        }

        private void userSelectFisrt (Scanner scanner, String selectFirst){
            switch (selectFirst) {
                case "1" -> login(scanner);
                case "2" -> userRegistration(scanner);
                case "3" -> System.out.println("Programa uzdaroma");
                default -> System.out.println("Tokio pasirinkimo nera");
            }
        }

        private void showBalance () {

        }

        private void transferMoney () {

        }
    }


