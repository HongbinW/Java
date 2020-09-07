import java.util.HashMap;

public class Solution extends Son implements Reader{
    public void Read(){

    }
    public static void main(String[] args) {

    }
}
interface Reader{
    void Read();
    default void Write(){
        System.out.println();
    }
}
abstract class Father{

    abstract void Read();
}
abstract class Son extends Father{
    public void Read(){

    }
}