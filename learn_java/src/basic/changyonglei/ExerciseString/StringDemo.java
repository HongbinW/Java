package basic.changyonglei.ExerciseString;

/**
 * Description
 * Author  HongbinW
 * Date 2019/1/23
 */

import org.junit.Test;

/**
 * 1.模拟一个trim方法，去除字符串两端的空格。
 *
 * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 *
 * 3.获取一个字符串在另一个字符串中出现的次数。
 *       比如：获取“ ab”在 “abkkcadkabkebfkabkskab”
 *       中出现的次数
 */
public class StringDemo {
    public String sitrim(String origin){
        if(origin == null)
            return origin;
        int i = 0;
        while (origin.charAt(i) - ' ' != 0){
            i ++;
        }
        String result = origin.substring(i);

        return result;
    }

}
