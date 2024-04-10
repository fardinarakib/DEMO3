import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @org.junit.jupiter.api.Test
    void storeNewStudent() {
        String name = "Johnny";
        String email = "jwhudson@ucalgary.ca";
        assertEquals(0, Data.getAllStudents().size());
        boolean success = Data.storeNewStudent();
        assertEquals(1, Data.getAllStudents().size());
        assertEquals(name, Data.getAllStudents().get(0)[0]);
        assertEquals(email, Data.getAllStudents().get(0)[2]);
        assertTrue(success, "add was a success");
    }

    @org.junit.jupiter.api.Test
    void storeTwoStudents() {
        String name = "Johnny";
        String email = "jwhudson@ucalgary.ca";
        assertEquals(0, Data.getAllStudents().size());
        boolean success = Data.storeNewStudent(name);
        assertEquals(1, Data.getAllStudents().size());
        assertEquals(name, Data.getAllStudents().get(0)[0]);
        assertEquals(email, Data.getAllStudents().get(0)[2]);
        assertTrue(success);
        email = "johnnyj@ucalgary.ca";
        success = Data.storeNewStudent(name,name);
        assertTrue(success, "add was a success");
    }
    @org.junit.jupiter.api.Test
    void getAllStudents() {
    }

    @org.junit.jupiter.api.Test
    void getStudent() {
    }

    @org.junit.jupiter.api.Test
    void enterStudyYear() {
    }

    @org.junit.jupiter.api.Test
    void enterMajor() {
    }

    @org.junit.jupiter.api.Test
    void enterAge() {
    }

    @org.junit.jupiter.api.Test
    void enterPersonalDays() {
    }

    @org.junit.jupiter.api.Test
    void enterStudyHours() {
        // Test case 1: Successful entry of study hours
        int id1 = 1;
        String email1 = "test1@ucalgary.ca";
        double studyHours1 = 20.5;

        assertTrue(Data.storeNewStudent("Test Student 1", id1, email1));
        Data.enterStudyHours(id1, email1, studyHours1);

        // Retrieve the stored data and assert
        double storedStudyHours1 = (double) Data.storeNewStudent.get(id1).get("Hours");
        assertEquals(studyHours1, storedStudyHours1, 0.01);

        // Test case 2: Entry for existing student
        int id2 = 2;
        String email2 = "test2@ucalgary.ca";
        double studyHours2 = 15.0;

        assertTrue(Data.storeNewStudent("Test Student 2", id2, email2));

        // Enter some data for the student
        Data.enterStudyHours(id2, email2, 10.0);

        // Attempt to enter study hours for the same student
        Data.enterStudyHours(id2, email2, studyHours2);

        // Retrieve the stored data and assert it wasn't overwritten
        double storedStudyHours2 = (double) Data.storeNewStudent.get(id2).get("Hours");
        assertNotEquals(studyHours2, storedStudyHours2, 0.01);

}

    @org.junit.jupiter.api.Test
    void enterAssignmentsDone() {
        // Test case 1: Successful entry of assignments done
        int id1 = 1;
        String email1 = "test1@ucalgary.ca";
        int assignmentsDone1 = 5;

        assertTrue(Data.storeNewStudent("Test Student 1", id1, email1));
        Data.enterAssignmentsDone(id1, email1, assignmentsDone1);

        // Retrieve the stored data and assert
        int storedAssignmentsDone1 = (int) Data.storeNewStudent.get(id1).get("assignments completed");
        assertEquals(assignmentsDone1, storedAssignmentsDone1);
    }
}