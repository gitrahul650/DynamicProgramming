package designPattern.strategy;

public class ShoppingCart {

    private PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }


    public void checkout(double totalAmount) {
        paymentStrategy.pay(totalAmount);
    }
}
