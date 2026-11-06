/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matthewyeend.multifile.models;

import matthewyeend.multifile.utils.Helper;

/**
 *
 * @author matthewyeend
 */
public record User(String name, int age) {

    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 150;

    public User {
        name = Helper.requireValidName(name);
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new IllegalArgumentException(
                    "Age must be between " + MIN_AGE + " and " + MAX_AGE);
        }
    }
}
