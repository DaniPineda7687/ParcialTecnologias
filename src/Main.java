import domain.Product;
import infrastructure.DbFactory;
import infrastructure.ReaderConfiguration;
import infrastructure.Repositories.AbstractRepository;
import infrastructure.Repositories.Product.PizzaRepository;
import services.JSONReader;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ReaderConfiguration readerConfiguration = new JSONReader();

        DbFactory factory = DbFactory.getDbInstance(readerConfiguration);
        try{
            Connection connection = factory.createDbConnection().connect();
            System.out.println(factory.createDbConnection().getCurrentDate(connection));
            System.out.println(factory.createDbConnection().getCurrentHour(connection));
            AbstractRepository<Product> PizzaDAO= new PizzaRepository(connection);
            System.out.println(PizzaDAO.getById(1));
            System.out.println(PizzaDAO.getAll());
            //Product pizza3 = new Product(0,"Vegana",12.99);
            //PizzaDAO.create(pizza3);
            //System.out.println(PizzaDAO.getAll());
            //PizzaDAO.delete(new Product(4,"",0));
            //PizzaDAO.update(1,new Product(0,"Margherita updated",9));
            System.out.println(PizzaDAO.getAll());
            connection.setAutoCommit(false);


        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

}