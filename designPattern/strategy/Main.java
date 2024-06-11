package designPattern.strategy;

public class Main {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456", "John Doe");
        cart.setPaymentStrategy(creditCard);
        cart.checkout(100.0);
        PaymentStrategy paypal = new PayPalPayment("john.doe@example.com");
        cart.setPaymentStrategy(paypal);
        cart.checkout(50.0);
        PaymentStrategy bitcoin = new BitcoinPayment("1F1tAaz5x1HUXrCNLbtMDqcw6o5GNn4xqX");
        cart.setPaymentStrategy(bitcoin);
        cart.checkout(200.0);
    }
}
