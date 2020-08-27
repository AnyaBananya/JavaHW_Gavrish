package level2.homeWork3.phoneBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private HashMap<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneNumbers = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers);
    }

    public List<String> get(String name) {
        return phoneBook.get(name);
    }

    public void printAll() {
        phoneBook.forEach((k, v) -> print(k));
    }

    public void print(String name) {
        System.out.printf("%s:", name);
        for (String pn : phoneBook.get(name)) {
            System.out.printf(" %s", pn);
        }
        System.out.println();
    }
}
