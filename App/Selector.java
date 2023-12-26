package App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class Selector extends Parts {
    // will have select: type, brand, all
    // when selecting all, it will iterate through the database
    // type will have: Engine, Wheels, Turbo, ECU, Rear Wing, Aero Kit
    // will use id indexing (1xxx,2xxx,3xxx)
    // brand will have: brands...duh ?
    // use a dictionary to keep in track the name of brands ???

    int x;

    // Public constructor with a parameter
    public Selector(int x) {
        super(0, "", "", "", 0, 0); // replace with appropriate default values
        this.x = x;
        switch (x) {
            case 1:
                printPartAll();
                break;
            case 2:
                printPartType();
                break;
            case 3:
                printPartBrand();
                break;
            default:
                // doesn't need default. will limit user input before coming to this part
                break;
        }
        new CallBack();
    }
    // //dummy fn for checking code
    // public static void main(String[] args) {
    //     new Selector(3);
    // }
    //iterate through each CSV lines and prints all data
    public static void printPartAll() {
        String csvFilePath = "Database/PartsData.csv";
    
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean isFirstLine = true;
    
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
    
                Parts part = Parts.createFromCSVLine(line);
                printPart(part);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //iterate through each CSV lines and prints necessary
    //using method overloading for type selection
    private static void printPartAll(String s) {
        String csvFilePath = "Database/PartsData.csv";
        boolean found = false;  // Flag to track if any parts were found
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean isFirstLine = true;
        
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
        
                Parts part = Parts.createFromCSVLine(line);
                // if the same type is found then print, else 
                if(part.type.equalsIgnoreCase(s) || part.brand.equalsIgnoreCase(s) || part.name.equalsIgnoreCase(s)){
                    printPart(part);
                    found = true;  // Set the flag to true since at least one part was found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        if (!found) {
            System.out.println("No parts found for the specified criteria: " + s);
        }
    }
    
    
    //since types of parts that are sold is constant, we can bruteforce
    public void printPartType() {
        Scanner scn = new Scanner(System.in);
        // Add logic for printing parts of a specific type
        System.out.println("Please select which type of product you want to see by, inserting number(1-6)");
        System.out.println("'--> 1 for Engine.");
        System.out.println("'--> 2 for Wheels.");
        System.out.println("'--> 3 for Turbo.");
        System.out.println("'--> 4 for ECU.");
        System.out.println("'--> 5 for Rear Wing.");
        System.out.println("'--> 6 for Aero Kit.");
        System.out.print("Select range: ");
        int y = scn.nextInt();
        while ( y< 1 || y > 6) {
            System.out.println("Invalid range. Please insert a number between 1 to 6: ");
            System.out.print("Select range: ");
            y = scn.nextInt();
        }

        switch (y) {
            case 1:
                //for engine
                printPartAll("Engine");
                break;
            case 2:
                printPartAll("Wheels");
                break;
            case 3:
                printPartAll("Turbo");
                break;
            case 4:
                printPartAll("ECU");
                break;
            case 5:
                printPartAll("Rear Wing");
                break;
            case 6:
                printPartAll("Aero Kit");
                break;
            default:
            // never gonna trigger this
                break;
        }
        scn.close();
    }
    //for searching by brand. since number of brands isnt constant , we have to update the list each time.
    private void printPartBrand() {
        // Add logic for printing parts of a specific brand
        
        String csvFilePath = "Database/PartsData.csv";
        Set<String> uniqueStrings = UniqueStringGenerator.generateUniqueStrings(csvFilePath);

        // Now you can use the uniqueStrings set in this class
        System.out.println("Unique Strings:");
        int i = 1;
        for (String str : uniqueStrings) {
            System.out.println(i++ + " for " + str);
        }
        try (//2nd part . choosing the brand
        Scanner scn = new Scanner(System.in)) {
            System.out.print("Select range: ");
            int y = scn.nextInt();
            while ( y< 1 || y > (i-1)) {
                System.out.println("Invalid range. Please insert a number between 1 to "+(i-1)+"");
                System.out.print("Select range: ");
                y = scn.nextInt();
            }
            
            i=1;    //iterator
            for (String str : uniqueStrings) {
                if(i==y){
                    //str is the name of the brand
                    System.out.println("\t=====You chose "+ str +"=====");
                    System.out.println("=====The available parts from "+ str +" are=====");
                    System.out.println();   //blank line
                    printPartAll(str);

                    //  **need to add go back/ go to main menu here** + find dealer near you
                }
                else
                {
                    //do nothing
                }
                i++;
            }
        }
        
    }
    //will catch the string scanned beforehand
    public static void printPartName(String s) {
            printPartAll(s);
        //  **need to add go back/ go to main menu here**
        // try again or go to menu
        new CallBack();
    }


    //default print method
    private static void printPart(Parts part) {
        PartPrinter.printPartInfo(part);
    }
    
}
