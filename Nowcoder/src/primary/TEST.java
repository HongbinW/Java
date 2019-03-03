package primary;

import org.junit.Test;

public class TEST {
    @Test
    public void test1(){
        int[][] arr = new int[3][4];
        System.out.println(arr.length);
        System.out.println(arr[0].length);
    }
}

//    int len = array[0].length - 1;
//    int L = 0;
//    int col;
//        while(L <= len){
//                int mid = (len + L) / 2;
//                if(array[0][mid] > target){
//                len = mid - 1;
//                }else if(array[0][mid] < target){
//        L = mid + 1;
//        }else{
//        col = mid;
//        return true;
//        }
//        }
//        col = L;
//        L = 0;
//        len = array[0].length - 1;
//        while(L <= len){
//        int mid = (len + L) / 2;
//        if(array[mid][col] > target){
//        len = mid - 1;
//        }else if(array[mid][col] < target){
//        L = mid + 1;
//        }else{
//        return true;
//        }
//        }
//        return false;