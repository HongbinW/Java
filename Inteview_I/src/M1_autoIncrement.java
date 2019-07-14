public class M1_autoIncrement {
    public static void main(String[] args) {
        int i = 1;
        i = i ++;
        int j = i ++;
        int k = i + ++i * i++;
        System.out.println("i = " + i);
        System.out.println("j = " + k);
        System.out.println("k = " + k);
    }
}


