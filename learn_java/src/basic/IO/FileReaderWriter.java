package basic.IO;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderWriter {
    @Test
    public void testFileReader(){
        FileReader fr = null;
        try {
            File file = new File("dbcp.txt");
            fr = new FileReader(file);
            char[] c = new char[24];
            int len;
            while ((len = fr.read(c)) != -1) {
                String str = new String(c, 0, len);
                System.out.print(str);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //使用FileReader FileWriter 可以实现文本文件的复制
    //对于非文本文件，只能使用字节流
    @Test
    public void testFileReaderWriter(){
        //1.输入流对应的文件src一定要存在，否则抛异常。输出流对应的文件dest可以不存在，执行过程中会自动创建
        FileReader fr = null;
        FileWriter fw = null;
        try{
            File src = new File("dbcp.txt");
            File dest = new File("copydbcp.txt");
            fr = new FileReader(src);
            fw = new FileWriter(dest);
            char[] c = new char[20];
            int len;
            while ((len = fr.read(c)) != -1){
                String str = new String(c,0,len);
                fw.write(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fr != null){
                try{
                    fr.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(fw != null){
                try{
                    fw.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
