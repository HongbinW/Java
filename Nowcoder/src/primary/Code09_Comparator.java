package primary;

import java.util.*;

public class Code09_Comparator {
    public static class Student{
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
    public static class IdAscendingComparator implements Comparator<Student>{   //升序
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;   //返回负数，则o1排o2前面
        }
    }

    public static class DeAscendingComparator implements Comparator<Student>{   //降序
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }
    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }
    public static void main(String[] args){
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);
        Student[] students = new Student[] { student3, student2, student1 };
        printStudents(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator()); //优先级队列，即堆
        heap.add(student3);
        heap.add(student2);
        heap.add(student1);

        while (!heap.isEmpty()){
            Student student = heap.poll();  //弹出堆顶
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }

//        TreeSet<Student> treeSap = new TreeSet<>(new IdAscendingComparator());  //红黑树

    }
}
