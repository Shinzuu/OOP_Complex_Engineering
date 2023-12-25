package App;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the part name: ");
        String s = scn.nextLine();
    
        Selector.printPartName(s);
        scn.close();
    }
    
}
