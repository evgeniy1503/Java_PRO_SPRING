package ru.prokhorov.payment.exception;

/**
 * Исключение при работе с сущностями.
 *
 * @author Evgeniy_Prokhorov
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
