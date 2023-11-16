package infrastructure;

import java.sql.Connection;

public abstract class DbConnection {


    public abstract Connection connect();
    public abstract String getCurrentDate(Connection connection);

}
