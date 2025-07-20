import java.io.*;
import java.util.*;

public class UserDatabase {
    private static final String STUDENT_FILE = "students.txt";
    private static final String FACULTY_FILE = "faculties.txt";

    public static void loadData(ArrayList<Student> students, ArrayList<Faculty> faculties) {
        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                ArrayList<String> subs = new ArrayList<>(Arrays.asList(parts[5].split(",")));
                Student s = new Student(parts[0], parts[1], parts[2], parts[3], parts[4], subs);
                students.add(s);
            }
        } catch (IOException e) { }

        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                faculties.add(new Faculty(parts[0], parts[1], parts[2], parts[3]));
            }
        } catch (IOException e) { }
    }

    public static void saveStudents(ArrayList<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(STUDENT_FILE))) {
            for (Student s : students) {
                pw.println(s.name + "|" + s.regNo + "|" + s.department + "|" + s.address + "|" + s.fatherName + "|" + String.join(",", s.subjects));
            }
        } catch (IOException e) { }
    }

    public static void saveFaculties(ArrayList<Faculty> faculties) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FACULTY_FILE))) {
            for (Faculty f : faculties) {
                pw.println(f.name + "|" + f.id + "|" + f.subject + "|" + f.password);
            }
        } catch (IOException e) { }
    }
}
