package basic.IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
    RandomAccessFile:支持随机访问
    1.既可以充当输入流，又可以充当输出流
    2.支持从任意位置读取、写入

 */
public class TestRandomAccessFile {
    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try{
        raf1 = new RandomAccessFile(new File("hello.txt"),"r");
        raf2 = new RandomAccessFile(new File("hello1.txt"),"rw");
        byte[] b = new byte[20];
        int len;
        while((len = raf1.read(b)) != -1){
            raf2.write(b);
        }
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            if(raf2 != null) {
                try {
                    raf2.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(raf1 != null) {
                try {
                    raf1.close();
                }catch(Exception e){
                    e.printStackTrace();
            }

            }
        }
    }
    //在任意位置写入（实际上覆盖写入）
    //void seek(long pos)：将文件记录指针定位到 pos 位置
    @Test
    public void test2(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("hello1.txt"),"rw");
            raf.seek(3);    //初始位置是0，则从3开始覆盖写
            raf.write("xy".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf != null){
                try {
                    raf.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    //实现插入效果:在字符d后面插入xy
    @Test
    public void test3(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("hello1.txt"),"rw");
            raf.seek(4);    //初始位置是0，则从3开始覆盖写
            String str = raf.readLine();    //先将d后面的元素给读出来efg,指针会停在最后一个字符的下一个位置
            long l = raf.getFilePointer();
//            System.out.println(l);
            raf.seek(4);
            raf.write("xy".getBytes());
            raf.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf != null){
                try {
                    raf.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    //相较于test3()，（文件更复杂，有多行,会吃掉换行符），更通用些
    @Test
    public void test4(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("hello2.txt"),"rw");
            raf.seek(4);    //初始位置是0，则从3开始覆盖写
            byte[] b = new byte[10];
            int len;
            StringBuffer sb = new StringBuffer(); //可变的字符序列
            while ((len = raf.read(b)) != -1){
                sb.append(new String(b,0,len));
            }
            raf.seek(4);
            raf.write("xy".getBytes());
            raf.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf != null){
                try {
                    raf.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
