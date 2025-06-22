// Strategy Interface

interface PaymentStrategy {

    void pay(int amount);

}



// Concrete Strategies

class CreditCardPayment implements PaymentStrategy {

    public void pay(int amount) {

        System.out.println("Paid ₹" + amount + " using Credit Card.");

    }

}



class PayPalPayment implements PaymentStrategy {

    public void pay(int amount) {

        System.out.println("Paid ₹" + amount + " using PayPal.");

    }

}



// Context Class

class PaymentContext {

    private PaymentStrategy strategy;



    public void setPaymentStrategy(PaymentStrategy strategy) {

        this.strategy = strategy;

    }



    public void executePayment(int amount) {

        if (strategy != null) {

            strategy.pay(amount);

        } else {

            System.out.println("No payment strategy selected.");

        }

    }

}



// Test Class

public class StrategyPatternExample {

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();



        // Using Credit Card

        context.setPaymentStrategy(new CreditCardPayment());

        context.executePayment(1500);



        // Using PayPal

        context.setPaymentStrategy(new PayPalPayment());

        context.executePayment(2500);

    }

}