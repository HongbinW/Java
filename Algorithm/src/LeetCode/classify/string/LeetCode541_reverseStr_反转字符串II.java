package LeetCode.classify.string;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/10
 */
public class LeetCode541_reverseStr_反转字符串II {
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int len = 2 * k;
        int start = 0;
        int end = start + len;
        while (start < chs.length){
            if (chs.length - start >= 2 * k){
                swap(chs,start,start+k-1);
            }else if (chs.length - start >= k){
                swap(chs,start,start+k-1);
            }else {
                swap(chs,start,chs.length-1);
            }
            start = end;
            end = start + len;
        }
        return new String(chs);
    }
    public void swap(char[] chs, int start, int end){
        while (start < end){
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode541_reverseStr_反转字符串II().reverseStr("abcdefg",2));
    }
}
