package advance.advance_1;

public class Code02_Manacher {
    public static char[] manacherString(String str){
        char[] chs = str.toCharArray();
        char[] res = new char[chs.length*2+1];
        int index = 0;
        for(int i = 0; i < res.length; i++){
            res[i] = (i & 1) == 0 ? '#' : chs[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];   //回文半径数组
        int C = -1; //回文最右位置
        int R = -1; //回文中心
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < charArr.length; i++){
            // 当R > i时,当前位置的最大回文长度的瓶颈是
            // i到R的距离 或者 i'的回文半径 这俩哪个短哪个是当前不用验的长度
            // R > i时,一个有两种情况,即,i'的回文半径是否超过R,但是不用验的区域都是要比较上述两个的长短
            pArr[i] = R > i ? Math.min(pArr[2*C-i],R-i) : 1;
            //往外扩
            //所有情况都试着扩一下，如果可能性2或3，则会直接break，这样可以缩短代码
            while(i + pArr[i] < charArr.length && i - pArr[i] > -1){
                if(charArr[i + pArr[i]] == charArr[i - pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            //超出了原有的R，更新回文右边界和回文中心
            if(i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max,pArr[i]);
        }
        return max - 1;//因为每个pArr[i]都包含了#，所以记录半径即全长,且每个基数就是1
    }

    public static void main(String[] args) {
        System.out.println(maxLcpsLength("abc"));
    }
}
