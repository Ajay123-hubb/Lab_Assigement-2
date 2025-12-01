import java.util.*;

abstract class Person {
    protected String name;
    protected String email;

    Person() {}

    Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public abstract void displayInfo();
}

class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private char grade;

    Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        assignGrade();
    }

    void assignGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 80) grade = 'B';
        else if (marks >= 65) grade = 'C';
        else grade = 'D';
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Info:");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("------------------------");
    }

    public void displayInfo(boolean mini) {
        if (mini) {
            System.out.println(rollNo + " | " + name + " | " + course);
        } else {
            displayInfo();
        }
    }

    public int getRollNo() {
        return rollNo;
    }
}

interface RecordActions {
    void addStudent(Student s);
    void deleteStudent(int rollNo);
    void updateStudent(int rollNo, double newMarks);
    Student searchStudent(int rollNo);
    void viewAllStudents();
}

class StudentManager implements RecordActions {

    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student s) {
        for (Student st : students) {
            if (st.getRollNo() == s.getRollNo()) {
                System.out.println("Duplicate Roll Number.");
                return;
            }
        }
        students.add(s);
        System.out.println("Student Added.");
    }

    @Override
    public void deleteStudent(int rollNo) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getRollNo() == rollNo) {
                it.remove();
                System.out.println("Student Deleted.");
                return;
            }
        }
        System.out.println("Record Not Found.");
    }

    @Override
    public void updateStudent(int rollNo, double newMarks) {
        for (Student st : students) {
            if (st.getRollNo() == rollNo) {
                Student updated = new Student(rollNo, st.name, st.email, "Updated", newMarks);
                students.remove(st);
                students.add(updated);
                System.out.println("Record Updated.");
                return;
            }
        }
        System.out.println("Record Not Found.");
    }

    @Override
    public Student searchStudent(int rollNo) {
        for (Student st : students) {
            if (st.getRollNo() == rollNo) return st;
        }
        return null;
    }

    @Override
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No Records Found.");
            return;
        }
        for (Student s : students) {
            s.displayInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();
        int choice;

        while (true) {
            System.out.println("===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student Marks");
            System.out.println("4. Search Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Enter Option: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Roll No: ");
                int r = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String n = sc.nextLine();
                System.out.print("Email: ");
                String e = sc.nextLine();
                System.out.print("Course: ");
                String c = sc.nextLine();
                System.out.print("Marks: ");
                double m = sc.nextDouble();
                sm.addStudent(new Student(r, n, e, c, m));
            }
            else if (choice == 2) {
                System.out.print("Enter Roll No: ");
                sm.deleteStudent(sc.nextInt());
            }
            else if (choice == 3) {
                System.out.print("Enter Roll No: ");
                int r = sc.nextInt();
                System.out.print("New Marks: ");
                double m = sc.nextDouble();
                sm.updateStudent(r, m);
            }
            else if (choice == 4) {
                System.out.print("Enter Roll No: ");
                Student s = sm.searchStudent(sc.nextInt());
                if (s == null) System.out.println("Not Found.");
                else s.displayInfo(true);
            }
            else if (choice == 5) {
                sm.viewAllStudents();
            }
            else if (choice == 6) {
                System.out.println("Goodbye!");
                break;
            }
            else {
                System.out.println("Invalid Option.");
            }
        }
        sc.close();
    }
}
