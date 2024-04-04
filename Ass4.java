/*
Name: Abdul Qadir Batavia
Program Name: Product Management System
Date: 2024-04-02
Description: This program implements a product management system that includes classes for both non-perishable and 
perishable products. It allows the user to create, store, and display details of various products.
*/

package Work;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class Product {
    // Data Members
    private String sku;
    private String productName;
    private double unitCost;
    private int quantityOnHand;
    private int quantityNeeded;
    private String specialInstructions;

    // Constructors
    public Product() {
        this.sku = "Default SKU";
        this.productName = "Default Product";
        this.unitCost = 0.0;
        this.quantityOnHand = 0;
        this.quantityNeeded = 0;
        this.specialInstructions = "No special instructions";
    }

    public Product(String sku, String productName, double unitCost, int quantityOnHand, int quantityNeeded, String specialInstructions) {
        this.sku = sku;
        this.productName = productName;
        this.unitCost = unitCost;
        this.quantityOnHand = quantityOnHand;
        this.quantityNeeded = quantityNeeded;
        this.specialInstructions = specialInstructions;
    }

    // Getter methods
    public String getSku() {
        return sku;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    // Setter methods
    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public void setQuantityNeeded(int quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    // Display method
    public void display() {
        System.out.println("SKU: " + sku);
        System.out.println("Product Name: " + productName);
        System.out.println("Unit Cost: " + unitCost);
        System.out.println("Quantity on Hand: " + quantityOnHand);
        System.out.println("Quantity Needed: " + quantityNeeded);
        System.out.println("Special Instructions: " + specialInstructions);
    }
}

class PerishableProduct extends Product {
    // Private Data Members
    private Date expiryDate;

    // Constructors
    public PerishableProduct() {
        super();
        this.expiryDate = new Date();
    }

    public PerishableProduct(String sku, String productName, double unitCost, int quantityOnHand, int quantityNeeded, String specialInstructions, Date expiryDate) {
        super(sku, productName, unitCost, quantityOnHand, quantityNeeded, specialInstructions);
        this.expiryDate = expiryDate;
    }

    // Getter and Setter methods for expiry date
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Display method overriding base class method
    @Override
    public void display() {
        super.display();
        System.out.println("Expiry Date: " + expiryDate);
    }
}

public class Ass4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> productList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for Product " + (i+1) + ":");

            System.out.print("SKU: ");
            String sku = scanner.nextLine();

            System.out.print("Product Name: ");
            String productName = scanner.nextLine();

            System.out.print("Unit Cost: ");
            double unitCost = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            System.out.print("Quantity on Hand: ");
            int quantityOnHand = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            System.out.print("Quantity Needed: ");
            int quantityNeeded = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            System.out.print("Special Instructions: ");
            String specialInstructions = scanner.nextLine();

            System.out.print("Expiry Date (YYYY-MM-DD): ");
            String expiryDateStr = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            long expiryDateInMillis = 0;
            try {
                Date expiryDate = dateFormat.parse(expiryDateStr);
                expiryDateInMillis = expiryDate.getTime();
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
                continue; // Restart the loop to re-enter details for the current product
            }

            PerishableProduct perishableProduct = new PerishableProduct(sku, productName, unitCost, quantityOnHand, quantityNeeded, specialInstructions, new Date(expiryDateInMillis));
            productList.add(perishableProduct);
        }

        scanner.close();

        // Display all products
        for (Product product : productList) {
            product.display();
            System.out.println();
        }
    }
}