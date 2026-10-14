/*
 * Name: Abdul Qadir Batavia
 * Program Name: Vaccine 
 * Date: March 11, 2024
 * Description: This program in Java helps manage information about vaccines, 
 * allowing users to create, edit, and view details like vaccine name, cost, 
 * quantity, expiry date, and special instructions.
 */

package Work;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Vaccine {
    private int vaccineId;
    private String vaccineName;
    private double unitCost;
    private int quantity;
    private Date expiryDate;
    private String specialInstructions;

    // Default Constructor with default values
    public Vaccine() {
        this.vaccineId = 0;
        this.vaccineName = "Unknown Vaccine";
        this.unitCost = 0.0;
        this.quantity = 0;
        this.expiryDate = new Date();
        this.specialInstructions = "No special instructions";
    }

    // Parameterized Constructor
    public Vaccine(int vaccineId, String vaccineName, double unitCost, int quantity, Date expiryDate, String specialInstructions) {
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.specialInstructions = specialInstructions;
    }

    // Getter and Setter methods
    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    // Display function
    public void display(boolean tableFormat) {
        if (tableFormat) {
            System.out.printf("%-5s|%-20s|%-10s|%-5s|%-10s|%-30s%n", "SKU", "Vaccine Name", "Unit Cost", "QTY", "Expiry", "Special Instructions");
            System.out.println("------------------------------------------------------------");
            System.out.printf("%-5d|%-20s|%-10.2f|%-5d|%-10s|%-30s%n", vaccineId, vaccineName, unitCost, quantity, new SimpleDateFormat("yyyy-MM-dd").format(expiryDate), specialInstructions);
        } else {
            System.out.println("SKU: " + vaccineId);
            System.out.println("Vaccine Name: " + vaccineName);
            System.out.println("Unit Cost: " + unitCost);
            System.out.println("Quantity on hand: " + quantity);
            System.out.println("Expiry Date: " + new SimpleDateFormat("yyyy-MM-dd").format(expiryDate));
            System.out.println("Special Instructions: " + specialInstructions);
        }
    }

    public static void main(String[] args) {
        // Create an empty Vaccine using the default constructor
        Vaccine emptyVaccine = new Vaccine();

        // Display the empty Vaccine in a non-linear format
        System.out.println("Empty Vaccine Details:");
        emptyVaccine.display(false);

        // Set values to the empty Vaccine
        emptyVaccine.setVaccineId(1);
        emptyVaccine.setVaccineName("COVID-19 Vaccine");
        emptyVaccine.setUnitCost(25.50);
        emptyVaccine.setQuantity(1000);
        emptyVaccine.setExpiryDate(new Date(2024 - 1900, 5, 1)); // Example expiry date
        emptyVaccine.setSpecialInstructions("Keep refrigerated at 2-8°C");

        // Display the details of the Vaccine in a non-linear format
        System.out.println("\nUpdated Vaccine Details:");
        emptyVaccine.display(false);

        // Create two more vaccines
        Vaccine vaccine1 = new Vaccine(2, "Flu Vaccine", 15.75, 500, new Date(2024 - 1900, 8, 1), "None");
        Vaccine vaccine2 = new Vaccine(3, "Hepatitis B Vaccine", 35.25, 300, new Date(2024 - 1900, 10, 1), "Handle with care");

        // Create an array to save all the vaccines
        Vaccine[] vaccines = {emptyVaccine, vaccine1, vaccine2};

        // Display the contents of the Vaccines in a table format
        System.out.println("\nAll Vaccines Details (Table Format):");
        for (Vaccine vaccine : vaccines) {
            vaccine.display(true);
        }
    }
}