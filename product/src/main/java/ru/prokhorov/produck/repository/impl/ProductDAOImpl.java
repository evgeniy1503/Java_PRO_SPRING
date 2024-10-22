package ru.prokhorov.produck.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.prokhorov.produck.entity.Product;
import ru.prokhorov.produck.entity.dto.ProductUpdateDto;
import ru.prokhorov.produck.entity.enums.ProductType;
import ru.prokhorov.produck.repository.ProductDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Реализация {@link ProductDAO}.
 *
 * @author Evgeniy_Prokhorov
 */

@Repository
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO {

    private final DataSource dataSource;
    @Override
    public void createProduct(final Product product) {
        final String createQuery = "INSERT INTO products(user_id, amount, account_number, product_type) VALUES(?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(createQuery);
            statement.setLong(1, product.getUserId());
            statement.setBigDecimal(2, product.getAmount());
            statement.setString(3, product.getAccountNumber());
            statement.setString(4, product.getProductType().name());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        Optional<Product> result = Optional.empty();
        final String query = "SELECT * FROM products WHERE id = ?";
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = Optional.of(new Product(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getString("account_number"),
                        resultSet.getBigDecimal("amount"),
                        ProductType.valueOf(resultSet.getString("product_type"))
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    @Override
    public List<Product> findProductByUserId(Long userId) {
        List<Product> result = new ArrayList<>();
        final String query = "SELECT * FROM products WHERE user_id = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getString("account_number"),
                        resultSet.getBigDecimal("amount"),
                        ProductType.valueOf(resultSet.getString("product_type"))
                );
                result.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void updateProductById(Long id, ProductUpdateDto dto) {
        final String query = "UPDATE products SET amount = ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, dto.getAmount());
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Возникла ошибка при изменении User");
        }
    }
}
