package services;

import domain.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeOperations extends OperationsSets<Employee> {

    public EmployeeOperations(Connection connection) {
        super(connection);
    }
    @Override
    protected Employee mapResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        return new Employee(id, name, age);
    }
}
