package thread;

import java.util.*;

/**
 * @Author: HongbinW
 * @Date: 2019/8/21 22:33
 * @Version 1.0
 * @Description: ArrayList线程不安全，写一个不安全案例并给出解决方案
 */
public class ArrayList_Question_Solution {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        list.forEach(System.out::println);              //这个写法比较有趣
        for (int i = 0 ; i < 3; i ++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i+1)).start();
        }
    }

    /**
     * 1.故障现象：java.util.ConcurrentModificationException
     * 2.导致原因：
     *
     *
     * 3.解决方案：
     *      new Vector<>();
     *      Collections.synchronizedList(new ArrayList<>());
     *
     * 4.优化建议
     *
     */
}
