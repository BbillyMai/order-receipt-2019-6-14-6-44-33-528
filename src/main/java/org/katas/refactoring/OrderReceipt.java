package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();

        receipt.append("======Printing Orders======\n");

        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());

        double totSalesTx = 0d;
        double total = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(String.format("%s\t%s\t%s\t%s\n", lineItem.getDescription(), lineItem.getPrice(), lineItem.getQuantity(), lineItem.subTotal()));

            totSalesTx += lineItem.calculateSalesTax();

            total += lineItem.totalAmount();
        }

        receipt.append("Sales Tax").append('\t').append(totSalesTx);

        receipt.append("Total Amount").append('\t').append(total);
        return receipt.toString();
    }
}