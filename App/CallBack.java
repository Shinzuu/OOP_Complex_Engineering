package App;

import java.util.Scanner;

public class CallBack {
    public CallBack() {
        try (Scanner scn = new Scanner(System.in)) {
            System.out.println("\tInstert 1 to find the Nearest dealer\n\t\t2 to go back to menu");
            System.out.print("\tInsert here: ");
            int n = scn.nextInt();
            if(n==1){
                new LocationFinder();
            }
            else if(n==2)
            {
                new Menu();
            }
            else
            {
                while ( n != 1 || n != 2) {
                    System.out.println("\tInvalid range. \n\tPlease insert either 1 or 2.");
                    System.out.print("\tSelect range: ");
                    n = scn.nextInt();
                }
            }
        }
    }
}
