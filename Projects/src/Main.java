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

    public String getName() {
        return name;
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
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Update Student");
            System.out.println("6. Sort By Marks (Ascending)");
            System.out.println("7. Sort By Marks (Descending)");
            System.out.println("8. Sort By Name");
            System.out.println("9. Display Marks Above Threshold Marks");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInt();

            switch (choice) {
                case 1 -> addStudent(students);
                case 2 -> viewStudents(students);
                case 3 -> deleteStudent(students);
                case 4 -> search(students);
                case 5 -> update(students);
                case 6 -> sortByMarksAscending(students);
                case 7 -> sortByMarksDescending(students);
                case 8 -> sortByName(students);
                case 9 -> displayCondition(students);
                case 10 -> {
                    System.out.println("Thank you for using Student Management System\nExiting...");
                    return;
                }
                default -> System.out.println("Please choose from given options only");
            }
        }
    }

    private static int getValidInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a numeric value.");
            sc.next();
        }
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    static void addStudent(ArrayList<Student> students) {
        System.out.print("Enter student id: ");
        int id = getValidInt();

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
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks: ");
            int marks = getValidInt();
            students.add(new Student(id, name, marks));
            System.out.println("Student added successfully!");
        }
    }

    static void viewStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("List is Empty");
        } else {
            System.out.println("--- Student List ---");
            for (Student s : students) {
                System.out.println("ID: " + s.id + " | Name: " + s.name + " | Marks: " + s.marks);
            }
            System.out.println("Total Count Of Students: " + students.size());
        }
    }

    static void deleteStudent(ArrayList<Student> students) {
        System.out.print("Enter Id Of Student You Want To Delete: ");
        int id = getValidInt();
        boolean removed = students.removeIf(s -> s.id == id);
        if (removed) {
            System.out.println("Student removed Successfully");
        } else {
            System.out.println("No Such Student Found In The Record");
        }
    }

    static void search(ArrayList<Student> students) {
        System.out.print("Enter the id of the student: ");
        int ids = getValidInt();
        boolean found = false;
        for (Student s : students) {
            if (s.id == ids) {
                System.out.println("Student found! Name: " + s.name + ", Marks: " + s.marks);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No such student found.");
    }

    static void update(ArrayList<Student> students) {
        System.out.print("Enter The id of the student to update: ");
        int id = getValidInt();
        boolean found = false;
        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new name: ");
                s.name = sc.nextLine();
                System.out.print("Enter new marks: ");
                s.marks = getValidInt();
                System.out.println("Student Details Updated Successfully");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No Such Student Exists");
    }

    static void sortByMarksAscending(ArrayList<Student> students) {
        if (students.isEmpty()) return;
        ArrayList<Student> sortedList = new ArrayList<>(students);
        sortedList.sort(Comparator.comparingInt(Student::getMarks));
        printSortedList(sortedList, "Sorted by Marks (Ascending)");
    }

    static void sortByMarksDescending(ArrayList<Student> students) {
        if (students.isEmpty()) return;
        ArrayList<Student> sortedList = new ArrayList<>(students);
        sortedList.sort(Comparator.comparingInt(Student::getMarks).reversed());
        printSortedList(sortedList, "Sorted by Marks (Descending)");
    }

    static void sortByName(ArrayList<Student> students) {
        if (students.isEmpty()) return;
        ArrayList<Student> sortedList = new ArrayList<>(students);
        sortedList.sort(Comparator.comparing(Student::getName));
        printSortedList(sortedList, "Sorted by Name");
    }

    private static void printSortedList(ArrayList<Student> list, String title) {
        System.out.println("--- " + title + " ---");
        for (Student s : list) {
            System.out.println("ID: " + s.id + " | Name: " + s.name + " | Marks: " + s.marks);
        }
    }

    static void displayCondition(ArrayList<Student> students) {
        System.out.print("Enter the threshold marks: ");
        int threshold = getValidInt();
        System.out.println("Students above " + threshold + ":");
        for (Student s : students) {
            if (s.marks > threshold) System.out.println("ID: " + s.id + " | Name: " + s.name + " | Marks: " + s.marks);
        }
    }
}