package primary.primary7_Greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: HongbinW
 * @Date: 2019/4/30 14:41
 * @Version 1.0
 * @Description:
 */
public class Code05_BestArrange {
    public static class Program{
        public int start;
        public int end;

        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class earlyEnd implements Comparator<Program>{
        @Override
        public int compare(Program p1, Program p2){
            return p1.end - p2.end;
        }
    }

    public static int bestArrange(Program[] programs,int cur){
        Arrays.sort(programs,new earlyEnd());
        int result = 0;
        for(int i = 0; i < programs.length; i++){
            if(cur <= programs[i].start){
                result ++;
                cur = programs[i].end;
            }
        }
        return result;
    }

}
