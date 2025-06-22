// Full Decorator Pattern Example in One File



// Step 1: Component Interface

interface Notifier {

    void send();

}



// Step 2: Concrete Component

class EmailNotifier implements Notifier {

    public void send() {

        System.out.println("Sending Email Notification");

    }

}



// Step 3: Abstract Decorator

abstract class NotifierDecorator implements Notifier {

    protected Notifier notifier;



    public NotifierDecorator(Notifier notifier) {

        this.notifier = notifier;

    }



    public void send() {

        notifier.send();

    }

}



// Step 4: Concrete Decorators

class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {

        super(notifier);

    }



    public void send() {

        super.send();

        System.out.println("Sending SMS Notification");

    }

}



class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {

        super(notifier);

    }



    public void send() {

        super.send();

        System.out.println("Sending Slack Notification");

    }

}



// Step 5: Test Class

public class NotificationDecoratorExample {

    public static void main(String[] args) {

        // Base notifier

        Notifier email = new EmailNotifier();



        // Add SMS decorator

        Notifier smsEmail = new SMSNotifierDecorator(email);



        // Add Slack on top of SMS + Email

        Notifier allChannels = new SlackNotifierDecorator(smsEmail);



        // Send notifications via all channels

        allChannels.send();

    }

}