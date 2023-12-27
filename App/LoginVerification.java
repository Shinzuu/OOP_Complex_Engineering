package App;

import java.util.Scanner;

public class LoginVerification {

    LoginVerification() {
        try (Scanner scn = new Scanner(System.in)) {
            boolean loginSuccessful = false;

            do {
                System.out.print("\tPlease input User Id: ");
                String id = scn.nextLine();
                System.out.print("\tPlease input Password: ");
                String pass = scn.nextLine();

                // Default login admin admin
                if (id.equals("admin") && pass.equals("admin")) {
                    // Login successful
                    loginSuccessful = true;
                    new AdminPanel();
                } else {
                    System.out.println("\tPress R to retry or M to go back to menu :");
                    String c = scn.next();
                    scn.nextLine(); // Consume the newline character

                    if (c.equalsIgnoreCase("M")) {
                        new Menu();
                        break;
                    }
                }
            } while (!loginSuccessful);
        }
    }
}
