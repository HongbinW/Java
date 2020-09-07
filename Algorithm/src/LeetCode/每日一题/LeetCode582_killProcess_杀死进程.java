package LeetCode.每日一题;

import java.util.*;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/13
 */
public class LeetCode582_killProcess_杀死进程 {
    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(1,3,10,5);
        List<Integer> ppid = Arrays.asList(3,0,5,3);
        List<Integer> res = new LeetCode582_killProcess_杀死进程().killProcess(pid,ppid,5);
        System.out.println(res  );
    }
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i ++){
            if (map.containsKey(ppid.get(i))){
                map.get(ppid.get(i)).add(pid.get(i));
            }else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(pid.get(i));
                map.put(ppid.get(i), tmp);
            }
        }
        res.add(kill);
        for (int i = 0; i < res.size(); i ++){
            if (map.containsKey(res.get(i))){
                res.addAll(map.get(res.get(i)));
            }
        }
        return res;
    }
}
