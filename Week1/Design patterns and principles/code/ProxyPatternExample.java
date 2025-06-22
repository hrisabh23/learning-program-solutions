// Full Proxy Pattern Implementation in One File



// Step 1: Subject Interface

interface Image {

    void display();

}



// Step 2: Real Subject

class RealImage implements Image {

    private String filename;



    public RealImage(String filename) {

        this.filename = filename;

        loadFromServer();

    }



    private void loadFromServer() {

        System.out.println("Loading image from remote server: " + filename);

    }



    public void display() {

        System.out.println("Displaying image: " + filename);

    }

}



// Step 3: Proxy Class

class ProxyImage implements Image {

    private String filename;

    private RealImage realImage;



    public ProxyImage(String filename) {

        this.filename = filename;

    }



    public void display() {

        if (realImage == null) {

            realImage = new RealImage(filename); // Lazy loading

        }

        realImage.display(); // Cache used after first load

    }

}



// Step 4: Test Class

public class ProxyPatternExample {

    public static void main(String[] args) {

        Image img1 = new ProxyImage("nature.jpg");

        Image img2 = new ProxyImage("mountain.png");



        // Only loads when displayed

        img1.display(); // Loads from server

        img1.display(); // Uses cache



        img2.display(); // Loads from server

        img2.display(); // Uses cache

    }

}
