package tips;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: HongbinW
 * @Date: 2019/7/7 20:54
 * @Version 1.0
 * @Description:
 */
public class TestComparator {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < 10 ; i ++){
            arr[i] = (int)(Math.random() * 10);
        }
        Arrays.sort(arr,new MyComparator());
        for (int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("#############Student###############");
        Student[] students = new Student[]{
                new Student(10),
                new Student(12),
                new Student(3),
                new Student(6),
                new Student(5)
        };
        Arrays.sort(students);
        for (Student s : students){
            System.out.print(s.age + " ");
        }

    }
}

class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return  o1 - o2;    //与传入顺序一直则升序
    }
}

class Student implements Comparable<Student>{
    int age;
    public Student(int age){
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;    //自身去减传入，升序
    }
}
