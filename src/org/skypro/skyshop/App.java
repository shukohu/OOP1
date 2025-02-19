package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine(10);


        Product product1 = new FixPriceProduct("Пицца");
        Product product2 = new SimpleProduct("Сок", 70);
        Product product3 = new DiscountedProduct("Пирог", 74, 5);
        Product product4 = new SimpleProduct("Соус", 20);
        Product product5 = new SimpleProduct("Чай", 58);
        Product product6 = new SimpleProduct("Суши", 1200);

        // 1 Добавление продукта в корзину.

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);

        // 2 Добавление продукта в заполненную корзину, в которой нет свободного места.
        searchEngine.add(new SimpleProduct("Суши", 1250));

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

        // Статьи
        Article article1 = new Article("Статья о пицце: ", "Пицца - это быстро и вкусно.");
        Article article2 = new Article("Статья о чае: ", "Чай содержит различные соединения, которые могут оказывать успокаивающее воздействие на организм.");

        // Статьи для поиска
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println("Результат поиска для 'пиццы':");
        System.out.println(Arrays.toString(searchEngine.search("Пицца")));

        System.out.println("Результат поиска для 'чаев':");
        System.out.println(Arrays.toString(searchEngine.search("Чай")));
    }
}
