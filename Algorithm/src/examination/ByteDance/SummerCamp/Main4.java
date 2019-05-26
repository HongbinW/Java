package examination.ByteDance.SummerCamp;

import java.util.Scanner;
//给松鼠安排房间
//房间是树的形式。i/2为当前节点的父节点
//比如
/*
    1
   2  3
  4 5
 */
//每个节点存放该节点的房间数，从节点间移动的路径都是1，求把所有松鼠安排好房间的最短路径和。
//eg:
// 5 4
// 0 0 4 1 1
// 5 4 2 2
// 输出4
public class Main4 {
    static int minPaths = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int nodes = sc.nextInt();
            int nuts = sc.nextInt();
            int[] rooms = new int[nodes+1];
            int[] location = new int[nuts+1];
            for(int i = 1;i < rooms.length; i++){
                rooms[i] = sc.nextInt();
            }
            for(int i = 1;i < location.length; i++){
                location[i] = sc.nextInt();
                if(rooms[location[i]] > 0){
                    rooms[location[i]] --;
                    location[i] = -1;   //-1表示该松鼠已经安排住宿
                }
            }
            int res = 0;
            for(int i = 1; i < location.length; i++){
                if(location[i] == -1)
                    continue;
                boolean[] valid = new boolean[rooms.length+1];
                res += process(location,rooms,0,location[i],valid);
                minPaths = Integer.MAX_VALUE;
            }
            System.out.println(res);
        }
    }
    public static int process(int[] location, int[] rooms, int paths, int curLocation,boolean[] valid){
        if(curLocation < 1 || curLocation > location.length){
            return Integer.MAX_VALUE;
        }
        valid[curLocation] = true;      //该节点已走过
        if(rooms[curLocation] > 0){
            if(paths < minPaths){   //如果比当前minPaths小，则进入，否则，该节点的房间数没必要-1
            rooms[curLocation]--;
            return paths;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        int temp1 = curLocation/2 > 0 ? valid[curLocation/2] ? Integer.MAX_VALUE : process(location,rooms,paths+1,curLocation/2,valid) : Integer.MAX_VALUE;
        minPaths = Math.min(minPaths,temp1);
        int temp2 = curLocation*2 < valid.length ? valid[curLocation*2] ? Integer.MAX_VALUE : process(location,rooms,paths+1,curLocation*2,valid) : Integer.MAX_VALUE;
        minPaths = Math.min(minPaths,temp2);
        int temp3 = curLocation*2+1 < valid.length ? valid[curLocation*2+1] ? Integer.MAX_VALUE : process(location,rooms,paths+1,curLocation*2+1,valid) : Integer.MAX_VALUE;
        minPaths = Math.min(minPaths,temp3);
        return minPaths;
    }
}
