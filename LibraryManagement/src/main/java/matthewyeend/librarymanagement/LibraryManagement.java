/*
 * Author:  Matthew Yeend
 * Project: Library Management
 * File:    LibraryManagement (main)
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.librarymanagement;


import matthewyeend.librarymanagement.models.Book;
import matthewyeend.librarymanagement.models.Member;
import matthewyeend.librarymanagement.services.LibraryService;

/**
 *
 * @author matthewyeend
 */
public class LibraryManagement {

    public static void main(String[] args) {
        // Create a library service object
        LibraryService library = new LibraryService();

        // Adding books to the library
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        // Registering a library member
        library.addMember(new Member("Alice", 101));

        // Display all available books
        library.displayBooks();
    }
}
