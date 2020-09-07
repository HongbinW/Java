package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/8
 */
public class LeetCode990_equationsPossible_等式方程的可满足性 {
    public boolean equationsPossible(String[] equations) {
        int[] arr = new int[26];
        boolean flag = true;
        int index = 1;
        for(int i = 0; i < equations.length; i ++){
            char a = equations[i].charAt(0);
            char b = equations[i].charAt(3);
            if(equations[i].substring(1,3).equals("==")){
                if(arr[a - 'a'] != 0 && arr[b - 'a'] != 0){
                    if(arr[a - 'a'] == arr[b - 'a']){
                        continue;
                    }else{
                        flag = false;
                        break;
                    }
                }else if (arr[a - 'a'] == 0 && arr[b - 'a'] == 0){
                    arr[a-'a'] = index;
                    arr[b-'a'] = index++;
                }else if (arr[a-'a'] == 0){
                    arr[a-'a'] = arr[b-'a'];
                }else{
                    arr[b-'a'] = arr[a-'a'];
                }
            }else{
                if(arr[a - 'a'] != 0 && arr[b - 'a'] != 0){
                    if(arr[a - 'a'] != arr[b - 'a']){
                        continue;
                    }else{
                        flag = false;
                        break;
                    }
                }else if (arr[a - 'a'] == 0 && arr[b - 'a'] == 0){
                    arr[a-'a'] = index++;
                    arr[b-'a'] = index++;
                }else if (arr[a-'a'] == 0){
                    arr[a-'a'] = index ++;
                }else{
                    arr[b-'a'] = index ++;
                }
            }
        }
        return flag;
    }
}
