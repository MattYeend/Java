/*
 * Author:  Matthew Yeend
 * Project: InventoryManagement
 * File:    Order
 * Version: v1.1.1
 * Date:    27/03/2025
 */

package matthewyeend.inventorymanagement;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author matthewyeend
 */
public class Order {
    private Map<Product, Integer> items;

    public Order() {
        items = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, quantity);
    }

    public void processOrder(Inventory inventory) {
        System.out.println("Processing Order:");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = inventory.getProductByName(entry.getKey().getName());
            if (product != null) {
                product.reduceQuantity(entry.getValue());
                System.out.println("Ordered " + entry.getValue() + " of " + product.getName());
            }
        }
    }
}
