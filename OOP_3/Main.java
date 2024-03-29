import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout.Group;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(4, "aab", "aab", "aab");
        Student student2 = new Student(2, "aaa", "aaa", "aaa");
        Student student3 = new Student(3, "Aaa", "Aaa", "Aaa");
        Student student4 = new Student(1, "bbb", "bbb", "bbb");
        List<Student> studentList1 = new ArrayList<>();
        StudentGroup studentGroup1 = new StudentGroup(studentList1);
        studentGroup1.addStudent(student1);
        studentGroup1.addStudent(student2);
        studentGroup1.addStudent(student3);
        studentGroup1.addStudent(student4);

        Student student5 = new Student(5, "Aab", "aab", "aab");
        Student student6 = new Student(6, "aaa", "aaa", "aaa");
        Student student7 = new Student(7, "baa", "Aaa", "Aaa");
        List<Student> studentList2 = new ArrayList<>();
        StudentGroup studentGroup2 = new StudentGroup(studentList2);
        studentGroup2.addStudent(student5);
        studentGroup2.addStudent(student6);
        studentGroup2.addStudent(student7);

        System.out.println("Первая группа:");
        StudentGroupService service = new StudentGroupService(studentGroup1);
        for (Student student : studentGroup1) {
            System.out.println(student);
        }
        System.out.println();
        System.out.println("по ID:");
        for (Student student : service.getSortedStudentGroup()) {
            System.out.println(student);
        }
        System.out.println();
        System.out.println("по ФИО:");
        for (Student student : service.getSortedStudentGroupByFIO()) {
            System.out.println(student);
        }
        System.out.println();

        System.out.println("Вторая группа:");
        StudentGroupService service1 = new StudentGroupService(studentGroup2);
        for (Student student : studentGroup2) {
            System.out.println(student);
        }
        System.out.println();
        System.out.println("по ID:");
        for (Student student : service1.getSortedStudentGroup()) {
            System.out.println(student);
        }
        System.out.println();
        System.out.println("по ФИО:");
        for (Student student : service1.getSortedStudentGroupByFIO()) {
            System.out.println(student);
        }

        Stream stream1 = new Stream(studentGroup1);
        Stream stream2 = new Stream(studentGroup2);

        StreamComparator comparator = new StreamComparator();

        int comparison = comparator.compare(stream1, stream2);

        if (comparison > 0) {
            System.out.println("В потоке 1 больше групп, чем в потоке 2");
        } else if (comparison < 0) {
            System.out.println("В потоке 2 больше групп, чем в потоке 1");
        } else {
            System.out.println("В потоках 1 и 2 одинаковое количество групп");
        }
    }
}