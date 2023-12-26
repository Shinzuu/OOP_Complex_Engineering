package App;

import java.util.Scanner;

public class Menu {
    Scanner scn = new Scanner(System.in);
    int x;
    Menu(){
        System.out.println("\t===================================");
        System.out.println("\t\t\tMenu");
        System.out.println("\t===================================");
        System.out.println("\t'-->Navigate by inserting index<--'");
        //System.out.println("\t-----------------------------------");
        System.out.println("\t1. Browse parts");
        System.out.println("\t2. Find nearest dealership");
        System.out.println("\t3. Contact");
        System.out.println("\t4. Admin login");
        //System.out.println("\t-----------------------------------");
        System.out.println("\t===================================");
        System.out.print("\tInsert number between 1 to 4:  ");
        x = scn.nextInt();
        while ( x < 1 || x > 4) {
            System.out.println("\tInvalid range. \n\tPlease insert a number between 1 to 4.");
            System.out.print("\tSelect range: ");
            x = scn.nextInt();
        }
        System.out.println("\t-----------------------------------");

        switch (x) {
            case 1:
                //browse parts
                System.out.println("\t===================================");
                System.out.println("\t\tBrowsing Window");
                System.out.println("\t===================================");
                System.out.println("\t'-->Navigate by inserting index<--'");
                //System.out.println("\t-----------------------------------");
                System.out.println("\t1. Browse all ");
                System.out.println("\t2. Browse by type ");
                System.out.println("\t3. Browse by brand ");
                System.out.println("\t4. Search by name");
                System.out.println("\t5. Go back to menu");
                //System.out.println("\t-----------------------------------");
                System.out.println("\t===================================");
                System.out.print("\tInsert number between 1 to 5:  ");
                
                System.out.print("\tInsert number between 1 to 4:  ");
                int x;

                while (true) {
                    try {
                        x = scn.nextInt();
                        scn.nextLine();  // Consume the newline character
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scn.nextLine();  // Consume the invalid input
                    }
                }


                System.out.println("\t-----------------------------------");

                switch (x) {
                    case 4:
                        // search using user input
                        scn.nextLine(); // Consume the newline character
                        System.out.print("\tInput parts name(must be 1:1): ");
                        String s = scn.nextLine();
                        System.out.println("\t-----------------------------------");
                        // Call the printPartName method from Selector class
                        Selector.printPartName(s);
                        break;
                    case 5:
                        //creates new Menu instance
                        new Menu();
                        break;
                    default:
                        //creates new constructor from Selector class
                        // works when input 1 to 3
                        new Selector(x);
                        break;
                }
                break;
            case 2:
                new LocationFinder();
                break;
            case 3:
                System.out.println("\tEmail : fake@fake.com");
                System.out.println("\tCall  : fake number");
                System.out.println("\t-----------------------------------");
            case 4:
                //admin panel
                new LoginVerification();
                break;

            default:
                break;
        }
        //new Menu();
    }

}
