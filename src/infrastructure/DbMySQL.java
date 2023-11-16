package infrastructure;

import java.sql.*;

public class DbMySQL extends DbConnection{
    private static DbConfiguration dbConfiguration;
    private static DbMySQL dbMySQL;
    private DbMySQL(DbConfiguration dbConfiguration) {
        this.dbConfiguration = dbConfiguration;
    }
    public static DbMySQL getDbMySQL(DbConfiguration dbConfiguration){
        if(dbMySQL == null){
            dbMySQL = new DbMySQL(dbConfiguration);
        }
        return dbMySQL;
    }
    @Override
    public Connection connect() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:"+dbConfiguration.getPort()+"/"+dbConfiguration.getDatabaseName(), dbConfiguration.getUsername(), dbConfiguration.getPassword());
            System.out.println("CONEXION A LA BD MYSQL EXITOSA...");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar a la base de datos");
        }
    }

    @Override
    public String getCurrentDate(Connection connection) {
        String query = "SELECT CURDATE()";
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
}
