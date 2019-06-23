import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        new Father().g();
        new Son().g();
    }
}
class Father{
    public int x = 0;
    private void f(){

    }
    public static void g(){
        System.out.println("!23");
    }
}

class Son extends Father{
    public int x = 1;
    private void f(){

    }
    public static void g(){
        System.out.println("456");
    }
}

