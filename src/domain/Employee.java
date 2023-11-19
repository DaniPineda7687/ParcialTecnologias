package domain;

public class Employee {
    private int id=0;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        this.id=id;
        this.age=age;
        this.name=name;
    }
    public Employee(String name,int age){
        this.age=age;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
