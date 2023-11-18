package infrastructure.Repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractRepository<T> {
    protected Connection connection;

    public AbstractRepository(Connection connection){
        this.connection = connection;
    };

    public abstract List<T> getAll();
    public abstract T getById(int id);
    public abstract boolean create(T entity);
    public abstract boolean delete(T entity);
    public abstract boolean update(int id,T entity);
}
