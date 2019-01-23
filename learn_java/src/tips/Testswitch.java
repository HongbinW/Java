package tips;

public class Testswitch {
    public static void main(String[] args) {
        String str = "AABBCCAB";
        int countA = 0;
        int countB = 0;
        int countC = 0;
        byte[] b = str.getBytes();
        for(int i = 0; i < b.length; i ++){
            switch (b[i]){
                case 'A':
                    countA++;
                    break;
                case 'B':
                    countB++;
                    break;
                case 'C':
                    countC++;
                    break;
            }
        }
        System.out.println(countA);
        System.out.println(countB);
        System.out.println(countC);
    }
}
