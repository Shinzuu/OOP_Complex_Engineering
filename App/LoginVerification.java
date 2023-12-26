package App;

import java.util.Scanner;

public class LoginVerification {

    LoginVerification() {
        try (Scanner scn = new Scanner(System.in)) {
            System.out.print("\tPlease input User Id: ");
            String id = scn.nextLine();
            System.out.print("\tPlease input Password: ");
            String pass = scn.nextLine();

            // Default login admin admin
            if (id.equals("admin") && pass.equals("admin")) {
                // Login successful
                new AdminPanel();
            } else {
                while (id.equals("admin") && pass.equals("admin")) {
                    System.out.println("Press R to retry or M to go back to menu :");
                    String c = scn.next();

                    if (c.equalsIgnoreCase("M")) {
                        new Menu();
                    } else {
                        System.out.print("\tPlease input User Id: ");
                        id = scn.nextLine();
                        System.out.print("\tPlease input Password: ");
                        pass = scn.nextLine();
                    }
                }
            }
        }
    }
}
