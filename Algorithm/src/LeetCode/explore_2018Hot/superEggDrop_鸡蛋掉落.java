package LeetCode.explore_2018Hot;

/**
 * @Author: HongbinW
 * @Date: 2020/1/1 21:17
 * @Version 1.0
 * @Description:
 */
public class superEggDrop_鸡蛋掉落 {
    // f(K,N) = Math.max(f(K-1,j-1),f(K,N-j)) + 1
    //OJ不过 时间复杂度高
    public static int superEggDrop(int K, int N) {
        int[][] arr = new int[K+1][N+1];
        for (int i = 1; i < N+1; i ++){
            arr[1][i] = i;
        }
        for (int i = 1; i < K+1; i ++){
            arr[i][1] = 1;
        }
        //f(i,j) = Math.max(f(i-1,k-1),f(i,j-k))+1
        for (int i = 2; i < K+1; i ++){ //鸡蛋数
            for (int j = 1; j <= N; j ++){ //楼层数
                arr[i][j] = j;
                for (int k = 1; k <= j; k ++) {  //从哪一层开始分
                    int temp = Math.max(arr[i-1][k-1], arr[i][j-k]) + 1;
                    arr[i][j] = Math.min(temp,arr[i][j]);
                }
            }
        }
        return arr[K][N];
    }

    public static int superEggDrop2(int K, int N) {
        int[][] arr = new int[K+1][N+1];
        for (int i = 1; i < N+1; i ++){
            arr[1][i] = i;
        }
        for (int i = 1; i < K+1; i ++){
            arr[i][1] = 1;
        }
        //f(i,j) = Math.max(f(i-1,k-1),f(i,j-k))+1
        for (int i = 2; i < K+1; i ++){ //鸡蛋数
            for (int j = 1; j <= N; j ++){ //楼层数
                //使用二分法，因为f(i-1,k-1)随着k的增大而增大，另一个随着k的增大而减小，因此当两者相等时，为最优解,×,交点为最小值
                int left = 1, right = j;
                arr[i][j] = j;
                while (left < right){
                    int mid = left + (right - left) / 2;
                    if (arr[i-1][mid-1] < arr[i][j-mid]) {
                        left = mid + 1;
                    } else{
                      right = mid;
                    }
                }
                arr[i][j] = Math.min(arr[i][j],Math.max(arr[i-1][right-1],arr[i][j-right])+1);
            }
        }
        return arr[K][N];
    }

    public static int process(int K, int N){
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i ++){
            int left = process(K-1,i-1);
            int right = process(K,N-i);
            if (K-1 == 0 || i - 1 == 0){
                left = 0;
            }
            if (K == 0 || N - i == 0){
                right = 0;
            }
            result = Math.min(result,1 + Math.max(left,right));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop2(50,1000));
    }
}
