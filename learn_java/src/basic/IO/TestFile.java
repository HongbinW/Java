package basic.IO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/*
    java.io.File类
    1.凡是与输入输出相关的类、接口都定义在java.io包下
    2.File是一个类，可以有构造器创建其对象，此对象对应着一个文件或文件目录
    3.File对象是与平台无关的
    4.File中的方法，仅涉及到如何创建、删除、重命名等。只要涉及到文件内容的，File是不可以的，必须由IO流来完成
    5.File类的对象常作为IO流的具体类的构造器的形参。（将该文件作为一个对象来操作，File可以用来指明对象）
 */
public class TestFile {
    /*
        路径：
        绝对路径：包括盘符在内的完整的文件路径
        相对路径：在当前文件目录下的文件路径

        访问文件名相关
        getName():获取文件名
        getPath()
        getAbsoluteFile()
        getAbsolutePath()
        getParent()
        renameTo(File newName)

     */
    @Test
    public void test1(){
//        File file1 = new File("J:\\io\\hello.txt");           //绝对路径
        File file1 = new File("J:/io/hello.txt");   //两种方式
        File file2 = new File("hello.txt");         //相对路径
        File file3 = new File("J:/io/io1");         //文件目录
        File file4 = new File("J:/io2");
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getParent());

        System.out.println();
        System.out.println(file3.getName());
        System.out.println(file3.getPath());
        System.out.println(file3.getAbsoluteFile());
        System.out.println(file3.getAbsolutePath());
        System.out.println(file3.getParent());

        //renameTo(File newName):重命名
        //file1.renameTo(file2):file1重命名为file2，要求：file1文件一定存在，file2一定不存在
        //返回boolean类型。file1和file2的类型要一致，即文件就都文件，目录就都目录
        file1.renameTo(new File("helloworld.txt"));
        System.out.println(file1.getName());
        //重命名后，原文件删除，新命名后的文件直接放到了file2位置(现工程)下
        boolean b = file4.renameTo(file3);
        System.out.println(b);
    }

    //文件检测 和 获取常规文件信息
    /*
    exists()
    canWrite()
    canRead()
    isFile()
    isDirectory()

    lastModified():最后修改时间
    length()
     */
    @Test
    public void test2(){
        File file1 = new File("J:/io/hello.txt");   //两种方式
        File file2 = new File("J:/io/io1");         //文件目录
        System.out.println(file1.exists());
        System.out.println(file1.canWrite());
        System.out.println(file1.canRead());
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        System.out.println(new Date(file1.lastModified()));
        System.out.println(file1.length());
        System.out.println();
        System.out.println(file2.exists());
        System.out.println(file2.canWrite());
        System.out.println(file2.canRead());
        System.out.println(file2.isFile());
        System.out.println(file2.isDirectory());
        System.out.println(new Date(file2.lastModified()));
        System.out.println(file2.length());

    }

    //文件操作 和 目录操作
    /*
    createNewFile()
    delete()：可删除文件和目录

    mkDir()：单层目录创建
    mkDirs()：多层目录创建
    list():将该目录下的文件名以字符串数组的形式保存
    listFiles()：同上但以file对象的形式保存，之后可对这些文件进一步操作，而list()只是保存这些文件的名字
     */
    @Test
    public void test3() throws IOException {
        File file1 = new File("J:/io/hello.txt");
        System.out.println(file1.delete());
        if(!file1.exists()){
            boolean b = file1.createNewFile();
            System.out.println(b);
        }
        File file2 = new File("J:/io/io2");
        if(!file2.exists()){
            boolean b = file2.mkdir();  //就按照声明file2时的路径和名字来
            System.out.println(b);
        }
        File file3 = new File("J:/io1/io2");
        if(!file3.exists()){
            boolean b = file3.mkdirs();
            System.out.println(b);
        }

        File file4 = new File("C:\\Users\\admin\\Java");
        String[] strs = file4.list();
        for(int i = 0;i < strs.length;i++){
            System.out.println(strs[i]);
        }
        System.out.println();
        File[] files = file4.listFiles();
        for(int i = 0; i < files.length; i++){
            System.out.println(files[i].getName());
        }
    }
}
