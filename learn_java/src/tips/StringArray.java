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
    //From TestFileInputOutputStream
    @Test
    public void test2(){
        byte[] b = new byte[5];
        int len = 3;
        String str = new String(b,0,len);   //将数组转化为字符串，此处也要区分len和b.length
    }
}
