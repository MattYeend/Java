/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matthewyeend.javamysqlexamples.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author matthewyeend
 */
class PaymentDescriberTest {

    @Test
    void describesCard() {
        assertEquals("Card ending 4242", PaymentDescriber.describe(new CardPayment("4242")));
    }

    @Test
    void describesBankTransfer() {
        assertEquals("Bank transfer, sort code ending 12",
                PaymentDescriber.describe(new BankTransfer("12")));
    }

    @Test
    void rejectsInvalidCardDigits() {
        assertThrows(IllegalArgumentException.class, () -> new CardPayment("12ab"));
    }
}
