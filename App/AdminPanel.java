package App;

import java.util.Scanner;

public class AdminPanel {
    String id , pass;
    String c;
    AdminPanel(){
        try (Scanner scn = new Scanner(System.in)) {
            System.out.print("\tPlease input User Id: ");
            this.id = scn.nextLine();
            System.out.print("\tPlease input Password: ");
            this.pass = scn.nextLine();
            //default login admin admin
            if(id.equals("admin") && pass.equals("admin")){
                //dummy
            }
            else{
            while (id.equals("admin") && pass.equals("admin")) {
                System.out.println("Press R to retry or M to go back to menu :");
                this.c = scn.next();
                
                if(c.equalsIgnoreCase("M")){
                    new Menu();
                }
                else{
                    System.out.print("\tPlease input User Id: ");
                    id = scn.nextLine();
                    System.out.print("\tPlease input Password: ");
                    pass = scn.nextLine();
                }
            }
            }
            //admin privelage start here
            System.out.println("\tLogin Successful");
            
        }
    }
}