import java.util.HashMap;

public class Utils {
    public static double calculateCGPA(HashMap<String, Integer> marks) {
        int total = 0;
        for (int m : marks.values()) total += m;
        return (marks.size() == 0) ? 0.0 : total / (10.0 * marks.size());
    }

    public static String calculateGrade(double cgpa) {
        if (cgpa >= 8.5) return "A";
        else if (cgpa >= 7.0) return "B";
        else return "C";
    }
}
