package Zuo100.c1;
//一排数字，玩家AB轮流拿，每次都是要么选最左要么选最右，求获胜者的分数

//类似：https://leetcode-cn.com/problems/nim-game/
public class Q3_CardsInLine_轮流拿牌求胜者分数 {
        //法一：递归
    public static int win1(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        /**
         * 当然此处也可以先求和，然后只求先手f的递归值，最后返回用总和减先手f的值即可
         */
        return Math.max(f(arr,0,arr.length-1),s(arr,0,arr.length-1));
    }
    //先手在start到end区间内获得的最优分数
    public static int f(int[] arr, int start, int end){
        if (start == end){
            return arr[start];
        }
        //arr[x]表示挑选头或者尾的元素，s(***)表示，因为挑选完后，该对面选了，所以自己相当于变成了后手
        return Math.max(arr[start] + s(arr,start+1,end),arr[end] + s(arr,start,end-1));
    }
    //后手在start到end区间内获得的最优分数
    public static int s(int[] arr, int start, int end){
        if (start == end){
            return 0;   //只有一个数，则先手会取这个数，则后发就没有数了，所以是0
        }
        //因为是后手，所以只能从先手挑完后的结果中选择，而这结果是先手选完后留给自己的最差的结果，所以是min
        return Math.min(f(arr,start+1,end),f(arr,start,end-1));
    }

    public static void main(String[] args) {
        System.out.println(win4(new int[]{3,8,4,5,6,1,2}));
    }

        //法二：动态规划
    public static int win2(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        //执行顺序为先确定第j列，然后i从j-1开始，顺序往上计算
        for (int j = 0; j < arr.length ; j++){
            f[j][j] = arr[j];   //s[j][j]默认为0
            for (int i = j - 1; i >= 0; i --){
                f[i][j] = Math.max(arr[i] + s[i + 1][j],arr[j] + s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j],f[i][j-1]);
            }
        }
        return Math.max(f[0][arr.length-1],s[0][arr.length-1]);
    }

    //法三：一个递归
    public static int win3(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int sum = 0;
        for (int i : arr){
            sum += i;
        }
        int f = p(arr,0,arr.length-1);
        return Math.max(sum-f,f);
    }

    //写一个递归
    public static int p(int[] arr, int i, int j){
        if (i == j){
            return arr[i];
        }
        if (i + 1 == j){
            return Math.max(arr[i],arr[j]);
        }
        return Math.max(
                //p(arr,i+2,j)表示我拿了最左边的数，对方也拿了最左边的数
                //相当于，我先拿了最左边的一个，然后对方从[i+1,j]上去挑，挑完之后我再挑，而我挑哪个呢？对方肯定会留给我我之后再挑的最小的结果给我
                arr[i] + Math.min(p(arr,i+2,j),p(arr,i+1,j-1)),

                arr[j] + Math.min(p(arr,i+1,j-1),p(arr,i,j-2)));
    }

    //法三改为动态规划-->法四
    //通过画图可只知，一个表是隔行依赖
    public static int win4(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int[][] dp = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j ++){
            dp[j][j] = arr[j];
            if (j > 0){
                dp[j-1][j] = Math.max(arr[j-1],arr[j]);
            }
            for (int i = j - 2; i >= 0; i --){
                dp[i][j] = Math.max(arr[i] + Math.min(dp[i+2][j],dp[i+1][j-1]),
                        arr[j] + Math.min(dp[i+1][j-1],dp[i][j-2]));
            }
        }
        return dp[0][arr.length-1];
    }
}
