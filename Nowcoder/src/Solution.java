import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] envelope1, int[] envelope2) {
                return envelope1[0] == envelope2[0] ? envelope2[1] - envelope1[1] : envelope1[0] - envelope2[0];
            }
        });
        int n = envelopes.length;
        int[] top = new int[n];
        int piles = 0;
        int left, right, mid;

        for (int i = 0; i < n; i++){
            // 找寻poker的左边界
            left = 0;
            right = piles;

            while (left < right){
                mid = (left + right) / 2;
                if (top[mid] >= envelopes[i][1]){
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            if (left == piles)  piles++;
            top[left] = envelopes[i][1];
        }

        return piles;
    }
}