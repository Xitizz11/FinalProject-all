import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static void saveArrayList(ArrayList<String> list, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : list) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static ArrayList<String> loadArrayList(String filename) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return list;
    }

    public static void saveArray(String[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : array) {
                if (item != null) {
                    writer.write(item);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving array: " + e.getMessage());
        }
    }

    public static String[] loadArray(String filename, int size) {
        String[] array = new String[size];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < size) {
                array[index++] = line;
            }
        } catch (IOException e) {
            System.out.println("Error loading array: " + e.getMessage());
        }
        return array;
    }
}
