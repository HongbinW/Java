package basic.IO.Experiment;

import java.io.*;

public class ExperimentCopy {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File src = new File("basicdata.txt");
            File desc = new File("test1.txt");
            FileInputStream fis = new FileInputStream(src);
            InputStreamReader isr = new InputStreamReader(fis);     //可以不用转换直接FileReader和FileWriter
            br = new BufferedReader(isr);
            FileOutputStream fos = new FileOutputStream(desc);
            OutputStreamWriter osr = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osr);
            String str;
            while((str = br.readLine()) != null){
                bw.write(str);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
