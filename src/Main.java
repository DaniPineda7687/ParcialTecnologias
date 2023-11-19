import domain.Employee;
import domain.Product;
import infrastructure.DbFactory;
import infrastructure.ReaderConfiguration;
import infrastructure.Repositories.AbstractRepository;
import infrastructure.Repositories.Employee.CookRepository;
import infrastructure.Repositories.Employee.WaiterRepository;
import infrastructure.Repositories.Product.PizzaRepository;
import services.EmployeeOperations;
import services.JSONReader;
import services.ProductOperations;
import services.TableOperations;

import java.sql.Connection;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        ReaderConfiguration readerConfiguration = new JSONReader();

        DbFactory factory = DbFactory.getDbInstance(readerConfiguration);
        try{
            Connection connection = factory.createDbConnection().connect();
            System.out.println(factory.createDbConnection().getCurrentDate(connection));
            System.out.println(factory.createDbConnection().getCurrentHour(connection));
            AbstractRepository<Product> PizzaDAO= new PizzaRepository(connection);
            AbstractRepository<Employee> waiterDAO= new WaiterRepository(connection);
            AbstractRepository<Employee> cookDAO = new CookRepository(connection);
            System.out.println(PizzaDAO.getById(1));
            System.out.println(PizzaDAO.getAll());
            Product pizza3 = new Product("Vegana",12.99);
            //PizzaDAO.create(pizza3);
            //System.out.println(PizzaDAO.getAll());
            //PizzaDAO.delete(new Product("",0));
            //PizzaDAO.update(1,new Product(0,"Margherita updated",9));
            System.out.println(PizzaDAO.getAll());
            System.out.println(waiterDAO.getAll());
            System.out.println(waiterDAO.getById(1));
            //waiterDAO.create(new Employee("Ruben Urrego",21));
            //cookDAO.create(new Employee("Ruben Urrego",21));
            System.out.println(waiterDAO.getAll());
            TableOperations<Product> operations = new ProductOperations(connection);
            TableOperations<Employee> employeedOperations = new EmployeeOperations(connection);
            System.out.println(operations.getUnion("pizza","beverage"));
            System.out.println(employeedOperations.getUnion("waiter","cook"));
            System.out.println(employeedOperations.getDifference("waiter","cook"));
            System.out.println(employeedOperations.getDifference("cook","waiter"));
            connection.setAutoCommit(false);


        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

}