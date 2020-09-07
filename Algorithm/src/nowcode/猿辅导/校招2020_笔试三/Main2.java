package nowcode.猿辅导.校招2020_笔试三;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/18
 */
public class Main2 {
    static class Class{
        int studentNum;
        int teacherId;
        String name;
        public Class(int studentNum, int teacherId, String name){
            this.studentNum = studentNum;
            this.teacherId = teacherId;
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Class> list = new ArrayList<>();
        HashMap<Integer,String> studentInfo = new HashMap<>();
        for (int i = 0; i < N; i ++){
            Class c = new Class(sc.nextInt(),sc.nextInt(),sc.next());
        }


    }
    public void process(){

    }
}
