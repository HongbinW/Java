package advance.advance_1;
//向字符串最后添加最少的字符，使整体成为一个回文串
public class Code03_appendLeastToLcp {
    public static char[] manacherString(String str){
        char[] chs = str.toCharArray();
        char[] res = new char[chs.length*2+1];
        int index = 0;
        for(int i = 0; i < res.length; i++){
            res[i] = (i & 1) == 0 ? '#' : chs[index++];
        }
        return res;
    }

    public static String minChars(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        char[] chs = manacherString(str);
        int[] arr = new int[chs.length];
        int C = -1;
        int R = -1;
        int maxContainsEnd = -1;
        for(int i = 0 ; i < arr.length; i ++) {
            arr[i] = i < R ? Math.min(R - i, arr[2 * C - i]) : 1;
            while (i + arr[i] < arr.length && i - arr[i] >= 0) {
                if (chs[i + arr[i]] == chs[i - arr[i]]) {
                    arr[i]++;
                } else {
                    break;
                }
            }
            if (i + arr[i] > R) {
                R = i + arr[i];
                C = i;
            }
            if (R == arr.length) {
                maxContainsEnd = arr[i];
                break;
            }
        }
        char[] res = new char[str.length()-maxContainsEnd + 1];
        for(int i = 0; i < res.length; i++){
            res[res.length-1-i] = chs[i*2+1];
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(minChars("aaab"));
    }
}
