package basic.forkJoin;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * 计算1+2+3+。。。+n
 */
public class forkJoinDemo1 extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2; //阈值
    private int start;
    private int end;

    public forkJoinDemo1(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean can = end - start <= THRESHOLD;
        return sum;
    }

    public static void main(String[] args) {
        ConcurrentHashMap map;
    }
}
