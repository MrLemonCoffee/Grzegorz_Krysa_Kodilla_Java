package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;



public class LibraryTestSuite {

    @Test
    void testGetBooks(){
        //Given
        LocalDate publicationDateOfBook1 = LocalDate.of(1911,5,16);
        LocalDate publicationDateOfBook2 = LocalDate.of(2015,8,14);
        LocalDate publicationDateOfBook3 = LocalDate.of(1834,7,19);

        Book book1 = new Book("W pustyni i w puszczy","Henryk Sienkiewicz", publicationDateOfBook1);
        Book book2 = new Book("Kasacja. Joanna Chylka", "Remigiusz Mroz",publicationDateOfBook2);
        Book book3 = new Book("Pan Tadeusz", "Adam Mickiewicz",publicationDateOfBook3);

        Library library = new Library("Library");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book1);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assertions.assertEquals(2, library.getBooks().size());
        Assertions.assertEquals(2, clonedLibrary.getBooks().size());
        Assertions.assertEquals(3, deepClonedLibrary.getBooks().size());
        Assertions.assertEquals(library.getBooks(), clonedLibrary.getBooks());
        Assertions.assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());

    }
}
