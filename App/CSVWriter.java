package App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class CSVWriter {
    private static final String CSV_FILE_PATH = "Database/PartsData.csv";

    // Method to update the volume of a part in the CSV file
    public static void updateVolume(int partId, int newVolume) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(CSV_FILE_PATH));

            // Adjust the part index based on the starting ID (1000 in your case)
            int partIndex = partId - 999;

            if (partIndex >= 0 && partIndex < lines.size()) {
                String[] parts = lines.get(partIndex).split(",");
                parts[5] = String.valueOf(newVolume);
                lines.set(partIndex, String.join(",", parts));

                Files.write(Paths.get(CSV_FILE_PATH), lines);
                System.out.println("Volume updated successfully!");
            } else {
                System.out.println("Invalid part ID.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewPart() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Read existing lines to find the highest index
            int highestIndex = findHighestIndex();
            int newIndex = highestIndex + 1;
    
            System.out.println("Adding a new part with index: " + newIndex);
    
            // Gather information from the user
            System.out.print("Enter part name: ");
            String name = scanner.nextLine();
    
            System.out.print("Enter part type: ");
            String type = scanner.nextLine();
    
            System.out.print("Enter part brand: ");
            String brand = scanner.nextLine();
    
            System.out.print("Enter part price: ");
            int price = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
    
            System.out.print("Enter part volume: ");
            int volume = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
    
            String additionalInfo = "";
    
            // Based on part type, ask for additional information
            switch (type.toLowerCase()) {
                case "engine":
                    System.out.print("Enter horsepower: ");
                    additionalInfo = scanner.nextLine();
                    break;
                case "wheels":
                    System.out.print("Enter diameter: ");
                    additionalInfo = scanner.nextLine();
                    break;
                case "turbo":
                    System.out.print("Enter boost: ");
                    additionalInfo = scanner.nextLine();
                    break;
                case "ecu":
                    // No additional information for ECU
                    break;
                case "rear wing":
                    System.out.print("Enter material: ");
                    additionalInfo = scanner.nextLine();
                    break;
                case "aero kit":
                    System.out.print("Enter color: ");
                    additionalInfo = scanner.nextLine();
                    break;
                default:
                    System.out.println("Invalid part type.");
                    return;
            }
    
            // Construct the new part line
            String newPartLine = newIndex + "," + name + "," + type + "," + brand + "," + price + "," + volume + "," + additionalInfo;
    
            // Append the new line to the CSV file
            try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(CSV_FILE_PATH, true)))) {
                writer.println(newPartLine);
                System.out.println("New part added successfully.");
    
            } catch (IOException e) {
                System.out.println("Error writing to the CSV file.");
                e.printStackTrace();
    
            }
    
        }
    
    }

    private static int findHighestIndex() {
        int highestIndex = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                int currentId = Integer.parseInt(parts[0]);
                highestIndex = Math.max(highestIndex, currentId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return highestIndex;
    }
    
    // Other methods...
}
