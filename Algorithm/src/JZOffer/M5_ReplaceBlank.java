package JZOffer;

public class M5_ReplaceBlank {
    private class Q{
        public String ReplaceBlank(String str){
            StringBuilder sb = new StringBuilder();
            if(str.charAt(0) == ' '){
                sb.append("%20");
            }
            String[] strs = str.split(" ");
            for(int i = 0; i < strs.length; i++){
                sb.append(strs[i]);
                if(i != strs.length - 1) {
                    sb.append("%20");
                }
            }
            return sb.toString();
        }
        public char[] ReplaceBlank2(char[] str,int len){
            int count = 0;
            for(int i = 0; i < len; i++){
                if(str[i] == ' '){
                    count ++;
                }
            }
            int rear = len + count * 2 - 1;
            for(int i = len - 1; i >= 0; i--){

                if(str[i] == ' '){
                    str[rear--] = '0';
                    str[rear--] = '2';
                    str[rear--] = '%';
                    continue;
                }
                if(rear >= 0) {
                    str[rear--] = str[i];
                }
            }
            return str;
        }
    }


    public static void main(String[] args) {
        char[] cs = new char[30];
        String str = "We are happy.";
        for(int i = 0; i < str.length(); i++){
            cs[i] = str.charAt(i);
        }
        System.out.println(new M5_ReplaceBlank().new Q().ReplaceBlank(str));
        System.out.println(new M5_ReplaceBlank().new Q().ReplaceBlank2(cs,13));
    }
}
