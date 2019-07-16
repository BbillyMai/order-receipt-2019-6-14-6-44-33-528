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
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        double totSalesTx = 0d;
        double total = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(String.format("%s\t%s\t%s\t%s\n",lineItem.getDescription(),lineItem.getPrice(),lineItem.getQuantity(),lineItem.subTotal()));

            totSalesTx += lineItem.calculateSalesTax();

            total += lineItem.totalAmount();
        }

        output.append("Sales Tax").append('\t').append(totSalesTx);

        output.append("Total Amount").append('\t').append(total);
        return output.toString();
    }
}