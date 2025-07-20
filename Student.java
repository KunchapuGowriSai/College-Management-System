import java.util.*;

public class Student {
    String name, regNo, department, address, fatherName;
    ArrayList<String> subjects = new ArrayList<>();
    HashMap<String, Boolean> attendance = new HashMap<>();
    HashMap<String, Integer> marks = new HashMap<>();

    public Student(String name, String regNo, String department, String address, String fatherName, ArrayList<String> subjects) {
        this.name = name;
        this.regNo = regNo;
        this.department = department;
        this.address = address;
        this.fatherName = fatherName;
        this.subjects = subjects;
        for (String sub : subjects) {
            attendance.put(sub, false);
            marks.put(sub, 0);
        }
    }

    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("Registration No: " + regNo);
        System.out.println("Department: " + department);
        System.out.println("Address: " + address);
        System.out.println("Father’s Name: " + fatherName);
        System.out.println("Subjects: " + subjects);
        System.out.println("Attendance:");
        for (String sub : subjects)
            System.out.println(sub + ": " + (attendance.get(sub) ? "Present" : "Absent"));
        System.out.println("Marks:");
        for (String sub : subjects)
            System.out.println(sub + ": " + marks.get(sub));
        double cgpa = Utils.calculateCGPA(marks);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Grade: " + Utils.calculateGrade(cgpa));
    }
}
