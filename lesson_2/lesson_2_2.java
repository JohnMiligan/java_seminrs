
package lesson_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class lesson_2_2 {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 4};
        bubbleSort(array);
}

public static void bubbleSort(int[] array) {
    try {
        String logFilePath = "log.txt";
        FileWriter writer = new FileWriter(logFilePath);

        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            writer.write("Номер итерации " + (i + 1) + ": " + Arrays.toString(array) + "\n");
            writer.flush();

            if (!swapped) {
                break;
            }
        }

        writer.close();
        System.out.println("Log file created at: " + logFilePath);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
