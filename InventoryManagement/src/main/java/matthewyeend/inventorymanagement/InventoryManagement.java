/*
 * Author:  Matthew Yeend
 * Project: InventoryManagement
 * File:    InventoryManagement (main)
 * Version: v1.1.1
 * Date:    27/03/2025
 */

package matthewyeend.inventorymanagement;

/**
 *
 * @author matthewyeend
 */
public class InventoryManagement {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product product1 = new Product("Laptop", 1000, 10);
        Product product2 = new Product("Phone", 500, 20);
        
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        
        inventory.displayProducts();
        
        Order order = new Order();
        order.addProduct(product1, 2);
        order.addProduct(product2, 1);
        
        order.processOrder(inventory);
        inventory.displayProducts();
    }
}
