package homeWork5;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Воздушный Марк Георгиевич", "Главный бухгалтер", "VozdushniyMG@mail.ru", "8-979-222-33-88", 40500.56, 46);
//        employee1.printInfo();

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Орлова Клара Петровна", "Бухгалтер", "OrlovaKP@mail.ru", "8-555-444-33-22", 21000, 26);
        employees[1] = new Employee("Иванова Надежда Владимировна", "Бухгалтер", "IvanovaNV@mail.ru", "8-111-222-44-55", 20000, 25);
        employees[2] = new Employee("Меньшиков Дмитрий Сергеевич", "Старший бухгалтер", "MenshikovDS@mail.ru", "8-666-555-44-33", 50000, 46);
        employees[3] = new Employee("Самсонов Яков Васильевич", "Старший бухгалтер", "Samsonov@mail.ru", "8-123-456-78-90", 51000, 40);
        employees[4] = new Employee("Глаголева Нора Петровна", "Старший бухгалтер", "GlagolevaNP@mail.ru", "8-495-222-33-44", 52500.56, 41);

        System.out.println("Список сотрудников старше 40 лет\n");
        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
                System.out.println("-----------------------");
            }
        }
    }
}
