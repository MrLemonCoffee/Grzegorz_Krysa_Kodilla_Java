package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest(){
        //Given
        Book book1 = new Book("Adam Mickiewicz", "Pan Tadeusz", 1832, "4589647");
        Book book2 = new Book("Adam Mickiewicz", "Sonety Krymskie", 1825, "5896421");
        Book book3 = new Book("Henryk Sienkiewicz", "Ogniem i mieczem", 1884, "5867423");
        Book book4 = new Book("Remigiusz Mróz", "Behawiorysta", 2016, "5964123");
        Book book5 = new Book("Katarzyna Bonda", "Florystka", 2012, "5697463");

        Set<Book> bookSet = new HashSet<>();

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(1884, median);
    }
}