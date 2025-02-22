package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;


public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine();


        Product product1 = new FixPriceProduct("Пицца");
        Product product2 = new SimpleProduct("Сок", 70);
        Product product3 = new DiscountedProduct("Пирог", 74, 5);
        Product product4 = new SimpleProduct("Соус", 20);
        Product product5 = new SimpleProduct("Чай", 58);
        Product product6 = new SimpleProduct("Суши", 1200);

        //  Добавление продукта в корзину.

        searchEngine.add(product1);
        basket.addProduct(product1);

        searchEngine.add(product2);
        basket.addProduct(product2);

        searchEngine.add(product3);
        basket.addProduct(product3);

        searchEngine.add(product4);
        basket.addProduct(product4);

        searchEngine.add(product5);
        basket.addProduct(product5);

        //  Добавление продукта в заполненную корзину, в которой нет свободного места.
        searchEngine.add(new SimpleProduct("Суши", 1250));

        int totalPrice = basket.getTotalPrice();
        System.out.println("Общая стоимость корзины: " + totalPrice);

        //  Очистка корзины.
        basket.clear();
        System.out.println("Корзина очищена.");
        basket.printBasket();
        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());


        // Статьи
        Article article1 = new Article("Статья о пицце: ", "Пицца - это быстро и вкусно.");
        Article article2 = new Article("Статья о чае: ", "Чай содержит различные соединения, которые могут оказывать успокаивающее воздействие на организм.");
        searchEngine.add(article1);
        searchEngine.add(article2);


        System.out.println("Результат поиска для 'Пицца':");
        Set<Searchable> searchResults = searchEngine.search("Пицца");
        System.out.println("Найденные продукты и статьи : " +  searchEngine.search("Пицца"));

        System.out.println("Результат поиска для 'Чай':");
        Set<Searchable> searchResults2 = searchEngine.search("Чай");
        System.out.println("Найденные продукты и статьи : " + searchEngine.search("Чай"));


        System.out.println("\nПоиск 'Кофе':");
        Set<Searchable> searchResults3 = searchEngine.search("Кофе");
        System.out.println("Найденные продукты и статьи: " + searchResults3);

        // Неправильные продукты
        try {
            SimpleProduct invalidPriceProduct = new SimpleProduct("Сок", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка:" + e.getMessage());
        }
        try {
            DiscountedProduct invalidPriceProduct = new DiscountedProduct("Пирог", 0, 110);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка:" + e.getMessage());
        }

        // Поиск
        try {
            Searchable bestMatch = searchEngine.findBestMatch("Чай");
            System.out.println("Лучший результат для 'чай': " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка" + e.getMessage());

        }
    }
}

