package level2.homeWork3.phoneBook;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Гавриш", "8-888-777-88-55");
        phoneBook.add("Гавриш", "8-999-666-55-44");
        phoneBook.add("Петров", "1-222-333-44-55");
        phoneBook.add("Иванов", "9-888-777-66-55");

        phoneBook.print("Гавриш");
        System.out.println("-----------------");
        System.out.println(phoneBook.get("Гавриш"));
        System.out.println("-----------------");
        phoneBook.printAll();
    }
}
