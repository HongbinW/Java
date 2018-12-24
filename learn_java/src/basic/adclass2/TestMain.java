package basic.adclass2;
//给main函数传入形参
// Idea:Run-Edit Configuration-Program arguments
// CMD: java file.java
//      javac file "abc" "def" "cjy"

public class TestMain {
    //主方法，是程序的入口
    public static void main(String[] args){
        for(int i = 0;i < args.length;i++){
            System.out.println(args[i]);
        }
    }

}
