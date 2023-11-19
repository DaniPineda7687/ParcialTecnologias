package infrastructure.Repositories.Employee;

import domain.Employee;
import infrastructure.Repositories.AbstractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CookRepository extends AbstractRepository<Employee> {
    public CookRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> Employees = new ArrayList<>();
        String query = "SELECT * FROM cook";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Employee cook = mapResultSet(resultSet);
                Employees.add(cook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Employees;
    }
    @Override
    public Employee getById(int id) {
        String query = "SELECT * FROM cook WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(Employee cook) {
        String query = "INSERT INTO cook (name, age) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cook.getName());
            preparedStatement.setDouble(2, cook.getAge());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Employee entity) {
        String query = "DELETE FROM cook WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, entity.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(int id, Employee cook) {
        String query = "UPDATE cook SET name = ?, age = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cook.getName());
            preparedStatement.setDouble(2, cook.getAge());
            preparedStatement.setInt(3, id);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private Employee mapResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");

        return new Employee(id, name, age);
    }
}
