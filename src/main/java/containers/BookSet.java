package containers;

import entities.Book;

import java.util.*;

public class BookSet {
    private static final Set<Book> bookSet = new HashSet<>();

    public static void add(Book book) {
        bookSet.add(book);
    }

    public static void remove(Book book) {
        bookSet.remove(book);
    }

    public static Set<Book> getSet() {
        return Collections.unmodifiableSet(bookSet);
    }
}
