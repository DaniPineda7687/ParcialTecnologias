package services;

import domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class OperationsSets<T> implements TableOperations<T>{
    private final Connection connection;

    public OperationsSets(Connection connection){
        this.connection=connection;
    }
    @Override
    public List<T> getUnion(String firstTable,String secondTable) {
        String query = "SELECT * FROM "+ firstTable +" UNION SELECT * FROM "+ secondTable;
        return executeQuery(query);
    }
    @Override
    public List<T> getDifference(String firstTable, String secondTable) {
        String query = "SELECT * FROM " + firstTable + " EXCEPT SELECT * FROM " + secondTable;
        return executeQuery(query);
    }
    private List<T> executeQuery(String query) {
        List<T> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                T entity = mapResultSet(resultSet);
                result.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    protected abstract T mapResultSet(ResultSet resultSet) throws SQLException;
}
