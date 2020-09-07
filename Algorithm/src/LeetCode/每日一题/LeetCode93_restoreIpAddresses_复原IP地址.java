package LeetCode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/9
 */
public class LeetCode93_restoreIpAddresses_复原IP地址 {
    public static void main(String[] args) {
        List<String> list = new LeetCode93_restoreIpAddresses_复原IP地址().restoreIpAddresses("010010");
        for (String str : list){
            System.out.println(str);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() < 4){
            return list;
        }
        process(s.toCharArray(), 0, new ArrayList<>(), 0, list);
        return list;
    }
    public void process(char[] chs, int index, List<Integer> list, int count, List<String> res){
        if (count > 4){
            return;
        }else if (index == chs.length && count == 4){
            StringBuilder sb = new StringBuilder();
            for (Integer str : list){
                sb.append(str);
                sb.append(".");
            }
            res.add(sb.subSequence(0,sb.length()-1).toString());
        }else{
            int cur = 0;
            for (int i = index; i < chs.length && cur < 255;){
                cur = cur * 10 + chs[i] - '0';
                if (cur == 0){  // 零只能单独一个
                    i ++;
                    list.add(cur);
                    process(chs,i,list,count+1,res);
                    list.remove(list.size()-1);
                    break;
                }
                if (cur > 0 && cur <= 255){
                    i ++;
                    list.add(cur);
                    process(chs,i,list,count+1,res);
                    list.remove(list.size()-1);
                }else{
                    break;
                }
            }
        }
    }
}

