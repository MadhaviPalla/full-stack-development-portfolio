import java.io.*;
import java.util.*;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Load data from file
    public void loadData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("library_data.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            books.add(new Book(data[0], data[1], Boolean.parseBoolean(data[2])));
        }
        reader.close();
    }

    // Save data to file
    public void saveData() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("library_data.txt"));
        for (Book book : books) {
            writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.isAvailable() + "\n");
        }
        writer.close();
    }

    // Display available books
    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    // Borrow a book
    public void borrowBook(String bookTitle, String userName) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println(userName + " borrowed the book: " + bookTitle);
                return;
            }
        }
        System.out.println("Sorry, the book is not available.");
    }

    // Return a book
    public void returnBook(String bookTitle, String userName) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println(userName + " returned the book: " + bookTitle);
                return;
            }
        }
        System.out.println("Sorry, the book was not borrowed.");
    }

    public static void main(String[] args) throws IOException {
        Library library = new Library();
        library.loadData();

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Library Management System");
            System.out.println("1. View available books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    library.displayAvailableBooks();
                    break;
                case "2":
                    System.out.print("Enter book title: ");
                    String borrowTitle = scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String borrowName = scanner.nextLine();
                    library.borrowBook(borrowTitle, borrowName);
                    break;
                case "3":
                    System.out.print("Enter book title: ");
                    String returnTitle = scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String returnName = scanner.nextLine();
                    library.returnBook(returnTitle, returnName);
                    break;
                case "4":
                    library.saveData();
                    System.out.println("Thank you for using the Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (!choice.equals("4"));

        scanner.close();
    }
}
