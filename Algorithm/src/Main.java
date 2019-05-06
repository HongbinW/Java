import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int[][] arr = new int[9][9];
            ArrayList<Integer> zero = new ArrayList<>();
            for(int i = 0 ; i < 9; i++){
                for(int j = 0; j < 9 ; j++){
                    arr[i][j] = sc.nextInt();
                    if(arr[i][j] == 0){
                        zero.add(i);
                        zero.add(j);
                    }
                }
            }
            process(arr,zero,0);
            for(int i = 0 ;i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(arr[i][j]);
                    if(j != 8){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
    public static ArrayList<Integer> likelyAnswer(int[][] arr, int i, int j){
        int row = i / 3;
        int col = j / 3;
        int[] has1 = new int[10];
        int[] has2 = new int[10];
        for(int m = 0; m < 9; m++){
            has1[arr[i][m]]++;
            has2[arr[m][j]]++;
        }
        int[] has3 = new int[10];
        for(int m = row; m < row + 3; m ++){
            for(int n = col; n < col + 3; n++){
                has3[arr[m][n]] ++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int m = 1;m < 10; m++){
            if(has1[m] > 1 || has2[m] > 1 || has3[m] > 1){
                return null;
            }
            int res = has1[m]+has2[m]+has3[m];
            if(res == 0){
                list.add(m);
            }
        }
        return list;
    }

    public static void process(int[][] arr,ArrayList<Integer> zero,int index){
        if(index == zero.size()){
            return;
        }
        int i = zero.get(index++);
        int j = zero.get(index++);
        ArrayList<Integer> list = likelyAnswer(arr,i,j);
        if(list == null){
            return;
        }
        for(int m = 0; m < list.size(); m++){
            arr[i][j] = list.get(m);
            process(arr,zero,index);
        }
        process(arr,zero,index);
    }
}
/*
8 0 0 0 0 0 0 0 0
0 7 0 0 9 0 2 0 0
0 0 3 6 0 0 0 0 0
0 5 0 0 0 7 0 0 0
0 0 0 0 4 5 7 0 0
0 0 0 1 0 0 0 3 0
0 0 1 0 0 0 0 6 8
0 0 8 5 0 0 0 1 0
0 9 0 0 0 0 4 0 0
 */