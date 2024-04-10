import java.util.ArrayList;
import java.util.Scanner;



public class Menu<STUDENT_FORMAT, student> {

    //scanner for user input
    private static final Scanner scanner = new Scanner(System.in);

    // list to store menu options
    private static final ArrayList<String> options = new ArrayList<>();



    static {

        options.add("Exit");
        options.add("Enter a new student.");
        options.add("Enter current year of study.");
        options.add("Enter major.");
        options.add("Enter UCID.");
        options.add("Enter age.");
        options.add("Enter the amount of personal days used.");
        options.add("Enter the amount hours student studies in a week.");
        options.add("Enter the amount assignments student has done.");
        options.add("Print all student names.");
    }
    // initial message for menu options
    private static String optMessage = """
            Store and access students in this class.
            \tMenu Options
            """;

    static{
        //build menu message
        StringBuilder sb = new StringBuilder();
        sb.append(optMessage);
        for (int i = 0; i < options.size(); i++) {
            sb.append(String.format("\t%d. %s\n", i, options.get(i)));
        }
        optMessage = sb.toString();
    }

    private static final String STUDENT_FORMAT = "%-20s %-20s %-8s 5-9s%n";
    private static final String STUDENT_HEADER = String.format(STUDENT_FORMAT, "NAME", "UCID", "EMAIL");
    private static String STUDENT_SEP = "";
    static{
        for (int i = 0; i < STUDENT_HEADER.length(); i++) {
            STUDENT_SEP += "-";
        }
    }
    // Helper method to get a non-empty option from the user
    private static String getOption(){
        String option;
        do {
            option = scanner.nextLine().trim();
        }while (option.isEmpty());
        return option;
        }

    //menu loop for menu

    public static void menuLoop() {
        System.out.println(optMessage);
        String choice = getOption();
        int option = Integer.parseInt(choice);
        while (option != 0){
            if(option > 0 && option < options.size()) {
                System.out.printf("Selected option %d. %s%n", option, options.get(option));
                System.out.println("Press any Enter key to continue...");
                scanner.nextLine();
            }
            switch (option) {
                case 1 -> menuEnterNewStudent();
                case 2 -> menuEnterStudyYear();
                case 3 -> menuEnterMajor();
                case 4 -> menuEnterUCID();
                case 5 -> menuEnterAge();
                case 6 -> menuEnterPersonalDays();
                case 7 -> menuEnterStudyHours();
                case 8 -> menuEnterAssignmentsDone();
                case 9 -> menuPrintStudentInfo();
                case 10 -> menuPrintAllStudents();
                default -> System.out.printf("Option %d not recognized!%n", option);
            }
            System.out.println(optMessage);
            choice = getOption();
            option = Integer.parseInt(choice);
        }
        //getOption feature fetches user input
        System.out.printf("Thanks for using this program.%nBye!%n");
    }
    // Method to handle entering a new student

    private static void menuEnterNewStudent() {
        boolean success = false;
        do {
            System.out.println("Enter information about new student");
            String name = getName();
            int id = getId();
            String email = getEmail();
            success = Data.storeNewStudent(name, id, email);
            if (!success){
                System.out.println("student already exists as (id or email is already found);!\nTry again");
            }
        }while(!success);
        System.out.println("stored a new student!");
    }

    // Helper method to get a non-empty name from the user
    private static String getName() {
        String name;
        do{
            System.out.println("Enter a name:");
            name = scanner.nextLine().trim();
        }while(name.isEmpty());
        return name;
    }

    //Helper method to get a UCID of length 8 from the user
    private static int getId() {
        System.out.println("Enter a UCID:");
        String tempUCID;
        do{
            System.out.println("Enter UCID of length 8:");
            tempUCID = scanner.nextLine().trim();
        }while(tempUCID.length() != 8);
        return Integer.parseInt(tempUCID);
    }
    // method to get @ucalgary.ca email address form user
    private static String getEmail() {
        String name;
        do{
            System.out.println("Enter an @ucalgary.ca email address");
            name = scanner.nextLine().trim();
        }while(!name.endsWith("@ucalgary.ca"));
        return name;
    }

    private static void menuEnterStudyYear() {

        // Implementation for entering study year
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Study Year:");
        int studyYear = scanner.nextInt();
    }

    private static void menuEnterMajor() {
        // Implementation for entering major
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Major:");
        String major = scanner.next();
    }

    private static void menuEnterUCID() {
        // Implementation for entering UCID
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter UCID:");
        int ucid = scanner.nextInt();
    }
    private static void menuEnterAge() {
        // Implementation for entering age
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Age:");
        int age = scanner.nextInt();
    }

    private static void menuEnterPersonalDays() {
        // Implementation for entering personal days
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Personal Days:");
        int personalDays = scanner.nextInt();
    }

    private static void menuEnterStudyHours() {
        // Implementation for entering study hours
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Study Hours:");
        double studyHours = scanner.nextDouble();
    }

    private static void menuEnterAssignmentsDone() {
        // Implementation for entering assignments done
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Assignments Done:");
        int assignmentsDone = scanner.nextInt();
    }

    private static void menuPrintStudentInfo(){

            int id = getID();
            Object[] student = Data.getStudent(id);

            if(student != null){
                System.out.print(STUDENT_HEADER);
                System.out.println(STUDENT_SEP);
                String W = "";
                if ((Boolean) student[Data.INDEX_WITHDRAWN]) {
                    W = "W";
                }
                System.out.printf(STUDENT_FORMAT, student[Data.INDEX_NAME], student[Data.INDEX_ID], student[Data.INDEX_EMAIL], W);
            } else {
                System.out.printf("Student with id %s does not exist!\n", id);
            }
        }

    private static int getID() {
        int id;
        do {
            System.out.println("Enter Student ID:");
            try {
                id = Integer.parseInt(scanner.nextLine().trim());
                break;  // Exit the loop if the input is a valid integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer for Student ID.");
            }
        } while (true);

        return id;
    }
    private static void menuPrintAllStudents() {
        System.out.println(STUDENT_HEADER);
        System.out.println(STUDENT_SEP);
        String W = null;
        for (Object[] student : Data.getAllStudents()) {
            W = "W";
        }
        Object[] student = new Object[0];
        System.out.printf(STUDENT_FORMAT, student[Data.INDEX_NAME], student[Data.INDEX_ID], student[Data.INDEX_EMAIL], W);
    }
}
