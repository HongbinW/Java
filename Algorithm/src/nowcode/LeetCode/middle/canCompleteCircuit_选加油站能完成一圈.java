package nowcode.LeetCode.middle;

public class canCompleteCircuit_选加油站能完成一圈 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length-1;
        int rest = gas[start] - cost[start];
        int cur = (start + 1) % gas.length;
        while (start != cur) {
            while (start != cur && rest < 0) {
                start--;
                rest += gas[start] - cost[start];
            }
            while (start != cur && rest >= 0){
                rest += gas[cur] - cost[cur];
                cur = (cur + 1) % gas.length;
            }
        }
        return rest >=0 ? start : -1;
    }

    public static void main(String[] args) {
        System.out.println(new canCompleteCircuit_选加油站能完成一圈().canCompleteCircuit(new int[]{1,2},new int[]{2,1}));
    }

}
