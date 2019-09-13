import java.util.*;

public class Solution{
    public static String solution(char[] result){
        LinkedList<Character> linkedList = new LinkedList<>();
        //假设的初始序列
        for (int i = 0; i < result.length; i ++){
            linkedList.addLast(result[i]);
        }
        //按题目要求排序后的结果
        ArrayList<Character> list = process(linkedList);

        //题目所给顺序对应坐标
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < result.length; i ++){
            s.append(result[i] - 'a' + 1);
        }

        //结果集中，以最开始假设的编号为key，以字符为value
        TreeMap<Integer,Character> map = new TreeMap<>();
        for (int i = 0; i < result.length; i ++){
            map.put(s.charAt(i) - '0',list.get(i));
        }

        StringBuilder oriOrder = new StringBuilder();
        for (int i : map.keySet()){
            oriOrder.append(map.get(i));
        }
        return oriOrder.toString();
    }
    public static ArrayList<Character> process(LinkedList<Character> list){
        ArrayList<Character> res = new ArrayList<>();
        while (!list.isEmpty()){
            res.add(list.pollFirst());
            if (!list.isEmpty())
                list.addLast(list.pollFirst());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("acegikmbfjdlh".toCharArray()));
    }

}