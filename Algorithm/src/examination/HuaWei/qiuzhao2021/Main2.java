package examination.HuaWei.qiuzhao2021;
import java.util.Arrays;
import java.util.Scanner;

public class Main2{
    static class Driver{
        int id;
        int time;
        int level;
        Driver(int id, int time, int level){
            this.id = id;
            this.time = time;
            this.level = level;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lucheng = sc.nextLine().split(",");
        String[] yongdu = sc.nextLine().split(",");
        String[] ludeng = sc.nextLine().split(",");
        String[] levelStr = sc.nextLine().split(",");
        Driver[] drivers = new Driver[lucheng.length];
        for (int i = 0; i < lucheng.length; i ++){
            int totalLen = Integer.parseInt(lucheng[i]);
            int duLen = Integer.parseInt(yongdu[i]);
            int light = Integer.parseInt(ludeng[i]);
            int level = Integer.parseInt(levelStr[i]);
            int time = (int)(duLen / 2 + (totalLen - duLen) / 10 + (int)(light * 0.5) * 15);
            drivers[i] = new Driver(i+1,time,level);
        }
        Arrays.sort(drivers, (o1, o2) -> o1.time == o2.time ? o2.level - o1.level : o1.time - o2.time);
        int resTime = drivers[0].time;
        int resId = drivers[0].id;
        int resLevel = drivers[0].level;
        for(int i = 1; i < drivers.length; i ++){
            if (drivers[i].level > resLevel && drivers[i].time - 60 < resTime){
                resTime = drivers[i].time;
                resId = drivers[i].id;
                resLevel = drivers[i].level;
            }
        }
        System.out.println(resId + "," + resTime);
    }
}