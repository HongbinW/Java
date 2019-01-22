package basic.IO;

import org.junit.Test;

import java.io.*;

/*
    抽象基类：           节点流（文件流）                缓冲流(处理流的一种，可以提高提升文件操作的效率)
    InputStream          FileInputStream(处理字节)       BufferedInputStream
    OutputStream         FileOutputStream(处理字节)      BufferedOutputStream   (flush())
    Reader               FileReader(处理字符)            BufferedReader         (readLine())
    Writer               FileWriter(处理字符)            BufferedWriter         (flush())
 */
public class TestBuffered {
    //使用BufferedInputStream和BufferedOutputStream实现非文本文件的复制
    @Test
    public void BufferedInputOutputStream(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.提供读入和写出的文件
            File file1 = new File("C:\\Users\\admin\\Desktop\\touxiang.png");
            File file2 = new File("C:\\Users\\admin\\Desktop\\touxiang2.png");
            //2.创建相应的节点流FileInputStream、FileOutputStream
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            //3.将创建的节点流的对象作为形参传递给缓冲流的构造器中
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //4.具体实现文件复制的操作
            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1){
                bos.write(b,0,len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5.关闭相应的流（关闭Buffered的时候，会自动关闭File*****）
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用缓冲流实现文件复制的方法
    public void copyFile(String src,String dest){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.提供读入和写出的文件
            File file1 = new File(src);
            File file2 = new File(dest);
            //2.创建相应的节点流FileInputStream、FileOutputStream
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            //3.将创建的节点流的对象作为形参传递给缓冲流的构造器中
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //4.具体实现文件复制的操作
            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1){
                bos.write(b,0,len);
                bos.flush();//刷新清空一下
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5.关闭相应的流（关闭Buffered的时候，会自动关闭File*****）
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String src = "C:\\Users\\admin\\Desktop\\touxiang.png";
        String dest = "C:\\Users\\admin\\Desktop\\touxiang2.png";
        copyFile(src,dest);
        long end = System.currentTimeMillis();
        System.out.println("花费的时间是：" + (end - start));  //16
    }

    @Test
    public void testBufferedReader(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File file = new File("dbcp.txt");
            File file1 = new File("copydbcp2.txt");
            FileReader fr = new FileReader(file);
            FileWriter fw = new FileWriter(file1);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
//            char[] c = new char[1024];
//            int len;
//            while((len = br.read(c)) != -1){
//                String str = new String(c,0,len);
//                System.out.println(str);
//            }

            String str;
            while((str = br.readLine()) != null){   //每次读一行
//                System.out.println(str);
                bw.write(str);  //未自动换行
                bw.newLine();   //另起一行
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
