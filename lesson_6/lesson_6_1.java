package lesson_6;

import java.util.*;

public class lesson_6_1 {
    private String model;
    private int ram;
    private int hddCapacity;
    private String operatingSystem;
    private String color;

    public lesson_6_1(String model, int ram, int hddCapacity, String operatingSystem, String color) {
        this.model = model;
        this.ram = ram;
        this.hddCapacity = hddCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getHddCapacity() {
        return hddCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void displayInfo() {
        System.out.println("Модель: " + model);
        System.out.println("ОЗУ: " + ram + " ГБ");
        System.out.println("Объем жесткого диска: " + hddCapacity + " ГБ");
        System.out.println("Операционная система: " + operatingSystem);
        System.out.println("Цвет: " + color);
        System.out.println();
    }

    public static void main(String[] args) {
        // Создаем множество ноутбуков
        Set<lesson_6_1> notebooks = createNotebooksSet();

        // Запрашиваем минимальные значения ОЗУ и ЖД
        Map<String, Integer> filterValues = getFilterValues();

        // Фильтруем и выводим ноутбуки, удовлетворяющие фильтру
        Set<lesson_6_1> matchingNotebooks = filterNotebooks(notebooks, filterValues);

        // Выводим параметры цвета и ОС
        displayColorAndOS(matchingNotebooks);
    }

    private static Set<lesson_6_1> createNotebooksSet() {
        // Создаем множество ноутбуков и добавляем в него несколько примеров
        Set<lesson_6_1> notebooks = new HashSet<lesson_6_1>();
        notebooks.add(new lesson_6_1("Dell Inspiron", 8, 500, "Windows 10", "черный"));
        notebooks.add(new lesson_6_1("Lenovo ThinkPad", 16, 1000, "Windows 10", "серый"));
        notebooks.add(new lesson_6_1("HP Pavilion", 12, 750, "Windows 10", "серебристый"));
        notebooks.add(new lesson_6_1("Asus ZenBook", 16, 512, "Windows 10", "синий"));
        notebooks.add(new lesson_6_1("Apple MacBook Air", 8, 256, "macOS", "золотой"));
        return notebooks;
    }

    private static Map<String, Integer> getFilterValues() {
        Map<String, Integer> filterValues = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите минимальное значение ОЗУ (в ГБ): ");
            int ram = scanner.nextInt();
            System.out.print("Введите минимальный объем жесткого диска (в ГБ): ");
            int hddCapacity = scanner.nextInt();
            filterValues.put("ОЗУ", ram);
            filterValues.put("Объем ЖД", hddCapacity);
        }
        return filterValues;
    }

    private static Set<lesson_6_1> filterNotebooks(Set<lesson_6_1> notebooks, Map<String, Integer> filterValues) {
        Set<lesson_6_1> matchingNotebooks = new HashSet<>();

        for (lesson_6_1 notebook : notebooks) {
            if (notebook.getRam() >= filterValues.get("ОЗУ") && notebook.getHddCapacity() >= filterValues.get("Объем ЖД")) {
                matchingNotebooks.add(notebook);
            }
        }

        if (matchingNotebooks.isEmpty()) {
            System.out.println("Нет подходящих ноутбуков.");
        } else {
            System.out.println("Подходящие ноутбуки:");
            for (lesson_6_1 notebook : matchingNotebooks) {
                System.out.println(notebook.getModel() + " (" + notebook.getRam() + " ГБ ОЗУ, " + notebook.getHddCapacity() + " ГБ ЖД)");
            }
        }
        return matchingNotebooks;
    }

    private static void displayColorAndOS(Set<lesson_6_1> notebooks) {
        System.out.println("\nДополнительные параметры:");

        Set<String> colors = new HashSet<>();
        Set<String> operatingSystems = new HashSet<>();

        for (lesson_6_1 notebook : notebooks) {
            colors.add(notebook.getColor());
            operatingSystems.add(notebook.getOperatingSystem());
        }

        System.out.println("Цвета: " + colors);
        System.out.println("Операционные системы: " + operatingSystems);
    }
}

