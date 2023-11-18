package infrastructure.Repositories.Employee;

import domain.Employee;
import infrastructure.Repositories.AbstractRepository;

import java.sql.Connection;
import java.util.List;

public class CookRepository extends AbstractRepository<Employee> {
    public CookRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public boolean create(Employee entity) {
        return false;
    }

    @Override
    public boolean delete(Employee entity) {
        return false;
    }

    @Override
    public boolean update(int id, Employee entity) {
        return false;
    }
}
