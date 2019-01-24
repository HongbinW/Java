package tips;

import org.junit.Test;

public class StringArray {
    //From TestFileInputOutputStream
    @Test
    public void test1(){
        byte[] b = new String("I love China and the World!").getBytes();    //将字符串转为字节数组
        for(int i = 0; i < b.length; i++){
            System.out.print((char)b[i]);
        }
    }
    //str.toCharArray()转为字符数组

    //From TestFileInputOutputStream
    @Test
    public void test2(){
        byte[] b = new byte[5];
        int len = 3;
        String str = new String(b,0,len);   //将数组转化为字符串，此处也要区分len和b.length
    }
    //检查是否是回文数
    //检查前一半和后一半的反转是否相同
    //关键点在于，怎么知道已经反转了一半：通过比较前一半和后一半的大小，如果前一半小于后一半了，说明已经到半了
    @Test
    public void test3(){
        int x = 21;
        if(x < 0 || (x % 10 == 0 && x != 0))
            System.out.println(0);
        int rev = 0;
        while(rev < x){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        System.out.println(rev == x || rev / 10 == x);

    }

}
