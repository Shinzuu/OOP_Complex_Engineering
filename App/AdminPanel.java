package App;

import java.util.Scanner;

public class AdminPanel {
    String id, pass;
    String c;

    AdminPanel() {
        // admin privilege starts here
        System.out.println("\tLogin Successful");

        try (Scanner scn = new Scanner(System.in)) {
            // 2ND PART
            System.out.println("\t===================================");
            System.out.println("\t\tAdmin Panel");
            System.out.println("\t===================================");
            System.out.println("\t'-->Navigate by inserting index<--'");
            System.out.println("\t1. Change volume of parts");
            System.out.println("\t2. Add new parts");
            System.out.println("\t3. Go back to the menu");
            System.out.println("\t===================================");
            System.out.print("\tInsert a number between 1 to 3:  ");

            int x;
            while (true) {
                try {
                    x = scn.nextInt();
                    scn.nextLine(); // Consume the newline character
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scn.nextLine(); // Consume the invalid input
                }
            }

            while (x < 1 || x > 3) {
                System.out.println("\tInvalid range. \n\tPlease insert a number between 1 to 3.");
                System.out.print("\tSelect range: ");

                while (true) {
                    try {
                        x = scn.nextInt();
                        scn.nextLine(); // Consume the newline character
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scn.nextLine(); // Consume the invalid input
                    }
                }
            }
            System.out.println("\t-----------------------------------");

            switch (x) {
                case 1:
                    // looks for a part. if found, shows the current volume then changes it to the target;
                    Selector.printPartAll();
                    System.out.println("\tSelect a part ID from above to change its volume.");
                    System.out.print("\tChosen index :");
                    int t;

                    while (true) {
                        try {
                            t = scn.nextInt();
                            scn.nextLine(); // Consume the newline character
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scn.nextLine(); // Consume the invalid input
                        }
                    }

                    System.out.print("\tInput the new volume : ");
                    int v;

                    while (true) {
                        try {
                            v = scn.nextInt();
                            scn.nextLine(); // Consume the newline character
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scn.nextLine(); // Consume the invalid input
                        }
                    }

                    CSVWriter.updateVolume(t, v);
                    new AdminPanel();
                    break;
                case 2:
                    // looks for the highest ID, does +1, and adds parts based on type;
                    CSVWriter.addNewPart();
                    new Disclaimer();
                    break;
                case 3:
                    // creates a new Menu instance
                    new Menu();
                    break;
                default:
                    break;
            }
            
        }
    }
}
