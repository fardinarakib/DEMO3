package ca.ucalgary.syeda.rakib.demo3gui;

public class Student {
    // Attributes
    private String name;
    private int ucid;
    private String email;
    private int studyYear;
    private String major;
    private int age;
    private int personalDays;
    private int studyHours;
    private int assignmentsCompleted;

    // Constructor
    public Student(String name, int ucid, String email, int studyYear, String major, int age, int personalDays, int studyHours, int assignmentsCompleted) {
        this.name = name;
        this.ucid = ucid;
        this.email = email;
        this.studyYear = studyYear;
        this.major = major;
        this.age = age;
        this.personalDays = personalDays;
        this.studyHours = studyHours;
        this.assignmentsCompleted = assignmentsCompleted;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getId() { return ucid; }
    public void setUcid(int ucid) { this.ucid = ucid; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getStudyYear() { return studyYear; }
    public void setStudyYear(int studyYear) { this.studyYear = studyYear; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getPersonalDays() { return personalDays; }
    public void setPersonalDays(int personalDays) { this.personalDays = personalDays; }

    public int getStudyHours() { return studyHours; }
    public void setStudyHours(int studyHours) { this.studyHours = studyHours; }

    public int getAssignmentsCompleted() { return assignmentsCompleted; }
    public void setAssignmentsCompleted(int assignmentsCompleted) { this.assignmentsCompleted = assignmentsCompleted; }

    // Overridden toString method for data display
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ucid=" + ucid +
                ", email='" + email + '\'' +
                ", studyYear=" + studyYear +
                ", major='" + major + '\'' +
                ", age=" + age +
                ", personalDays=" + personalDays +
                ", studyHours=" + studyHours +
                ", assignmentsCompleted=" + assignmentsCompleted +
                '}';
    }
}
