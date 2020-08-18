package level1.homeWork5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String name, String position, String email, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.printf("Информация по сотруднику:\n" +
            "ФИО: %s\nДолжность: %s\nEmail: %s, телефон: %s\nЗарплата: %.2f\nВозраст: %d\n", name, position, email, phone, salary, age);
    }
}
