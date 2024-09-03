import java.util.*;

class Student {
    int id;
    String name;
    char grade;
    int age;

    public Student(int id, String name, char grade, int age) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + grade + " " + age;
    }
}

class IdComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.id, s2.id);
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

class GradeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Character.compare(s1.grade, s2.grade);
    }
}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.age, s2.age);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose to sort the array: id, name, grade, age");
        String input = scanner.next();
//        grshrg
//dhdhdxfgrgfiv
        ArrayList<Student> al =new ArrayList<>();
        al.add(new Student(104, "Raju", 'C', 18));
        al.add(new Student(102, "Akshay", 'B', 17));
        al.add(new Student(101, "Kaka", 'O', 16));
        al.add(new Student(103, "Ramana", 'D', 14));

        Main cmg = new Main();
        cmg.sortingFunction(al, input);
    }


    public void sortingFunction(ArrayList<Student> al, String input) {
        Comparator<Student> comparator = null;

        switch (input.toLowerCase()) {
            case "id":
                comparator = new IdComparator();
                break;
            case "name":
                comparator = new NameComparator();
                break;
            case "grade":
                comparator = new GradeComparator();
                break;
            case "age":
                comparator = new AgeComparator();
                break;
            default:
                System.out.println("Invalid input");
                return;
        }

        al.sort(comparator);

        for (Student st : al) {
            System.out.println(st);
        }
    }
}
