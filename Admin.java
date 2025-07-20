import java.util.*;

public class Admin {
    private static final String ADMIN_ID = "admin";
    private static final String ADMIN_PASS = "admin123";

    public boolean login(Scanner sc) {
        System.out.print("Enter Admin ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Admin Password: ");
        String pass = sc.nextLine();
        return id.equals(ADMIN_ID) && pass.equals(ADMIN_PASS);
    }

    public void addStudent(ArrayList<Student> students, Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Reg No: ");
        String regNo = sc.nextLine();
        System.out.print("Department: ");
        String dept = sc.nextLine();
        System.out.print("Address: ");
        String addr = sc.nextLine();
        System.out.print("Father's Name: ");
        String father = sc.nextLine();
        System.out.print("Number of subjects: ");
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> subs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            subs.add(sc.nextLine());
        }
        students.add(new Student(name, regNo, dept, addr, father, subs));
        UserDatabase.saveStudents(students);
        System.out.println("Student added!");
    }

    public void addFaculty(ArrayList<Faculty> faculties, Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Subject: ");
        String sub = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        faculties.add(new Faculty(name, id, sub, pass));
        UserDatabase.saveFaculties(faculties);
        System.out.println("Faculty added!");
    }

    public void viewStudents(ArrayList<Student> students) {
        for (Student s : students) s.displayDetails();
    }

    public void viewFaculties(ArrayList<Faculty> faculties) {
        for (Faculty f : faculties) f.display();
    }

    public void viewCounts(ArrayList<Student> students, ArrayList<Faculty> faculties) {
        System.out.println("Total Students: " + students.size());
        System.out.println("Total Faculties: " + faculties.size());
    }
}
