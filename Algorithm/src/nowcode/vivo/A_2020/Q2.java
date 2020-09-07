//package nowcode.vivo.A_2020;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Stack;
//
///**
// * Description
// * Author  HongbinW
// * Date 2020/6/2
// */
//public class Q2 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String inputStr = br.readLine();
//        int input[] = parseInts(inputStr.split(" "));
//        int output = solution(input);
//        System.out.println(output);
//    }
//
//    private static int[] parseInts(String[] strArr) {
//        if (strArr == null || strArr.length == 0) {
//            return new int[0];
//        }
//        int[] intArr = new int[strArr.length];
//        for (int i = 0; i < intArr.length; i++) {
//            intArr[i] = Integer.parseInt(strArr[i]);
//        }
//        return intArr;
//    }
//
//    private static int solution(int[] input) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i = 0; i < input.length; i ++){
//            if (!map.containsKey(input[i])){
//                map.put(input[i],1);
//            }else{
//                map.put(input[i],map.get(input[i])+1);
//            }
//        }
//        Stack<Integer> stack = new Stack<>();
//        HashMap<Integer,Integer> countMap = new HashMap<>();
//        int res = 0;
//        for (int i = 0; i < input.length; i ++){
//            stack.push(input[i]);
//
//            if (!countMap.containsKey(input[i])){
//                countMap.put(input[i],1);
//            }else {
//                countMap.put(input[i],countMap.get(input[i])+1);
//            }
//            if (countMap.get(input[i]) == map.get(input[i])){
//                int curCount = 0;
//                while (stack.peek() == input[i]){
//                    curCount ++;
//                    stack.pop();
//                }
//                res += curCount * curCount;
//            }
//        }
//        while (!stack.isEmpty()){
//            int cur = stack.pop();
//            int curCount = map.get(cur);
//            while (curCount > 0){
//                if ()
//            }
//        }
//        return res;
//    }
//}
