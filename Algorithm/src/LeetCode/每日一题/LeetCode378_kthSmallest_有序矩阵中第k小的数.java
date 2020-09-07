package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/2
 */
public class LeetCode378_kthSmallest_有序矩阵中第k小的数 {
    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8));
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix.length-1];
        while (left < right){
            int mid = left + (right - left) / 2;
            if (check(matrix,mid,k,matrix.length)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;       // 这一列中有多少满足情况
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
