package ca.ucalgary.syeda.rakib.demo3gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Data {


    public static final int INDEX_WITHDRAWN = 8;
    private static final ArrayList<Object[]> students = new ArrayList<>();
    private static final HashSet<String> emails = new HashSet<>();
    private static final HashMap<Integer, Object[]> ids = new HashMap<>();
    public static final int INDEX_NAME = 0;
    public static final int INDEX_ID = 1;
    public static final int INDEX_EMAIL = 2;
    public static final int INDEX_AGE = 3;
    public static final int INDEX_PERSONAL_DAYS = 4;
    public static final int INDEX_STUDY_HOURS = 5;
    public static final int INDEX_MAJOR = 6;
    public static final int INDEX_YEAR = 7;

    public static boolean storeNewStudent(String name, int id, String email) {
        if (!emails.contains(email) && !ids.containsKey(id)) {
            Object[] student = new Object[8];  // Expanded to fit more indices
            student[INDEX_NAME] = name;
            student[INDEX_ID] = id;
            student[INDEX_EMAIL] = email;
            students.add(student);
            ids.put(id, student);
            emails.add(email);
            return true;
        }
        return false;
    }

    private static boolean checkExistStudent(int id, String email) {
        return ids.containsKey(id) || emails.contains(email);
    }

    public static ArrayList<Object[]> getAllStudents() {
        return students;
    }

    public static Object[] getStudent(int id) {
        return ids.get(id);
    }

    public static void enterStudyYear(int id, String email, int studyYear) {
        Object[] student = getStudent(id);
        if (student != null) student[INDEX_YEAR] = studyYear;
    }

    public static void enterMajor(int id, String email, String major) {
        Object[] student = getStudent(id);
        if (student != null) student[INDEX_MAJOR] = major;
    }

    public static void enterAge(int id, int age) {
        Object[] student = getStudent(id);
        if (student != null) student[INDEX_AGE] = age;
    }

    public static void enterPersonalDays(int id, String email, int personalDays) {
        Object[] student = getStudent(id);
        if (student != null) student[INDEX_PERSONAL_DAYS] = personalDays;
    }

    public static void enterStudyHours(int id, String email, double studyHours) {
        Object[] student = getStudent(id);
        if (student != null) student[INDEX_STUDY_HOURS] = studyHours;
    }

    public static double calculateAverageAge() {
        if (students.isEmpty()) return 0.0;
        double totalAge = 0;
        for (Object[] student : students) {
            totalAge += (int) student[INDEX_AGE];
        }
        return totalAge / students.size();
    }

    public static List<String> predictNextYearStudyHours() {
        List<String> predictions = new ArrayList<>();
        for (Object[] student : students) {
            double nextYearHours = (double) student[INDEX_STUDY_HOURS] * 1.1;
            predictions.add(student[INDEX_NAME] + " next year's study hours: " + nextYearHours);
        }
        return predictions;
    }

    public static List<String> printSortedStudents() {
        students.sort(Comparator.comparing(o -> (String) o[INDEX_MAJOR]));
        List<String> sortedStudents = new ArrayList<>();
        for (Object[] student : students) {
            sortedStudents.add("Name: " + student[INDEX_NAME] + ", Major: " + student[INDEX_MAJOR]);
        }
        return sortedStudents;
    }

    public static List<String> getStudentsNeedingAttention() {
        List<String> needingAttention = new ArrayList<>();
        for (Object[] student : students) {
            int personalDays = (int) student[INDEX_PERSONAL_DAYS];
            double studyHours = (double) student[INDEX_STUDY_HOURS];
            if (personalDays > 10 || studyHours < 5) {
                needingAttention.add(student[INDEX_NAME] + " needs attention");
            }
        }
        return needingAttention;
    }

    public static void saveToCSV(String absolutePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(absolutePath))) {
            bw.write("Name,ID,Email,Age,PersonalDays,StudyHours,Major,Year,Withdrawn\n");
            for (Object[] student : students) {
                bw.write(String.format("%s,%d,%s,%d,%d,%.2f,%s,%d,%b\n",
                        student[INDEX_NAME],
                        student[INDEX_ID],
                        student[INDEX_EMAIL],
                        student[INDEX_AGE],
                        student[INDEX_PERSONAL_DAYS],
                        student[INDEX_STUDY_HOURS],
                        student[INDEX_MAJOR],
                        student[INDEX_YEAR],
                        student[INDEX_WITHDRAWN]
                ));
            }
        }
    }


    public static void loadFromCSV(String absolutePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(absolutePath));
        if (!lines.isEmpty()) {
            lines.remove(0);  // Assuming the first line is the header
            for (String line : lines) {
                String[] data = line.split(",");
                if (data.length >= 9) {  // Check for the correct number of fields
                    String name = data[0];
                    int id = Integer.parseInt(data[1]);
                    String email = data[2];
                    int age = Integer.parseInt(data[3]);
                    int personalDays = Integer.parseInt(data[4]);
                    double studyHours = Double.parseDouble(data[5]);
                    String major = data[6];
                    int year = Integer.parseInt(data[7]);
                    boolean withdrawn = Boolean.parseBoolean(data[8]);

                    Object[] student = {name, id, email, age, personalDays, studyHours, major, year, withdrawn};
                    students.add(student);
                    ids.put(id, student);
                    emails.add(email);
                }
            }
        }
    }

    public static String[] getAllStudentsAsCSV() {
        return new String[0];
    }

    public static void addStudentFromCSV(String line) {
    }
}
//minor editing tips from youtube
//chatgpt fix for minor errors
//reddit for some concepts