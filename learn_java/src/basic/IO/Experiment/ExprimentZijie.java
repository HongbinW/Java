package basic.IO.Experiment;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//使用字节操作
public class ExprimentZijie {
    @Test
    public void test1(){
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(new File("test3.txt")));
            String str = "Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于\" +\n" +
                    "                    \" 1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有\" +\n" +
                    "                    \" 卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级\" +\n" +
                    "                    \" 计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算和移动互联网的产业\" +\n" +
                    "                    \" 环境下，Java更具备了显著优势和广阔前景。";
            bos.write(str.getBytes());
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){

    }
}
