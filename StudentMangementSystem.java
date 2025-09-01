import java.util.*;
 class Student {
    private final int id;
    private String name;
    private int age;
    private String course;


    public Student( int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() { return id;}
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }

    public void serName( String name) { this.name = name;}
    public void setAge( int age) {this.age = age; }
    public void setCourse( String course) { this.course = course; }
 
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + 
               ", Age: " + age + ", Course: " + course;
    }
}

public  class StudentMangementSystem{

    private static List<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System---");
            System.out.println("1.Add Student");
            System.out.println("2.View Students");
            System.out.println("3.Update Student");
            System.out.println("4.Delete Student");
            System.out.println("5.Exit");
            System.out.println("Enter Choice");

            int choice = sc.nextInt();
            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.exit(0);
                default: System.out.println(" Invalid choice!");
            }
        }
    }

    private static void addStudent() {
      System.out.println(" Enter ID: ");
      int id = sc.nextInt();
      sc.nextLine();
      System.out.print(" Enter Name: ");
      String name = sc.nextLine();
      System.out.print(" Enter Age: ");
      int age = sc.nextInt();
      sc.nextLine();
      System.out.println(" Enter Course: ");
      String course = sc.nextLine();

      students.add( new Student( id, name, age, course));
      System.out.println(" Student added Successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for ( Student s : students) {
            System.out.println(s);
        }
    }

    private static void updateStudent() {
        System.out.print(" Enter Student ID  to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student s : students) {
            if ( s.getId() == id) {
                System.out.println(" Enter new Name: ");
                s.serName(sc.nextLine());
                System.out.println(" Enter new Age: ");
                s.setAge( sc.nextInt());
                sc.nextLine();
                System.out.print(" Enter new Course: ");
                s.setCourse( sc.nextLine());
                System.out.println(" Student updated!");
                return;
            }
        }
        System.out.println(" Student not found: ");
    }
      private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                System.out.println("Student deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}