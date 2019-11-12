package nowcode.LeetCode;
// diff
// https://www.nowcoder.com/practice/1025ffc2939547e39e8a38a955de1dd3?tpId=46&tqId=29048&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
public class minCut_回文串_最小分割数 {
    //TODO:没做出来
    public int minCut(String s) {
        if (s == null || s.length() < 2){
            return 0;
        }
        return process(s.toCharArray(),0,s.length()-1);
    }
    public int process(char[] s, int left, int right){
        if (left >= right)
            return 0;
        int res = 1;
        for (int i = left; i <= right; i ++){
            int index = 0;
            int index2 = 0;
            while (i - index >= left && i + index <= right && s[i-index] == s[i + index]){
                index ++;
            }
            if (i > left && s[i] == s[i-1]){
                while (i - index2 - 1 >= left && i + index2 <= right && s[i-index2-1] == s[i+index2]){
                    index2 ++;
                }
            }
            if (index2 >= index){
                if (i - index2 - 1 > left)

                res = Math.min(res, process(s,left,i-index2-1) + process(s,i+index2,right));
            }else {
                res = Math.min(res, process(s,left,i-index) + process(s, i+index, right));
            }
        }
        return res;
    }

    public int process2(char[] s, int left, int right){
        if (left == right)
            return 0;
        int i = 0;
        for (; i < (right - left) / 2; i ++){
            if (s[left+i] != s[right-i]){
                break;
            }
        }
        if (i == (right - left) / 2 - 1){
            return 0;
        }
        for (i = left; i <= right; i ++){

        }


        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new minCut_回文串_最小分割数().minCut("aba"));
    }

}
