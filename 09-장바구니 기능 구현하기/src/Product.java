package src;

import java.util.Objects;

class Product {
    private final String key;
    private final String name;
    private final double price;

    public Product(String key, String name, double price) {
        this.key = key;
        this.name = name;
        this.price = price;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(key, product.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}

