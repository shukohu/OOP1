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

import java.util.Arrays;
import java.util.List;


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

        // 1 Добавление продукта в корзину.

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);

        // 2 Добавление продукта в заполненную корзину, в которой нет свободного места.
        searchEngine.add(new SimpleProduct("Суши", 1250));

        // 3 Печать содержимого корзины с несколькими товарами
        basket.printBasket();

        // 4 Получение стоимости корзины с несколькими товарами.
        System.out.println("Стоимость корзины: " + basket.getClass());

        // 5 Поиск товара, который есть в корзине.
        System.out.println("Содержит корзина Пицца: " + basket.addProduct("Пицца"));

        // 6 Поиск товара, которого нет в корзине.
        System.out.println("Содержит корзина Суши: " + basket.addProduct("Суши"));

        // 7 Очистка корзины.
        basket.printBasket();

        // 8 Печать содержимого пустой корзины.
        basket.printBasket();

        // 9 Получение стоимости пустой корзины.
        System.out.println("Стоимость пустой корзины: " + basket.getClass());

        // 10 Поиск товара по имени в пустой корзине.
        System.out.println("Содержит корзина Пицца: " + basket.addProduct("Пицца"));

        // Статьи
        Article article1 = new Article("Статья о пицце: ", "Пицца - это быстро и вкусно.");
        Article article2 = new Article("Статья о чае: ", "Чай содержит различные соединения, которые могут оказывать успокаивающее воздействие на организм.");

        // Статьи для поиска
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println("Результат поиска для 'пиццы':");
        List<Searchable> searchResults = searchEngine.search("Пицца");
        System.out.println("Найденные продукты: " + searchResults);

        System.out.println("Результат поиска для 'чая':");
        List<Searchable> searchResults2 = searchEngine.search("Чай");
        System.out.println("Найденный продукты: " + searchResults2);

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
        } catch (BestResultNotFound e){
            System.out.println("Ошибка" + e.getMessage());

        }
        try {
            Searchable bestMatch = searchEngine.findBestMatch("Article");
            System.out.println("Лучший результат для 'Article': " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e){
            System.out.println("Ошибка: " + e.getMessage());

        }
        System.out.println("Удаление продукта 'Пицца' :");
        List<Product> removedProducts = basket.removeProductByName("Пицца");
        System.out.println("Удаленные продукты: " + removedProducts);
        basket.printBasket();

        System.out.println("\nУдаление продукта 'Кофе':");
        List<Product> removedProducts2 = basket.removeProductByName("Кофе");
        if (removedProducts2.isEmpty()) {
            System.out.println("Список пуст.");
        }
        basket.printBasket();
    }
}
