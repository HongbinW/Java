package nowcode.LeetCode;


import java.util.HashMap;

//https://www.nowcoder.com/practice/bfc691e0100441cdb8ec153f32540be2?tpId=46&tqId=29032&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking
class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
}
public class maxPoints_最多多少点在一条直线上 {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0){
            return 0;
        }
        int res = 1;
        for (int i = 0; i < points.length; i ++){
            res = Math.max(res, process(points,i));
        }
        return res;
    }
    public int process(Point[] points, int start){
        int res = 1;
        int sameX = 1;
        int duplicate = 0;
        HashMap<Double,Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i ++){
            if (i == start)
                continue;
            if (points[start].x == points[i].x){
                if (points[start].y == points[i].y){
                    duplicate++;
                }else {
                    sameX++;
                }
                continue;
            }
            double k = (double)((points[i].y - points[start].y)) / (points[i].x - points[start].x);
            if (map.containsKey(k)){
                map.put(k,map.get(k)+1);
            }else{
                map.put(k,2);
            }
        }
        for (int i : map.values()){
            res = Math.max(res,i);
        }
        res = Math.max(res,sameX);
        return res + duplicate;
    }

    public static void main(String[] args) {
        //(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)]
        Point[] points = new Point[9];

        points[0] = new Point(0,0);
        points[1] = new Point(1,0);
        points[2] = new Point(0,-70);
        points[3] = new Point(0,-70);
        points[4] = new Point(1,-1);
        points[5] = new Point(21,10);
        points[6] = new Point(42,90);
        points[7] = new Point(-42,-230);
        points[8] = new Point(84,250);
        System.out.println(new maxPoints_最多多少点在一条直线上().maxPoints(points));


    }
}
