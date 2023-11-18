import infrastructure.DbFactory;
import infrastructure.ReaderConfiguration;
import services.JSONReader;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ReaderConfiguration readerConfiguration = new JSONReader();

        DbFactory factory = DbFactory.getDbInstance(readerConfiguration);
        try{
            Connection connection = factory.createDbConnection().connect();
            System.out.println(factory.createDbConnection().getCurrentDate(connection));
            connection.setAutoCommit(false);


        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

}