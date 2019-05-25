import java.util.Scanner;

public class Main4 {
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
            }
            System.out.println(res);
        }
    }
    public static int process(int[] location, int[] rooms, int paths, int curLocation,boolean[] valid){
        if(curLocation < 1 || curLocation > location.length){
            return Integer.MAX_VALUE;
        }
        valid[curLocation] = true;
        if(rooms[curLocation] > 0){
            rooms[curLocation]--;
            return paths;
        }
        int temp1 = valid[curLocation/2] ? Integer.MAX_VALUE : process(location,rooms,paths+1,curLocation/2,valid);
        int temp2 = curLocation*2 < valid.length ? valid[curLocation*2] ? Integer.MAX_VALUE : process(location,rooms,paths+1,curLocation*2,valid) : Integer.MAX_VALUE;
        int temp3 = curLocation*2+1 < valid.length ? valid[curLocation*2+1] ? Integer.MAX_VALUE : process(location,rooms,paths+1,curLocation*2+1,valid) : Integer.MAX_VALUE;
        int mintemp = Math.min(temp1,temp2);
        return Math.min(temp3,mintemp);
    }
}
