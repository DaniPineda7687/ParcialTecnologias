package services;

import domain.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductOperations extends OperationsSets<Product>{
    public ProductOperations(Connection connection) {
        super(connection);
    }

    @Override
    protected Product mapResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        double price = resultSet.getDouble("price");

        return new Product(id, name, price);
    }
}
