package basic.IO.Experiment;

import java.io.*;

public class ExperimentRead {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            File file = new File("test.txt");
//            FileInputStream fis = new FileInputStream(file);
//            InputStreamReader isr = new InputStreamReader(fis);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null){
                System.out.println(str);
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
}
