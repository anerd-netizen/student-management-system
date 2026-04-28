import java.util.*;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Param", 89));
        students.add(new Student(2, "Riya", 92));
        students.add(new Student(3, "Aman", 76));

        while (true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Search Student\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter student id: ");
                int id = sc.nextInt();
                System.out.print("Enter student name: ");
                String name = sc.next();
                System.out.print("Enter marks: ");
                int marks = sc.nextInt();

                students.add(new Student(id, name, marks));

            } else if (choice == 2) {
                for (Student s : students) {
                    System.out.println("ID: " + s.id + " | Name: " + s.name + " | Marks: " + s.marks);
                }
            } else if (choice == 3) {
                search(students);
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }
        }
    }
    static void search(ArrayList<Student> students) {
        System.out.print("Enter the id of the student you want to search: ");
        int ids = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.id == ids) {
                System.out.println("Student found!");
                System.out.println("Name: " + s.name + ", Marks: " + s.marks);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No such student found.");
        }
    }
}