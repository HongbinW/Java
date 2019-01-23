package basic.IO;

import org.junit.Test;

import java.io.*;

public class TestOtherStream {
    /*
        转换流：InputStreamReader   OutputStreamWriter
        解码：字节数组---->字符串
        编码：字符串---->字节数组

        System.in 是字节流
     */
    @Test
    public void test1() {
        BufferedReader br = null;//进一步提升效率
        BufferedWriter bw = null;
        try {
            //解码
            File file1 = new File("dbcp.txt");
            FileInputStream fis = new FileInputStream(file1);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(isr);
            //编码
            File file2 = new File("copydbcp3.txt");

            FileOutputStream fos = new FileOutputStream(file2);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");  //字符输出流
            bw = new BufferedWriter(osw);
            /**
             * ***********question*****不应该是字节流输出么？
             * 1、字符的输出需要通过字符流来操作，但是本质最后还是通过字节流输出到计算机上进行存储的
             *
             * 2、 因此OutputStreamWriter流的作用就是利用字节流作为底层输出流然后构建字符输出流，
             * 字符输出流输出字符到流中，然后通过指定的字符集把流中的字符编码成字节输出到字节流中，
             * 其作用就是一个桥梁，使得双方链接起来
             *
             * 通常就是将OutputStreamWriter和BufferedWriter连起来用
             */


//            FileWriter fw = new FileWriter(file2);
//            bw = new BufferedWriter(fw);
//            OutputStreamWriter osw = new OutputStreamWriter(bw);


            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //标准的输入输出流:
    //标准的输入流：System.in
    //标准的输出流：System.out

    /**
     * 例：
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。
     * 然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。
     */
    @Test
    public void test2(){
        BufferedReader br = null;        //使用带缓冲的字符流
        try {
            InputStream is =  System.in;
            InputStreamReader isr = new InputStreamReader(is);  //转为字符流
            br = new BufferedReader(isr);
            String str;
            while (true){
                System.out.println("请输入字符串：");
                str = br.readLine();
                if(str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit"))//忽略大小写
                break;
                String str1 = str.toUpperCase();//转大写
                System.out.println(str1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //打印流：字节流PrintStream    字符流PrintWriter

    @Test
    public void printStreamWriter(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("print.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }//创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
        PrintStream ps = new PrintStream(fos,true);
        if (ps != null) {	// 把标准输出流(控制台输出)改成文件(打印流指定的文件)
            System.setOut(ps);}
        for (int i = 0; i <= 255; i++) {  //输出ASCII字符
            System.out.print((char)i);
            if (i % 50 == 0) {   //每50个数据一行
                System.out.println(); // 换行
            }  }
        ps.close();

    }
    //数据流：用来处理基本数据类型、String、字节数组的数据:DataInputStream     DataOutputStream
    @Test
    public void testData(){
        DataOutputStream dos = null;
        try {
            FileOutputStream fos = new FileOutputStream("data.txt");
            dos = new DataOutputStream(fos);

            dos.writeUTF("字符串");
            dos.writeBoolean(true);
            dos.writeLong(12345679);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dos != null ) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testData1(){
        DataInputStream dis = null;
        try{
            dis = new DataInputStream(new FileInputStream(new File("data.txt")));
//            byte[] b = new byte[20];
//            int len;
//            while ((len = dis.read(b)) != -1){
//                System.out.println(new String(b,0,len));
//            }
            String str =  dis.readUTF();
            System.out.println(str);
            boolean b = dis.readBoolean();
            System.out.println(b);
            long l = dis.readLong();
            System.out.println(l);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(dis != null){
                try{
                    dis.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}
