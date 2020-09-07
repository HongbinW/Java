package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/12
 */
public class LeetCode365_canMeasureWater_水壶问题 {
    // z = ax + by， z是xy最大公约数的倍数即可
    public boolean canMeasureWater(int x, int y, int z) {
        if(x==z||y==z||x+y<=z){
            if(x+y<z){
                return false;
            }
            return true;
        }
        return (z%gcd(x,y))==0;
    }
    public int gcd(int x,int y){
        return y==0 ? x:gcd(y,x%y);
    }

    // my
    // 思路：保持x < y。不断将y倒进x，如果left< right，就互换一下
    public boolean canMeasureWater2(int x, int y, int z) {
        if(x == z || y == z || x + y == z || z == 0){
            return true;
        }
        if(x + y < z){
            return false;
        }
        if(x > y){
            int temp = x;
            x = y;
            y = temp;
        }
        int left = 0, right = y;
        while(left != x || y != right){
            if(left < right){
                right = left == x ? right - x : right + left - x;   // 如果left == x，只要右边减就可以了
                left = x;
            }else{
                left = right;
                right = y;
            }
            if(left == z || right == z || left + right == z){
                return true;
            }
        }
        return false;
    }
}

