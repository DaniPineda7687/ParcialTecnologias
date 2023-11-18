package infrastructure;

import java.sql.*;

public class DbPostgreSQL extends DbConnection{
    private static DbConfiguration dbConfiguration;
    private static DbPostgreSQL dbPostgreSQL;
    private DbPostgreSQL(DbConfiguration dbConfiguration) {
        this.dbConfiguration = dbConfiguration;
    }

    public static DbPostgreSQL getDbPostgreSQL(DbConfiguration dbConfiguration){
        if(dbPostgreSQL == null){
            dbPostgreSQL = new DbPostgreSQL(dbConfiguration);
        }
        return dbPostgreSQL;
    }



    @Override
    public Connection connect() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:"+dbConfiguration.getPort()+"/"+dbConfiguration.getDatabaseName(), dbConfiguration.getUsername(), dbConfiguration.getPassword());
            System.out.println("CONEXION A LA BD POSTGRESQL EXITOSA...");
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error al conectar a la base de datos");
        }
    }

    @Override
    public String getCurrentDate(Connection connection) {
        String query = "SELECT CURRENT_DATE";
        String date = "";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                date = resultSet.getDate(1).toString();
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return date;
    }

    @Override
    public String getCurrentHour(Connection connection) {
        String query = "SELECT CURRENT_TIME AT TIME ZONE 'America/Bogota'";
        String hour = "";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                hour = resultSet.getTime(1).toString();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return hour;
    }
}
