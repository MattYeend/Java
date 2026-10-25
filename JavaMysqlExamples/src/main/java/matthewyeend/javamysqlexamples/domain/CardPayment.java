/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matthewyeend.javamysqlexamples.domain;

import java.util.Objects;
/**
 *
 * @author matthewyeend
 */
public record CardPayment(String last4) implements PaymentMethod {

    public CardPayment {
        Objects.requireNonNull(last4, "last4 must not be null");
        if (!last4.matches("\\d{4}")) {
            throw new IllegalArgumentException("last4 must be exactly four digits");
        }
    }
}
