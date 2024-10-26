package ru.prokhorov.payment.exception;

/**
 * Исключение при работе с балансом продукта.
 *
 * @author Evgeniy_Prokhorov
 */
public class BalanceException extends RuntimeException {
    public BalanceException(String message) {
        super(message);
    }
}
