package ru.prokhorov.hw1.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.prokhorov.hw1.entity.User;
import ru.prokhorov.hw1.repository.UserDAO;

import javax.sql.DataSource;
import java.util.Optional;

/**
 * Реализация {@link UserDAO}.
 *
 * @author Evgeniy_Prokhorov
 */
@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final DataSource dataSource;

    @Override
    public void createUser(User user) {

    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(Long id) {

    }
}
