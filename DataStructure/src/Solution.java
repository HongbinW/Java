public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = 21;
        for(int i = 0 ; i < n; i++){
            sb.append("*");
        }
        for(int i = 0; i < n/2+1 ; i++){
            System.out.println(sb);
            sb.setCharAt(i,' ');
            sb.setCharAt(sb.length()-1-i,' ');
        }
    }
}