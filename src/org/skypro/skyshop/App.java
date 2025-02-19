package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product FixePricePizza = new FixPriceProduct("Пицца");
        Product SimpleProductJuice = new SimpleProduct("Сок", 70);
        Product DiscountedPie = new DiscountedProduct("Пирог", 74, 5);
        Product SimpleProductSauce = new SimpleProduct("Соус", 20);
        Product SimpleProductTea = new SimpleProduct("Чай", 58);
        Product SimpleProductSushi = new SimpleProduct("Суши", 1200);

        // 1 Добавление продукта в корзину.
        basket.addProduct(FixePricePizza);
        basket.addProduct(SimpleProductJuice);
        basket.addProduct(DiscountedPie);
        basket.addProduct(SimpleProductSauce);
        basket.addProduct(SimpleProductTea);

        // 2 Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addProduct(new SimpleProduct("Суши", 1250));

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
