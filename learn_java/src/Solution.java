public class Solution<T> {
    public Solution(T ttt){
        new test<T>(1,ttt);
    }
    public static void main(String[] args) {
        String a = "Abc";
        new test<>(1,"abc");
        new Solution<String>("abc");

    }
}
class test<T>{
    int status;
    String msg;
    T data;
    public test(){
        System.out.println("空参构造器");
    }
    public test(int status,String msg){
        System.out.println("status,msg");
    }
    public test(int status,T data){
        System.out.println("status,data");
    }
}