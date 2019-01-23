package basic.IO.Experiment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 分别使用字节流和字符流完成以下程序：

 1. 在指定的路径下新建一个 .txt 文件 "basicdata.txt"，利用程序在文件中写入如下内容：

 "Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于
 1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有
 卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级
 计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算和移动互联网的产业
 环境下，Java更具备了显著优势和广阔前景。"

 2. 利用程序读取 basicdata.txt 文件的内容, 并在控制台打印

 3. 利用程序复制 basicdata.txt 为 test1.txt

 */
public class ExperimentWrite {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            FileWriter fw = null;
            File file = new File("Test.txt");
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            String str = "Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于" +
                    " 1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有" +
                    " 卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级" +
                    " 计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算和移动互联网的产业" +
                    " 环境下，Java更具备了显著优势和广阔前景。";
            bw.write(str);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
