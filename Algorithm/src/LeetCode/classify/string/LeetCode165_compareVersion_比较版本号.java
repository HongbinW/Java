package LeetCode.classify.string;

public class LeetCode165_compareVersion_比较版本号 {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index = 0;
        while (index < Math.max(v1.length,v2.length)){
            int a = 0, b = 0;
            if (index < v1.length) {
                a = Integer.parseInt(v1[index]);
            }
            if (index < v2.length) {
                b = Integer.parseInt(v2[index]);
            }
            if (a > b){
                return 1;
            }else if (a < b){
                return -1;
            }else{
                index ++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0","1.1"));
    }
}
