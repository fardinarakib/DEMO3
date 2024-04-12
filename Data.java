package ca.ucalgary.syeda.rakib.demo3gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Data {
    // ArrayList to store student data as arrays
    private static final ArrayList<Object[]> students = new ArrayList<>();
    // HashSet to store unique emails for quick existence checks
    private static final HashSet<String> emails = new HashSet<>();
    // HashMap to store student data indexed by student ID
    private static final HashMap<Integer, Object[]> ids = new HashMap<>();
    // Constants to define indexes for student data
    public static final int INDEX_NAME = 0;
    public static final int INDEX_ID = 1;
    public static final int INDEX_EMAIL = 2;
    public static final int INDEX_WITHDRAWN = 3;

    // Method to store a new student's information
    public static boolean storeNewStudent(String name, int id, String email) {
        // Check if the student with the given ID or email already exists
        if (!checkExistStudent(id, email)) {
            // Create an array to store student information
            Object[] student = new Object[4];
            student[INDEX_NAME] = name;
            student[INDEX_ID] = id;
            student[INDEX_EMAIL] = email;
            student[INDEX_WITHDRAWN] = false;
            // Add the student to the ArrayList, HashMap, and HashSet
            students.add(student);
            ids.put(id, student);
            emails.add(email);
            return true; // Indicate success
        } else {
            return false; // Indicate failure (student already exists)
        }
    }

    // Check if a student with the given ID or email already exists
    static Map<Integer, Map<String, Object>> storeNewStudent = new HashMap<>();

    private static boolean checkExistStudent(int id, String email) {
        return ids.containsKey(id) || emails.contains(email);
    }

    // Get all students as an ArrayList
    public static ArrayList<Object[]> getAllStudents() {
        return students;
    }

    // Get a specific student by ID
    public static Object[] getStudent(int id) {
        return ids.get(id);
    }

    // Methods to enter additional information for a student
    // Note: Check if the student exists before entering data
    public static void enterStudyYear(int id, String email, int studyYear) {
        if (!checkExistStudent(id, email)) {
            NewStudent(id, email);
        }
        storeNewStudent.get(id).put("Year", studyYear);
    }

    public static void enterMajor(int id, String email, String major) {
        if (!checkExistStudent(id, email)) {
            NewStudent(id, email);
        }
        storeNewStudent.get(id).put("major", major);
    }

    public static void enterAge(int id, String email, int age) {
        if (!checkExistStudent(id, email)) {
            NewStudent(id, email);
        }
        storeNewStudent.get(id).put("age", age);
    }

    public static void enterPersonalDays(int id, String email, int personalDays) {
        if (!checkExistStudent(id, email)) {
            NewStudent(id, email);
        }
        storeNewStudent.get(id).put("personal days", personalDays);
    }

    public static void enterStudyHours(int id, String email, double studyHours) {
        if (!checkExistStudent(id, email)) {
            NewStudent(id, email);
        }
        storeNewStudent.get(id).put("Hours", studyHours);
    }

    public static void enterAssignmentsDone(int id, String email, int assignmentsDone) {
        if (!checkExistStudent(id, email)) {
            NewStudent(id, email);
        }
        storeNewStudent.get(id).put("assignments completed", assignmentsDone);
    }

    // Helper method to initialize a new student in the additional data store
    private static void NewStudent(int id, String email) {
        storeNewStudent.put(id, new HashMap<>());

    }

    public static boolean storeNewStudent(String name) {
        return false;
    }

    public static boolean storeNewStudent(String name, String name1) {
        return false;
    }

    public static boolean storeNewStudent() {
        return false;
    }

    public void addStudent(String name, String major, String year) {
    }

    public ArrayList<String> getAllStudentsAsStringList() {

        return null;
    }
}