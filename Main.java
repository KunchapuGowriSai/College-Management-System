import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Faculty> faculties = new ArrayList<>();
        Admin admin = new Admin();

        UserDatabase.loadData(students, faculties);

        while (true) {
            System.out.println("\n--- College Management System ---");
            System.out.println("1. Student Login");
            System.out.println("2. Faculty Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Guest");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Reg No: ");
                    String reg = sc.nextLine();
                    Student stu = students.stream().filter(s -> s.regNo.equals(reg)).findFirst().orElse(null);
                    if (stu != null) stu.displayDetails();
                    else System.out.println("Student not found.");
                    break;

                case "2":
                    System.out.print("Enter Faculty ID: ");
                    String fid = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String fpass = sc.nextLine();
                    Faculty fac = faculties.stream().filter(f -> f.id.equals(fid) && f.password.equals(fpass)).findFirst().orElse(null);
                    if (fac != null) {
                        fac.display();
                        fac.enterAttendanceAndMarks(students, sc);
                    } else {
                        System.out.println("Invalid Faculty ID or password.");
                    }
                    break;

                case "3":
                    if (admin.login(sc)) {
                        while (true) {
                            System.out.println("\nAdmin Menu:");
                            System.out.println("1. Add Student");
                            System.out.println("2. Add Faculty");
                            System.out.println("3. View Students");
                            System.out.println("4. View Faculties");
                            System.out.println("5. View Counts");
                            System.out.println("6. Logout");
                            System.out.print("Choice Option: ");
                            String opt = sc.nextLine();
                            if (opt.equals("6")) break;
                            switch (opt) {
                                case "1": admin.addStudent(students, sc); break;
                                case "2": admin.addFaculty(faculties, sc); break;
                                case "3": admin.viewStudents(students); break;
                                case "4": admin.viewFaculties(faculties); break;
                                case "5": admin.viewCounts(students, faculties); break;
                            }
                        }
                    } else {
                        System.out.println("Admin login failed.");
                    }
                    break;

                case "4":
                    System.out.println("👁️ Guest View:");
                    System.out.println("Students: " + students.size());
                    System.out.println("Faculties: " + faculties.size());
                    break;

                case "5":
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
