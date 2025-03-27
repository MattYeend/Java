/*
 * Author:  Matthew Yeend
 * Project: InventoryManagement
 * File:    Product
 * Version: v1.1.1
 * Date:    27/03/2025
 */

package matthewyeend.inventorymanagement;

/**
 *
 * @author matthewyeend
 */
public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
        } else {
            System.out.println("Not enough stock for " + name);
        }
    }

    @Override
    public String toString() {
        return name + " - $" + price + " - Quantity: " + quantity;
    }
}
