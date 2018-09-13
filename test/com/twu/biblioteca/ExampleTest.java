package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;


public class ExampleTest {
    private Library library = new Library();


    public static ArrayList<Book> books = new ArrayList<Book>();
    private Book one;

//    @Before
//    public void setUpLibrary(){
//        one = new Book(1,"Huckleberry Finn", "Mark Twain", 1884, true);
//        Book two = new Book(2,"Tom Sawyer", "Mark Twain", 1884, true);
//        Book three = new Book(3,"Little Women", "Louise May Alcott", 1868, false);
//        books.add(one);
//        books.add(two);
//        books.add(three);
//    }

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
    public void listBooksTest(){
//        String booksList = "1 | Huckleberry Finn | Mark Twain | 1884 | Available\n" +
//                "2 | Tom Sawyer | Mark Twain | 1884 | Available\n" +
//                "3 | Little Women | Louise May Alcott | 1868 | Not available";
        System.out.println(library.books);
//        assertTrue(library.books.contains("Huckleberry Finn"));

    }



//    @Test
//    public void checkoutTest(){
//        Library.checkout("1");
//        Library.getAvailableBookList();
//        System.out.println(Library.availableBooks);
//        assertTrue(one.available);
//    }

}
