import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> contacts = new HashMap<>();

    public void addContact(String name, String phoneNumber) {
        contacts.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    public void printPhoneBook() {
        // Создаем список записей для сортировки
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(contacts.entrySet());

        // Сортируем записи по убыванию количества телефонов
        sortedEntries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем контакты
        phoneBook.addContact("Иванов", "123456");
        phoneBook.addContact("Петров", "234567");
        phoneBook.addContact("Сидоров", "345678");
        phoneBook.addContact("Иванов", "456789");
        phoneBook.addContact("Петров", "567890");
        phoneBook.addContact("Иванов", "678901");

        // Выводим телефонную книгу
        phoneBook.printPhoneBook();
    }
}