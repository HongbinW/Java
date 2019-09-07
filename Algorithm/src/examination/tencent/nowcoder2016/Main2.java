package examination.tencent.nowcoder2016;

/**
 * @Author: HongbinW
 * @Date: 2019/9/6 20:40
 * @Version 1.0
 * @Description:
 */
public class Main2 {
    public int getValue(int[] gifts, int n) {
        int count = 1;
        int cur = gifts[0];
        for (int i = 1; i < n; i ++){
            if (gifts[i] == cur){
                count ++;
            }else{
                count --;
                if (count < 0){
                    count = 1;
                    cur = gifts[i];
                }
            }
        }
        return count > 0 ? cur : 0;
    }
}
