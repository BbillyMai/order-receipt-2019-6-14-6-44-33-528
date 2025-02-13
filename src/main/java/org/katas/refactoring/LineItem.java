package org.katas.refactoring;

public class LineItem {
    private String description;
    private double price;
    private int quantity;

    public LineItem(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double subTotal() {
        return price * quantity;
    }

    double calculateSalesTax() {
        return subTotal() * .10;
    }

    double totalAmount() {
        return subTotal() + calculateSalesTax();
    }
}