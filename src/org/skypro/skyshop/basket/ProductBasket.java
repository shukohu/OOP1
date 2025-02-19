package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products;
    private int ProductCount;

    public ProductBasket() {
        this.products = new Product[5];
        this.ProductCount = 0;
    }

    public void addProduct(Product product) {
        if (ProductCount < products.length) {
            products[ProductCount] = product;
            ProductCount++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();

            }
        }
        return total;
    }

    public void printBasketContents() {
        if (ProductCount == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialProductsCount = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.toString());
                if (product.isSpecial()) {
                    specialProductsCount++;
                }
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialProductsCount);
    }

    public boolean containsProduct(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        ProductCount = 0;
    }
}

