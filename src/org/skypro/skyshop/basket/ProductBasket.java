package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = products.remove(name);
        return removedProducts != null ? removedProducts : new ArrayList<>();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Содержимое корзины:");
            for (List<Product> productList : products.values()) {
                for (Product product : productList) {
                    System.out.println(product);
                }
            }
        }
    }

    public String addProduct(String Pizza) {
        return null;
    }
}

