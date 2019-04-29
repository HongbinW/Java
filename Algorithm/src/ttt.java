/**
 * @Author: HongbinW
 * @Date: 2019/4/2 21:04
 * @Version 1.0
 * @Description:
 */


import java.util.Scanner;
public class ttt{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
//        while(sc.hasNextLine()){
//            String s = sc.nextLine();
//            if(s.equals(""))
//                break;
//            arr = count(arr,s);
//        }
        String[] strs = sc.nextLine().split(" ");
        for(int i = 0; i < strs.length; i++){
            arr = count(arr,strs[i]);
        }
        for(int i = 1; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i != arr.length - 1 ){
                System.out.print(" ");
            }
        }
    }

    public static int[] count(int[] arr,String str){
        String[] ip = str.split("~");
        if(!validMaskCode(ip[1])){
            arr[6] ++;
            return arr;
        }
        String[] strs = ip[0].split("\\.");
        int[] value = new int[strs.length];
        for(int i = 0 ; i < strs.length ; i++) {
            try {
                int temp = Integer.parseInt(strs[i]);
                if (temp >= 0 && temp <= 255) {
                    value[i] = temp;
                } else {
                    arr[6]++;
                    return arr;
                }
            }catch(Exception e){
                arr[6] ++;
                return arr;
            }
        }
        if(value[0] == 0){
            return arr;
        }
        if(value[0] == 127){
            arr[6]++;
            return arr;
        }
        if (value[0] >= 1 && value[0] < 127) {
            arr[1]++;
            if (value[0] >= 10 && value[0] < 11)
                arr[7]++;
        } else if (value[0] >= 128 && value[0] < 192) {
            arr[2]++;
            //172.16.0.0～172.31.255.255
            if(value[0] == 172 && value[1] >= 16 && value[1] < 32)
                arr[7] ++;
        }
        else if (value[0] >= 192 && value[0] < 224) {
            arr[3]++;
            //192.168.0.0～192.168.255.255
            if (value[0] == 192 && value[1] == 168)
                arr[7]++;
        }
        else if (value[0] >= 224 && value[0] < 240)
            arr[4]++;
        else if (value[0] >= 240 && value[0] < 256)
            arr[5]++;
        return arr;
    }


    private static boolean validMaskCode(String maskCode) {
        boolean res = true;
        String[] nums = maskCode.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            int n = Integer.valueOf(num);
            sb.append(binaryString(n));
        }
        int firstIndexOf0 = sb.indexOf("0");
        int lastIndexOf1 = sb.lastIndexOf("1");
        if (firstIndexOf0 < lastIndexOf1) {
            res = false;
        }
        return res;
    }
    private static String binaryString(int num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }
}