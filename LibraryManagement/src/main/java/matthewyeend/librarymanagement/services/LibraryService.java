/*
 * Author:  Matthew Yeend
 * Project: Library Management
 * File:    LibraryServices
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.librarymanagement.services;

import matthewyeend.librarymanagement.models.Book;
import matthewyeend.librarymanagement.models.Member;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matthewyeend
 */
public class LibraryService {
    // List to store books and members
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    // Adds a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    // Adds a new library member
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member);
    }

    // Displays all books in the library
    public void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
