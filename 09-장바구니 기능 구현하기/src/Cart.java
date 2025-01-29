package src;

import java.util.HashMap;
import java.util.Map;

class Cart {
    private final Map<Product, Integer> cartItems = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product, int quantity) {
        if (cartItems.containsKey(product)) {
            int remaining = cartItems.get(product) - quantity;
            if (remaining > 0) {
                cartItems.put(product, remaining);
            } else {
                cartItems.remove(product);
            }
        }
    }

    public void showItems() {
        System.out.println("장바구니 내역:");
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey().getName() + " - " + entry.getValue() + "개");
        }
    }
}

