/*
 * Author:  Matthew Yeend
 * Project: Library Management
 * File:    Member
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.librarymanagement.models;

/**
 *
 * @author matthewyeend
 */
public class Member {
    private String name;  // Member's name
    private int memberId; // Unique Member ID

    // Constructor to initialize member details
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for memberId
    public int getMemberId() {
        return memberId;
    }

    // Overriding toString() to display member details
    @Override
    public String toString() {
        return "Member{" + "Name='" + name + "', Member ID=" + memberId + "}";
    }
}
