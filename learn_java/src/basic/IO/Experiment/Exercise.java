package basic.IO.Experiment;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create a program named MyInput.java: Contain the methods for reading int, double, float, boolean, short,
 * byte and String values from the keyboard
 */
public class Exercise {
    public static void main(String[] args) {
        Exercise e = new Exercise();
        System.out.println("请输入一个字符串：");
        String str = e.nextString();
        System.out.println(str);
        int a = e.nextInt();
        System.out.println(a + 1);
    }
    public String nextString(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public int nextInt(){
        return Integer.parseInt(nextString());
    }
    public boolean nextBoolean(){
        return Boolean.parseBoolean(nextString());
    }
}
