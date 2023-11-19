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

            AbstractRepository<Product> pizzaRepository= new PizzaRepository(connection);
            AbstractRepository<Employee> waiterRepository= new WaiterRepository(connection);
            AbstractRepository<Employee> cookRepository = new CookRepository(connection);

            System.out.println(pizzaRepository.getById(1));
            System.out.println(pizzaRepository.getAll());
            Product pizza3 = new Product("Vegana",12.99);

            //pizzaRepository.create(pizza3);
            //System.out.println(pizzaRepository.getAll());
            //pizzaRepository.delete(new Product("",0));
            //pizzaRepository.update(1,new Product(0,"Margherita updated",9));
            System.out.println(pizzaRepository.getAll());
            System.out.println(waiterRepository.getAll());
            System.out.println(waiterRepository.getById(1));
            //waiterRepository.create(new Employee("Ruben Urrego",21));
            //cookRepository.create(new Employee("Ruben Urrego",21));
            System.out.println(waiterRepository.getAll());
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