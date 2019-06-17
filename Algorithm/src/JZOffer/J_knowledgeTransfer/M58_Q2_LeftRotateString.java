package JZOffer.J_knowledgeTransfer;

public class M58_Q2_LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (n > str.length() || n < 0){
            return null;
        }
        String str2 = str.substring(n);
        String str1 = str.substring(0,n);
        return str2 + str1;
    }

    public static void main(String[] args) {
        M58_Q2_LeftRotateString test = new M58_Q2_LeftRotateString();
        System.out.println(test.LeftRotateString("abcdefg",2));
    }
}
