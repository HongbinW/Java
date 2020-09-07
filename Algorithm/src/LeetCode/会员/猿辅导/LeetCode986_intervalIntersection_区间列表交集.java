package LeetCode.会员.猿辅导;

import java.util.ArrayList;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/25
 */
public class LeetCode986_intervalIntersection_区间列表交集 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int indexA = 0;
        int indexB = 0;
        int lenA = A.length;
        int lenB = B.length;
        ArrayList<int[]> list = new ArrayList<>();
        while (indexA < lenA && indexB < lenB){
            if (A[indexA][1] < B[indexB][0]){
                indexA ++;
            }else if (A[indexA][0] > B[indexB][1]){
                indexB ++;
            }else{
                list.add(new int[]{Math.max(A[indexA][0],B[indexB][0]), Math.min(A[indexA][1],B[indexB][1])});
                if (A[indexA][1] > B[indexB][1]){
                    indexB ++;
                }else{
                    indexA ++;
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i ++){
            res[i] = list.get(i);
        }
        return res;
    }
}
