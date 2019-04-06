package hashTable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: HongbinW
 * @Date: 2019/4/4 10:50
 * @Version 1.0
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer)a).hashCode());    //42

        int b = -42;
        System.out.println(((Integer)b).hashCode());    //-42

        //hashCode只是将传入的值对应到一个整型。而不能将其直接转换为索引，因为我们不知道其范围

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode()); //219937201

        String d = "immoc";
        System.out.println(d.hashCode());   //100325213

        Student student = new Student(3,2,"W","hb");
        System.out.println(student.hashCode());

        HashSet<Student> set = new HashSet<>();
        set.add(student);
        HashMap<Student,Integer> scores = new HashMap<>();
        scores.put(student,100);

    }
}
