package binarySearch;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    public static void writeToFile(List<Student> students) {
        // write student in a file
        try {
            FileWriter writer = new FileWriter("students.txt");
            for (Student student : students) {
                writer.write(student.getName() + " " + student.getId() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
    }
}
}
