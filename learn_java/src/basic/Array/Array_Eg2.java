package basic.Array;
/*
3. 从键盘读入学生成绩，找出最高分，并输出学生成绩等级。
成绩>=最高分-10    等级为’A’
成绩>=最高分-20    等级为’B’
成绩>=最高分-30    等级为’C’
其余                            等级为’D’

提示：先读入学生人数，根据人数创建int数组，存放学生成绩。
 */
import java.util.Scanner;
public class Array_Eg2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生人数");
        int count = sc.nextInt();
        int[] scores = new int[count];
        System.out.println("请输入学生成绩");
        for (int i = 0;i < count;i++){
            scores[i] = sc.nextInt();
        }
        int maxscores = scores[0];
        for (int i = 1;i < count;i++){
            if (scores[i] > maxscores){
                maxscores = scores[i];
            }
        }
        System.out.println("最高分是"+maxscores);
        for(int i = 0;i < count; i++){
            if (scores[i] >= maxscores - 10){
                System.out.println("Student " + i +" score is " + scores[i] + " grade is "+"A");
            }
            else if (scores[i] >= maxscores - 20){
                System.out.println("Student " + i +" score is " + scores[i] + " grade is "+"B");
            }
            else if (scores[i] >= maxscores - 30){
                System.out.println("Student " + i +" score is " + scores[i] + " grade is "+"C");
            }
            else {
                System.out.println("Student " + i +" score is " + scores[i] + " grade is "+"D");
            }
        }
    }
}
