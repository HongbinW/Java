package LeetCode.会员.猿辅导;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/13
 */
public class LeetCode340_lengthOfLongestSubstringKDistinct_至多包含K个不同字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(new LeetCode340_lengthOfLongestSubstringKDistinct_至多包含K个不同字符的最长子串().
                new Solution().lengthOfLongestSubstringKDistinct("a@b$5!a8alskj234jasdf*()@$&%&#FJAvjjdaurNNMa8ASDF-0321jf?>{}L:fh",10));
    }
    class Solution{
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int left = 0;
            int right = 0;
            char[] chs = s.toCharArray();
            int[] arr = new int[256];
            int count = 0;
            int res = 0;
            while (right < chs.length){
                if (count <= k){
                    if(arr[chs[right]] == 0){
                        count ++;
                    }
                    arr[chs[right++]] ++;
                    if (count <= k) {
                        res = Math.max(res, right - left);
                    }
                }else{
                    if (arr[chs[left]] == 1){
                        count --;
                    }
                    arr[chs[left++]] --;
                }
            }
            return res;
        }
    }
}
