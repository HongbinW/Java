package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/3/18
 */
public class LeetCode836_isRectangleOverlap_矩形重叠 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]){
            return false;
        }
        //
        if((rec1[0] < rec2[0] && rec1[2] <= rec2[0]) || (rec1[0] >= rec2[2] && rec1[2] > rec2[2]) ||
                (rec1[1] < rec2[1] && rec1[3] <= rec2[1]) || (rec1[1] >= rec2[3] && rec1[3] > rec2[3])){
            return false;
        }

        return true;
    }
}
