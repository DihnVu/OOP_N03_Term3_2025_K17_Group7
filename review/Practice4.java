import java.util.ArrayList;

public class BookList {

    ArrayList<Book> books = new ArrayList<>();

    // Add Book
    public ArrayList<Book> addBook(Book book) {
        books.add(book);
        return books;
    }

    // Edit Book
    public ArrayList<Book> editBook(int bookId, String newTitle, String newAuthor) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).bookId == bookId) {
                books.get(i).title = newTitle;
                books.get(i).author = newAuthor;
            }
        }
        return books;
    }

    // Delete Book
    public ArrayList<Book> deleteBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).bookId == bookId) {
                books.remove(i);
                break;
            }
        }
        return books;
    }

    public void printBooks() {
        for (Book b : books) {
            System.out.println("Book ID: " + b.bookId + " | Title: " + b.title + " | Author: " + b.author);
        }
    }
}

