package examination.HuaWei.qiuzhao2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,HashSet<String>> wait = new HashMap<>();
        String curStruct = new String();
        String resStruct = new String();
        int curCount = 0;
        int target = 0;
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            if (str.startsWith("struct")){  //结构体
                String[] strs = str.split(" ");
                curStruct = strs[1];
            }else if (str.startsWith("    ")){  //成员
                String subStr = str.substring(4);
                if (subStr.startsWith("char")){
                    curCount += 1;
                }else if (subStr.startsWith("short")){
                    curCount += 2;
                }else if (subStr.startsWith("long")){
                    curCount += 4;
                }else if (subStr.startsWith("struct")){
                    String[] subStrs = subStr.split(" ");
                    if (curStruct.equals(subStrs[1])){
                        target = -1;
                        break;
                    } else if (!map.containsKey(subStrs[1])){//该结构体还不存在
                        if (wait.containsKey(curStruct)){
                            wait.get(curStruct).add(subStrs[1]);
                        }else{
                            HashSet<String> set = new HashSet<>();
                            set.add(subStrs[1]);
                            wait.put(curStruct,set);
                        }
                    }else{
                        if (valid(wait,curStruct,subStrs[1])){  // 循环依赖
                            target = -1;
                            break;
                        }
                    }
                }
            }else if (str.startsWith("sizeof")){ // 结束
                resStruct = str.substring(7,str.length()-1);
                break;
            }else{  // };
                map.put(curStruct,curCount);
                curCount = 0;
                curStruct = new String();
            }
        }
        if (target == -1){
            System.out.println(0);
            return;
        }
        target = process(map,wait,resStruct);
        if (target == -1){
            System.out.println(0);
        }else{
            System.out.println(target);
        }
    }
    public static boolean valid(HashMap<String,HashSet<String>> wait, String A, String B){
        if (!wait.containsKey(B)){
            return true;
        }else if (wait.get(B).contains(A)) {
            return false;
        }else{
            for (String key : wait.get(B)){
                boolean flag = valid(wait,A,key);
                if (!flag){
                    return false;
                }
            }
            return true;
        }
    }
    public static int process(HashMap<String,Integer> map, HashMap<String,HashSet<String>> wait, String target){
        if (!map.containsKey(target)){
            return -1;
        }else if (wait.containsKey(target)){
            int tmp = 0;
            for (String subStruct : wait.get(target)){
                int subTmp = process(map,wait,subStruct);
                if (subTmp == -1){
                    return -1;
                }
                wait.get(target).remove(subStruct);
                tmp += subTmp;
            }
            map.put(target,map.get(target) + tmp);
            return map.get(target);
        }else{
            return map.get(target);
        }
    }
}

