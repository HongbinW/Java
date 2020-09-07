package LeetCode.classify.string;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/5
 */
public class LeetCode443_compress_压缩字符串 {
        public int compress(char[] chars) {
            if (chars == null || chars.length == 0)
                return 0;
            int index = 0;
            int left = 0;
            int size = 0;
            while (left < chars.length){
                int right = left + 1;
                while (right < chars.length && chars[right] == chars[left]){
                    right ++;
                }
                chars[index++] = chars[left];
                if (right > left + 1){
                    int newIndex = putCount(chars,index,right - left);
                    size += newIndex - index + 1;
                    index = newIndex;
                }else {
                    size ++;
                }
                left = right;
            }
            return size;
        }
        public int putCount(char[] chs, int index, int count){
            int ed = 1000;
            while (count / ed == 0){
                ed /= 10;
            }
            while (ed > 0){
                chs[index++] = (char)(count / ed + '0');
                count %= ed ;
                ed /= 10;
            }
            return index;
        }

    public static void main(String[] args) {
            char[] chs = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b','a','a'};
        System.out.println(new LeetCode443_compress_压缩字符串().compress(chs));
    }
}
