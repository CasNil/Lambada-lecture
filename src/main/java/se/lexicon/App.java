package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void process(List<Product> products, Conditional condition, Action action) {
        for (Product product : products) {
            if (condition.test(product)) {
                action.execute(product);
            }
        }
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Iphone 13", 1200, 12));
        productList.add(new Product("MacBook", 1400, 4));
        productList.add(new Product("Iphone 7", 130, 1));
        productList.add(new Product("Samsung S21 ", 1300, 11));
        productList.add(new Product("Best", 120, 0));

        Action action = p -> System.out.println(p.toString());
        Conditional condition = p -> p.getStock() == 0;
        process(productList, condition, action);
        System.out.println("-------------------");

        process(productList, p -> p.getProductName().startsWith("B"), p -> System.out.println(p));
        System.out.println("-------------------");

        process(productList, p -> p.getPrice() > 100 && p.getPrice() < 150, p -> System.out.println(p.getProductName()));
        System.out.println("-------------------");

        process(productList, p -> p.getStock() < 10 && p.getStock() > 0, p -> p.setPrice(1.5 * p.getPrice()));
        System.out.println(productList);
    }
}
