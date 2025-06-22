



// Step 1: Target Interface

interface PaymentProcessor {

    void processPayment(double amount);

}



// Step 2: Adaptee Classes (3rd-party gateways)

class PayPalGateway {

    public void sendPayment(double amount) {

        System.out.println("Payment of $" + amount + " processed via PayPal.");

    }

}



class StripeGateway {

    public void makePayment(double amount) {

        System.out.println("Payment of $" + amount + " processed via Stripe.");

    }

}



// Step 3: Adapter Classes

class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway paypal = new PayPalGateway();



    public void processPayment(double amount) {

        paypal.sendPayment(amount);

    }

}



class StripeAdapter implements PaymentProcessor {

    private StripeGateway stripe = new StripeGateway();



    public void processPayment(double amount) {

        stripe.makePayment(amount);

    }

}



// Step 4: Test Class

public class PaymentAdapterExample {

    public static void main(String[] args) {

        PaymentProcessor paypalProcessor = new PayPalAdapter();

        PaymentProcessor stripeProcessor = new StripeAdapter();



        System.out.println("Using PayPal Adapter:");

        paypalProcessor.processPayment(250.0);



        System.out.println("\nUsing Stripe Adapter:");

        stripeProcessor.processPayment(450.0);

    }

}