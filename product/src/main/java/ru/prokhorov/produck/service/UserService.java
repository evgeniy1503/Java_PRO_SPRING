package ru.prokhorov.produck.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.prokhorov.produck.entity.User;
import ru.prokhorov.produck.repository.UserDAO;

/**
 * Сервис по работе с {@link UserDAO}.
 *
 * @author Evgeniy_Prokhorov
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDAO userDAO;

    public void saveUser(User user) {
        userDAO.createUser(user);
    }

    public User getUserById(final Long id) {
        return userDAO.findUserById(id).orElseThrow(() -> new RuntimeException("Пользователь с id " + id + " не найден"));
    }


    public void updateUser(final User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(final Long id) {
        userDAO.deleteUserById(id);
    }


}
