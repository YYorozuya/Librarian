package com.example.service;

import com.example.domain.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

class BookServiceTest {

    @Test
    void test() {
        /*BookService.add("9780241950425","Catcher in the Rye","Jerome David Salinger","Novel",39.00,1,1,1,3);
        BookService.add("9781408274323","Schindler's list","Thomas Keneally","Novel",81.00,1,1,1,3);
        BookService.add("9787511543318","Pride and Prejudice","Jane Austen","Novel",28.20,1,1,1,3);
        BookService.add("9780156013987","Le Petit Prince","JAntoine de Saint-Exupéry","Novel",51.00,1,1,2,3);
        BookService.add("9788026857211","Die Welt von Gestern","Stefan Zweig","Biography",77.00,1,1,2,3);
        BookService.add("9787302392644","The Mythical Man-Month","FrederickP.Brooks.Jr.","Computer/Network",77.00,1,2,1,3);
        BookService.add("9787538692990","The Art of War","Sun Tzu","Philosophy",46.00,2,1,1,3);*/
        //BookService.edit("97875386929900003","dddd","xxxx","ssss",9999.99,99,99,99);
        //BookService.delele("97875386929900003");
        List<Book> list = BookService.findFuzzy("Le","thomas","novel");
        for (Book book:list)
            System.out.println(book);
    }
}