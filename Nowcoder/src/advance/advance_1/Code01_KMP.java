package advance.advance_1;

public class Code01_KMP {

    public static int process_KMP(String str1,String str2){
        int i = 0;
        int index = 0;
        int[] next = maxlengPreEqPos(str2);
        while(i < str1.length() && index < str1.length()){
            if(str1.charAt(i) == str2.charAt(index)){
                i ++ ;
                index ++;
            }
            else if(next[index] == -1){ //在str2的0位置的字符，即第一个字符也不匹配
                i++;
            }else{
                index = next[index];
            }
        }
        return index == str2.length() ? i - index : -1; //若index跑完了str2，则返回在str1中第一次完全匹配的初始位置，若没跑完则返回-1，相当于indexOf函数
    }
    public static int[] maxlengPreEqPos(String str){
        if(str.length() == 1){
            return new int[]{-1};
        }
        int[] arr = new int[str.length()];
        arr[0] = -1;
        arr[1] = 0;
        int i = 2;  //现在来到的位置
        int cn = 0; //跳到的位置
        while(i < arr.length){
            if(str.charAt(i-1) == str.charAt(cn)){
                arr[i++] = ++cn;
            }else if(cn > 0){   //不等,且还可以往前跳
                cn = arr[cn];
            }else{      //跳到头了
                arr[i++] = 0;
            }
        }
        return arr;
    }
}
