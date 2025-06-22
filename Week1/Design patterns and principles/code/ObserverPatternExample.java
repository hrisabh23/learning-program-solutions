import java.util.*;



// Step 1: Subject Interface

interface Stock {

    void register(Observer o);

    void deregister(Observer o);

    void notifyObservers();

}



// Step 2: Concrete Subject

class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();

    private int stockPrice;



    public void setStockPrice(int price) {

        this.stockPrice = price;

        notifyObservers();

    }



    public void register(Observer o) {

        observers.add(o);

    }



    public void deregister(Observer o) {

        observers.remove(o);

    }



    public void notifyObservers() {

        for (Observer o : observers) {

            o.update(stockPrice);

        }

    }

}



// Step 3: Observer Interface

interface Observer {

    void update(int stockPrice);

}



// Step 4: Concrete Observers

class MobileApp implements Observer {

    public void update(int stockPrice) {

        System.out.println("Mobile App: Stock price updated to ₹" + stockPrice);

    }

}



class WebApp implements Observer {

    public void update(int stockPrice) {

        System.out.println("Web App: Stock price updated to ₹" + stockPrice);

    }

}



// Step 5: Test Class

public class ObserverPatternExample {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();



        Observer mobileApp = new MobileApp();

        Observer webApp = new WebApp();



        stockMarket.register(mobileApp);

        stockMarket.register(webApp);



        System.out.println("Setting stock price to 500...");

        stockMarket.setStockPrice(500);



        System.out.println("\nDeregistering WebApp...");

        stockMarket.deregister(webApp);



        System.out.println("\nSetting stock price to 620...");

        stockMarket.setStockPrice(620);

    }

}


