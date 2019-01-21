package basic.IO;
/*
    1.流的分类
    按照流向的不同：输入流 输出流
    按照处理数据单位的不同：字节流 字符流（处理的文本文件）
    按照角色的不同：节点流（直接处理文件） 处理流（除了节点流）
    2.IO体系
    抽象基类：           节点流（文件流）
    InputStream          FileInputStream(处理字节)
    OutputStream         FileOutputStream(处理字节)
    Reader               FileReader(处理字符)
    Writer               FileWriter(处理字符)
 */

import org.junit.Test;

import java.io.*;

public class TestFileInputOutputStream {
    //从硬盘存在的一个文件中，读取内容到程序中，使用FileInputStream
    //要读取的文件一定要存在，否则抛FileNotFoundException
    @Test
    public void testFileInputStream1() throws FileNotFoundException,IOException {
        //1.创建一个File类的对象
        File file = new File("hello.txt");
        //2.创建一个FileInputSteam类的对象
        FileInputStream fis = new FileInputStream(file);
        //3.调用FileInputStream的方法，实现file文件的读取
        /**
         * read():读取文件一个字节，当执行到文件结尾时，返回-1  abcdefg
         */
//        int b = fis.read();
//        while (b != -1){
//            System.out.println((char)b);
//            b = fis.read();
//        }
        int b;
        while ((b = fis.read()) != -1){
            System.out.println((char)b);
        }
        //4.关闭相应的流
        fis.close();

    }
    //使用try-catch的方式处理如下异常更合理,保证流的关闭操作一定能执行
    @Test
    public void testFileInputStream2(){
        FileInputStream fis = null;
        try {
            //1.创建一个File类的对象
            File file = new File("hello.txt");
            //2.创建一个FileInputSteam类的对象
            fis = new FileInputStream(file);
            //3.调用FileInputStream的方法，实现file文件的读取
            int b;
            while ((b = fis.read()) != -1) {
                System.out.println((char) b);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (fis != null) {
                try {
                    //4.关闭相应的流
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //按数组读取一定长度的字节
    @Test
    public void TestFileInputSream3(){
        FileInputStream fis = null;
        try{
            File file = new File("hello.txt");
            fis = new FileInputStream(file);
            byte[] b = new byte[5];        //读取到的数据要写入的数组
            int len;                        //记录每次实际读入到byte中字节的长度
            while ((len = fis.read(b)) != -1){  //读取b.length长度的数据写入b数组，返回写进去的个数
//                for(int i =0; i < len; i++){    //此处应该用len而不是b.length，因为可能最后一次没读入b.length的数据，
//                                                // 那原来的数据依然会保留在b[]数组中
//                    System.out.print((char)b[i]);
//                }
//                System.out.println(len);
                String str = new String(b,0,len);   //将数组转化为字符串，此处也要区分len和b.length
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fis != null) {  //防止空指针
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //OutputStream
    //输出的物理文件可以不存在，当执行过程中，若不存在，会自动创建，若存在会将原有文件覆盖（全覆盖）。
    @Test
    public void TestFileOutputStream1(){
        //1.创建一个File对象，表明要写入的文件位置
        File file = new File("hello2.txt");
        //2.创建一个FileOutputStream的对象，将File对象作为形参传递给FileOutputStream的构造器中
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            //3.写入的操作
            fos.write(new String("I love China and the World!").getBytes());    //将字符串转为字节数组

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4.关闭输出流
            if(fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //FileInputStream&FileOutputStream
    //从硬盘读取一个文件，并写入到另一个位置（相当于文件的复制）
    @Test
    public void TestFileInputOutputStream(){
        //1.提供读入和写出的文件
        File file1 = new File("C:\\Users\\admin\\Desktop\\touxiang.png");
        File file2 = new File("C:\\Users\\admin\\Desktop\\touxiang2.png");
        //2.提供相应的流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            //3.实现文件的赋值
            byte[] b = new byte[5];
            int len;
            while((len = fis.read(b)) != -1){
                fos.write(b,0,len);
                //fos.write(b) 等同于fos.write(b,0,b.length)都是错误的
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis != null && fos != null){
                try {
                    fis.close();
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

    public static void copyFile(String src, String dest){
        //1.提供读入和写出的文件
        File file1 = new File(src);
        File file2 = new File(dest);
        //2.提供相应的流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            //3.实现文件的赋值
            byte[] b = new byte[5];     //5可自己调节，来调整速度
            int len;
            while((len = fis.read(b)) != -1){
                fos.write(b,0,len);
                //fos.write(b) 等同于fos.write(b,0,b.length)都是错误的
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis != null && fos != null){
                try {
                    fis.close();
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testcopy(){
        long start = System.currentTimeMillis();
        copyFile("C:\\Users\\admin\\Desktop\\touxiang.png","C:\\Users\\admin\\Desktop\\touxiang3.png");
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为" + (end - start));
    }
}
