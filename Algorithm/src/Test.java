import java.util.*;

public class Test{
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Aa",1);
        map.put("BB",2);

        for(Map.Entry<String,Integer> ele : map.entrySet ()){

            System.out.println(ele.getKey());
            System.out.println(ele.getValue());
        }
    }
}