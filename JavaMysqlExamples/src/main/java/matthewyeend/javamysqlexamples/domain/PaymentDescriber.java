/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matthewyeend.javamysqlexamples.domain;

import matthewyeend.javamysqlexamples.domain.CardPayment;
import matthewyeend.javamysqlexamples.domain.BankTransfer;

/**
 *
 * @author matthewyeend
 */
public final class PaymentDescriber {

    private PaymentDescriber() {
    }

    // The compiler enforces exhaustiveness because the interface is sealed
    public static String describe(PaymentMethod method) {
        return switch (method) {
            case CardPayment card -> "Card ending " + card.last4();
            case BankTransfer bank -> "Bank transfer, sort code ending " + bank.sortCodeSuffix();
        };
    }
}