package ru.prokhorov.hw1.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.prokhorov.hw1.entity.User;
import ru.prokhorov.hw1.repository.UserDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void createUser(final User user) {
        final String query = "INSERT INTO users (username) VALUES (?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Возникла ошибка при сохранении User");
        }
    }

    @Override
    public Optional<User> findUserById(final Long id) {
        final String query = "SELECT * FROM users WHERE id = ?";
        Optional<User> result = Optional.empty();

        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = Optional.of(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Возникла ошибка при получении User");
        }
        return result;
    }

    @Override
    public void updateUser(final User user) {
        final String query = "UPDATE users SET username = ? WHERE id = ?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setLong(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Возникла ошибка при изменении User");
        }
    }

    @Override
    public void deleteUserById(final Long id) {
        final String query = "DELETE FROM users WHERE id = ?";

        try (Connection connection = dataSource.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Возникла ошибка при удалении User");
        }
    }
}
