package App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Selector extends Parts {
    // will have select: type, brand, all
    // when selecting all, it will iterate through the database
    // type will have: Engine, Wheels, Turbo, ECU, Rear Wing, Aero Kit
    // will use id indexing (1xxx,2xxx,3xxx)
    // brand will have: brands...duh ?
    // use a dictionary to keep in track the name of brands ???

    int x;

    // Public constructor with a parameter
    Selector(int x) {
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
    }

    public static void main(String[] args) {
        new Selector(1);
    }

    private void printPartAll() {
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
    

    private void printPartType() {
        // Add logic for printing parts of a specific type
    }

    private void printPartBrand() {
        // Add logic for printing parts of a specific brand
    }

    private void printPart(Parts part) {
        PartPrinter.printPartInfo(part);
    }
    
}
