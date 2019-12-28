package Zuo100.c8_bytedance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q3_arrangePM {
    public static class Idea {
        int samNum;
        int PMNum;
        int start;
        int cost;
        int priority;
        int finishTime;

        public Idea(int samNum, int PMNum, int start, int priority, int cost){
            this.PMNum = PMNum;
            this.start = start;
            this.cost = cost;
            this.priority = priority;
        }
    }
    public static class PM{
        int PMNum;
        PriorityQueue<Idea> pmQueue;
        public PM(int PMNum){
            this.PMNum = PMNum;
            this.pmQueue = new PriorityQueue<>(new PMComparator());
        }
    }

    public static class PMComparator implements Comparator<Idea>{
        @Override
        public int compare(Idea o1, Idea o2) {
            if (o1.priority > o2.priority){
                return -1;
            }else if (o1.priority < o2.priority){
                return 1;
            }else if (o1.cost < o2.cost){
                return -1;
            }else if (o1.cost > o2.cost){
                return 1;
            }else if (o1.start < o2.start){
                return -1;
            }else{
                return 1;
            }
        }
    }
    public static class CdeComparator implements Comparator<Idea>{
        @Override
        public int compare(Idea o1, Idea o2) {
            if (o1.cost < o2.cost){
                return -1;
            }else if (o1.cost > o2.cost){
                return 1;
            }else if (o1.PMNum < o2.PMNum){
                return -1;
            }else{
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int P = sc.nextInt();
            PM[] pm = new PM[N];
            PriorityQueue<Idea> timeQueue = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
            ArrayList<Idea> ideas = new ArrayList<>();
            for (int i = 0; i < P; i ++){
                int index = sc.nextInt();
                ideas.add(new Idea(i,index,sc.nextInt(),sc.nextInt(),sc.nextInt()));
            }
            for (int i = 0; i < ideas.size(); i ++){
                timeQueue.add(ideas.get(i));
            }
            PriorityQueue<Idea> sdeQueue = new PriorityQueue<>(new CdeComparator());
            PriorityQueue<Integer> sdeTime = new PriorityQueue<>();
            for (int i = 0; i < M; i ++){
                sdeTime.add(1);
            }
            while (!timeQueue.isEmpty() || !sdeQueue.isEmpty()){
                int cur = sdeTime.poll();
                if (!timeQueue.isEmpty() && cur < timeQueue.peek().start && sdeQueue.isEmpty()){
                    cur = timeQueue.peek().start;
                    sdeTime.add(cur);
                    continue;
                }
                while (!timeQueue.isEmpty() && timeQueue.peek().start <= cur){
                    Idea idea = timeQueue.poll();
                    if (pm[idea.PMNum - 1] == null){
                        pm[idea.PMNum - 1] = new PM(idea.PMNum);
                    }
                    pm[idea.PMNum - 1].pmQueue.add(idea);
                }
                for (int i = 0; i < N; i ++){
                    if (!pm[i].pmQueue.isEmpty()){
                        sdeQueue.add(pm[i].pmQueue.poll());
                    }
                }
                Idea tmp = sdeQueue.poll();
                tmp.finishTime = cur + tmp.cost;
                sdeTime.add(tmp.finishTime);
            }
            for (int i = 0; i < ideas.size(); i ++){
                System.out.println(ideas.get(i).finishTime);
            }
        }
    }
}

//2 2 5
//1 1 1 2
//1 2 1 1
//1 3 2 2
//2 1 1 2
//2 3 5 5