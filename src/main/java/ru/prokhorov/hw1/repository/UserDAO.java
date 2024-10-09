package ru.prokhorov.hw1.repository;

import ru.prokhorov.hw1.entity.User;

import java.util.Optional;

/**
 * Репозиторий для совершения CRUD операций с сущностью {@link User}.
 *
 * @author Evgeniy_Prokhorov
 */
public interface UserDAO {

    /**
     * Сохранение пользователя в Базу данных
     *
     * @param user Пользователь
     */
    void createUser(User user);

    /**
     * Получение пользователя по идентификатору
     *
     * @param id идентификатор
     * @return Пользователь
     */
    Optional<User> findUserById(Long id);

    /**
     * Обновления данных по пользователю
     *
     * @param user Пользователь
     */
    void updateUser(User user);

    /**
     * Удаление пользователя по идентификатору
     *
     * @param id идентификатор
     */
    void deleteUserById(Long id);
}
