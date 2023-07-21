import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.Collections;

public class lesson_5_2 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Светлана Петрова");
        employees.add("Кристина Белова");
        employees.add("Анна Мусина");
        employees.add("Анна Крутова");
        employees.add("Иван Юрин");
        employees.add("Петр Лыков");
        employees.add("Павел Чернов");
        employees.add("Петр Чернышов");
        employees.add("Мария Федорова");
        employees.add("Марина Светлова");
        employees.add("Иван Савин");
        employees.add("Мария Рыкова");
        employees.add("Марина Лугова");
        employees.add("Анна Владимирова");
        employees.add("Иван Мечников");
        employees.add("Петр Петин");
        employees.add("Иван Ежов");

        Map<String, Integer> nameCountMap = new HashMap<>();

        for (String employee : employees) {
            String[] nameParts = employee.split(" ");
            String name = nameParts[0]; // Берем только имя, отбрасываем фамилию
            nameCountMap.put(name, nameCountMap.getOrDefault(name, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(nameCountMap.entrySet());
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
