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
public sealed interface PaymentMethod permits CardPayment, BankTransfer {
}
