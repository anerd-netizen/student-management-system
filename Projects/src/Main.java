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

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "Param", 89));
        students.add(new Student(2, "Riya", 92));
        students.add(new Student(3, "Aman", 76));
        students.add(new Student(4, "Prayag", 45));
        students.add(new Student(5, "Neha", 67));

        while (true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Delete Student\n4. Search Student\n5. Update Student\n6. Sort Students By Marks (Ascending)\n7. Display Students Above certain Marks\n8. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInt();

            if (choice == 1) {
                System.out.print("Enter student id: ");
                int id = getValidInt();
                System.out.print("Enter student name: ");
                String name = sc.next();
                System.out.print("Enter marks: ");
                int marks = getValidInt();

                boolean isDuplicate = false;
                for (Student s : students) {
                    if (s.id == id) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (isDuplicate) {
                    System.out.println("Id Already Exists: " + id);
                } else {
                    students.add(new Student(id, name, marks));
                    System.out.println("Student added successfully!");
                }

            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("List is Empty");
                } else {
                    System.out.println("--- Student List ---");
                    for (Student s : students) {
                        System.out.println("ID: " + s.id + " | Name: " + s.name + " | Marks: " + s.marks);
                    }
                    System.out.println("Total Count Of Students: " + students.size());
                }
            } else if (choice == 3) {
                System.out.print("Enter Id Of Student You Want To Delete: ");
                int id = getValidInt();
                boolean removed = students.removeIf(s -> s.id == id);
                if (removed) {
                    System.out.println("Student removed Successfully");
                } else {
                    System.out.println("No Such Student Found In The Record");
                }
            } else if (choice == 4) {
                search(students);
            } else if (choice == 5) {
                update(students);
            } else if (choice == 6) {
                sort(students);
            } else if (choice == 7) {
                displayCondition(students);
            } else if (choice == 8) {
                System.out.println("Thank you for using Student Management System\nExiting...");
                break;
            } else {
                System.out.println("Please choose from given options only");
            }
        }
    }

    private static int getValidInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a numeric value.");
            sc.next();
        }
        return sc.nextInt();
    }

    static void search(ArrayList<Student> students) {
        System.out.print("Enter the id of the student you want to search: ");
        int ids = getValidInt();
        boolean found = false;

        for (Student s : students) {
            if (s.id == ids) {
                System.out.println("Student found!");
                System.out.println("Name: " + s.name + ", Marks: " + s.marks);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No such student found. Add One First!");
    }

    static void displayCondition(ArrayList<Student> students) {
        System.out.print("Enter the threshold marks: ");
        int threshold = getValidInt();
        int count = 0;

        for (Student s : students) {
            if (s.marks > threshold) count++;
        }

        System.out.println("Students above " + threshold + " Marks: " + count);
        for (Student s : students) {
            if (s.marks > threshold) System.out.println(s);
        }
    }

    static void sort(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Nothing to sort.");
            return;
        }
        ArrayList<Student> ab = new ArrayList<>(students);
        ab.sort(Comparator.comparingInt(Student::getMarks));
        System.out.println("--- Student List (Sorted by Marks) ---");
        for (Student s : ab) {
            System.out.println("ID: " + s.id + " | Name: " + s.name + " | Marks: " + s.marks);
        }
    }

    static void update(ArrayList<Student> students) {
        System.out.print("Enter The id of The Student You Want to update: ");
        int id = getValidInt();
        boolean found = false;
        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new name: ");
                s.name = sc.next();
                System.out.print("Enter new marks: ");
                s.marks = getValidInt();
                System.out.println("Student Details Updated Successfully");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No Such Student Exists");
    }
}