import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0 ; i < arr.length; i++){
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        Season str = Season.valueOf("SPRING");
        System.out.println(str);
        Season season = Season.SPRING;
        System.out.println(season);
        Season.valueOf("Summer");
    }
}

enum Season{
    SPRING,Summer,Alturm,Winter
}

