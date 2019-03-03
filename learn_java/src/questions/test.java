package questions;

public class test {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Hello World");
        System.out.println(replaceSpace(str));


    }
    public static String replaceSpace(StringBuffer str) {
        int[] nums = new int[str.length()];
        int j = 0;
        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) == ' '){
                nums[j++] = i;
            }
        }
        for(int i = j - 1; i >= 0; i--){
            str.replace(nums[i],nums[i] + 1 ,"%20");

        }
        String res = str.substring(0,str.length());
        return res;
    }
}
