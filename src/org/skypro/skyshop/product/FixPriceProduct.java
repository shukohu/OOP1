package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int Fix_Price_Product =450;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return Fix_Price_Product;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + Fix_Price_Product;
    }
}
