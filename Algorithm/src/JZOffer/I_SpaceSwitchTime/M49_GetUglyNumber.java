package JZOffer.I_SpaceSwitchTime;

public class M49_GetUglyNumber {
    //计算太慢
    public static int GetUglyNumber_Solution(int index) {
        int count = 1;
        int i = 1;
        while(count < index){
            i ++;
            while (i % 2 == 0){
                i /= 2;
            }
            if (i == 0){
                count++;
                continue;
            }
            while (i % 3 == 0){
                i /= 3;
            }
            if (i == 0){
                count++;
                continue;
            }
            while (i % 5 == 0){
                i /= 5;
            }
            if (i == 0){
                count++;
                continue;
            }
        }
        return i;
    }

    public static int GetUglyNumber(int index){
        int[] arr = new int[index];
        int T2 = 0, T3 = 0, T5 = 0;
        for (int i = 1; i < index; i++){
            while (T2 < index && arr[T2] * 2 <= arr[i-1]){
                T2++;       //找到第一个*2大于当前已知的最大丑数的索引
            }
            while (T3 < index && arr[T3] * 3 <= arr[i-1]){
                T3++;
            }
            while (T5 < index && arr[T5] * 5 <= arr[i-1]){
                T5++;
            }
            arr[i] = Math.min(T2 < index ? 2 * arr[T2] : Integer.MAX_VALUE,T3 < index ? 3 * arr[T3] : Integer.MAX_VALUE);
            arr[i] = Math.min(arr[i],T5 < index ? 5*arr[T5] : Integer.MAX_VALUE);
        }
        return arr[index-1];
    }

    public static void main(String[] args) {
//        System.out.println(GetUglyNumber_Solution(1500));
        System.out.println(GetUglyNumber(1));
    }
}
