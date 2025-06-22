import java.util.Arrays;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return bookId + " - " + title + " by " + author;
    }
}

public class LibrarySystem {

    // Linear search
    static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    // Binary search (books must be sorted by title)
    static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "C Programming", "Anivesh Soni"),
            new Book(2, "Java Basics", "Hrisabh Singh"),
            new Book(3, "Python Intro", "Tushant Verma")
        };

        // Sort books by title for binary search
        Arrays.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));

        // Search using linear and binary
        Book linearResult = linearSearch(books, "Java Basics");
        Book binaryResult = binarySearch(books, "Java Basics");

        System.out.println("Linear Search: " + (linearResult != null ? linearResult : "Not Found"));
        System.out.println("Binary Search: " + (binaryResult != null ? binaryResult : "Not Found"));
    }
}
