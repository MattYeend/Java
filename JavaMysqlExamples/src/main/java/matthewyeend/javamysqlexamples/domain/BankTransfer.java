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
public record BankTransfer(String sortCodeSuffix) implements PaymentMethod {

    public BankTransfer {
        Objects.requireNonNull(sortCodeSuffix, "sortCodeSuffix must not be null");
        if (!sortCodeSuffix.matches("\\d{2}")) {
            throw new IllegalArgumentException("sortCodeSuffix must be two digits");
        }
    }
}