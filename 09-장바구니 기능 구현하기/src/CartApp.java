package src;

import java.io.*;
import java.util.*;

public class CartApp {
    public static void main(String[] args) {
        Set<Product> productSet = new HashSet<>();

        // CSV 파일에서 상품 목록 불러오기
        loadProductsFromCSV("products.csv", productSet);

        // 상품 목록 출력
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성 및 사용
        Cart myCart = new Cart();
        Product milk = new Product("001", "우유", 2.5);
        Product apple = new Product("002", "사과", 1.0);

        myCart.addProduct(milk, 2);
        myCart.addProduct(apple, 3);
        myCart.removeProduct(milk, 1);

        myCart.showItems();
    }

    public static void loadProductsFromCSV(String filePath, Set<Product> productSet) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    String key = values[0];
                    String name = values[1];
                    double price = Double.parseDouble(values[2]);
                    productSet.add(new Product(key, name, price));
                }
            }
        } catch (IOException e) {
            System.out.println("CSV 파일을 읽는 중 오류 발생: " + e.getMessage());
        }
    }
}
