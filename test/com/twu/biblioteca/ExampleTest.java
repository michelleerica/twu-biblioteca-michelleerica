package com.twu.biblioteca;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ExampleTest {
    private Library library;
    private Book book = new Book("Huckleberry Finn", "Mark Twain", 1884, true);
    private Book bookAlt = new Book("Tom Sawyer", "Mark Twain", 1884, true);
    private Book bookUnavailable = new Book("Little Women", "Louise May Alcott", 1844, false);


    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void welcomeMessageTest(){
        assertEquals("Welcome to Biblioteca", library.getWelcomeMessage());
    }

    @Test
    public void optionListTest(){
        String message = "Menu options: \n" +
                " L: View All Books\n" +
                " C: View available books for checkout";

        assertEquals(message, library.getMenu());
    }


    @Test
    public void checkoutTest(){
        library.checkout(book);
        System.out.println(book.title);
        System.out.println(book.available);
        assertFalse(book.available);
        library.listAllBooks();

//                System.out.println(book.available);



    }

//
//    @Test
//    public void booksAvailable(){
//        String expectedOutput = "Little Women | Louise May Alcott | 1868 | true";
//        assertEquals(expectedOutput, library.listAvailableBooks());
//    }
//

}
