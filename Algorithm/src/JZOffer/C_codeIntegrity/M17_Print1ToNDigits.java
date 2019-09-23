package JZOffer.C_codeIntegrity;

/**
 * @Author: HongbinW
 * @Date: 2019/3/18 15:40
 * @Version 1.0
 */
public class M17_Print1ToNDigits {
    //单从时间复杂度上讲，自己的算法更快
    public void Print1ToNDigits(int n){
        StringBuilder sb = new StringBuilder();
        while(n >= 0){
            sb.append(0);
            n--;
        }
        Increment(sb);
    }
    public void Increment(StringBuilder str){
        int curBit = str.length() - 1;
        int carry = 0;
        int com = str.length() - 1;
        while(str.charAt(0) != '1'){
            str.setCharAt(curBit,(char)(str.charAt(curBit) + 1 + carry));
            if(str.charAt(curBit) >= 10 + '0') {
                while (str.charAt(curBit) >= 10 + '0') {
                    if(str.charAt(com) >= 10 + '0') {
                        com--;
                    }
                    str.setCharAt(curBit, '0');
                    curBit--;
                    carry = 1;
                    str.setCharAt(curBit, (char) (str.charAt(curBit) + carry));
                    if(str.charAt(curBit) >= 10 + '0'){     //如果当前位是冒号，而再前面的位都是9，则需要多次运算
                        continue;
                    }
                    System.out.println(str.substring(com,str.length()));
                    carry = 0;
                }
                curBit = str.length() - 1;
                continue;
            }
            System.out.println(str.substring(com,str.length()));
        }
    }

    //Solution2
    //打印1到最大的n位数的主方法
    public void printToMaxOfDigits(int n){
        if(n <= 0){
            System.out.println("输入的n没有意义");
            return;
        }
        char number[] = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        for (int i = 0; i < 10; ++i) {      //最高位0~9
            number[0] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, 0);
        }
    }
    //利用递归实现1到最大的n位数的全排列
    public void printToMaxOfNDigitsRecursively(char[] number, int n, int index) {
        if(index == n - 1){
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; ++i) {      //从最低位到第二高位，顺序加1，递归顺序为从第二高位到最低位
            number[index + 1] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, index + 1);
        }
    }

    //输出
    private void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if(isBeginning0 && number[i]!='0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        M17_Print1ToNDigits test = new M17_Print1ToNDigits();
        long start1 = System.currentTimeMillis();
        test.Print1ToNDigits(2);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        test.printToMaxOfDigits(3);
        long end2 = System.currentTimeMillis();

        System.out.println("my solution" + (end1 - start1));
        System.out.println("authority solution" + (end2 - start2));
    }
}
