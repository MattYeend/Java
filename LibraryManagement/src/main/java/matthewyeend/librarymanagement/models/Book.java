/*
 * Author:  Matthew Yeend
 * Project: Library Management
 * File:    Book
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.librarymanagement.models;

/**
 *
 * @author matthewyeend
 */
public class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Returns book details
    @Override
    public String toString() {
        return title + " by " + author;
    }
}
