/*
 * Author:  Matthew Yeend
 * Project: InventoryManagement
 * File:    Inventory
 * Version: v1.1.1
 * Date:    27/03/2025
 */

package matthewyeend.inventorymanagement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matthewyeend
 */
public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        System.out.println("Inventory:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}
