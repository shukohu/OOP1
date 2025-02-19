package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product pizza = new Product("Пицца", 350);
        Product juice = new Product("Сок", 70);
        Product pie = new Product("Пирог", 74);
        Product sauce = new Product("Соус", 20);
        Product tea = new Product("Чай", 58);
        Product sushi = new Product("Суши", 1200);

        // 1 Добавление продукта в корзину.
        basket.addProduct(pizza);
        basket.addProduct(juice);
        basket.addProduct(pie);
        basket.addProduct(sauce);
        basket.addProduct(tea);

        // 2 Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addProduct(new Product("Суши", 1250));

        // 3 Печать содержимого корзины с несколькими товарами
        basket.printBasketContents();

        // 4 Получение стоимости корзины с несколькими товарами.
        System.out.println("Стоимость корзины: " + basket.getTotalPrice());

        // 5 Поиск товара, который есть в корзине.
        System.out.println("Содержит корзина Пицца: " + basket.containsProduct("Пицца"));

        // 6 Поиск товара, которого нет в корзине.
        System.out.println("Содержит корзина Суши: " + basket.containsProduct("Суши"));

        // 7 Очистка корзины.
        basket.clearBasket();

        // 8 Печать содержимого пустой корзины.
        basket.printBasketContents();

        // 9 Получение стоимости пустой корзины.
        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());

        // 10 Поиск товара по имени в пустой корзине.
        System.out.println("Содержит корзина Пицца: " + basket.containsProduct("Пицца"));
    }
}
