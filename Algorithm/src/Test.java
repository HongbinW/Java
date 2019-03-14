public class Test {
    public static void main(String[] args) {
        char[] cs = new char[30];
        String str = "We are happy.";
        for(int i = 0; i < str.length(); i++){
            cs[i] = str.charAt(i);
        }
        int count = 0;
        for(int i = 0; i < cs.length; i++){
            if(cs[i] != ' '){
                count ++;
            }
        }
        System.out.println(count);
        System.out.println(cs[20] == '\u0000');
    }
}
