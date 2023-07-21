import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lesson_5_1 {
    private Map<String, List<String>> contacts;

    public lesson_5_1() {
        contacts = new HashMap<>();
    }

    public void addPhone(String name, String phone) {
        List<String> phones = contacts.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        contacts.put(name, phones);
    }

    public List<String> getPhones(String name) {
        return contacts.getOrDefault(name, new ArrayList<>());
    }

    public void removePhone(String name, String phone) {
        List<String> phones = contacts.getOrDefault(name, new ArrayList<>());
        phones.remove(phone);
        if (phones.isEmpty()) {
            contacts.remove(name);
        } else {
            contacts.put(name, phones);
        }
    }

    public void displayAllContacts() {
        for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
            String name = entry.getKey();
            List<String> phones = entry.getValue();
            System.out.println(name + ": " + phones);
        }
    }

    public static void main(String[] args) {
        lesson_5_1 phoneBook = new lesson_5_1();

        phoneBook.addPhone("John", "123-456-789");
        phoneBook.addPhone("John", "987-654-321");
        phoneBook.addPhone("Alice", "111-222-333");
        phoneBook.addPhone("Bob", "444-555-666");

        System.out.println("Телефоны контакта John: " + phoneBook.getPhones("John"));

        phoneBook.removePhone("John", "987-654-321");
        System.out.println("Телефоны контакта John после удаления: " + phoneBook.getPhones("John"));

        phoneBook.displayAllContacts();
    }
}