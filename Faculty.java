import java.util.*;

public class Faculty {
    String name, id, subject, password;

    public Faculty(String name, String id, String subject, String password) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.password = password;
    }

    public void display() {
        System.out.println("\n--- Faculty Details ---");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Subject: " + subject);
    }

    public void enterAttendanceAndMarks(ArrayList<Student> students, Scanner sc) {
        for (Student s : students) {
            if (s.subjects.contains(subject)) {
                System.out.println("\nStudent: " + s.name + " (" + s.regNo + ")");
                System.out.print("Is present? (true/false): ");
                boolean att = Boolean.parseBoolean(sc.nextLine());
                s.attendance.put(subject, att);
                System.out.print("Enter marks out of 100: ");
                int m = Integer.parseInt(sc.nextLine());
                s.marks.put(subject, m);
            }
        }
        UserDatabase.saveStudents(students);
        System.out.println("Updated marks and attendance saved.");
    }
}
