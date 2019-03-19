package JZOffer.A_dataStructure;

public class M4_Find {
    private class Q{
        public boolean Find(int[][] arr, int target){
            int i = 0;
            int j = arr[0].length - 1;
            while(i<arr.length && j>=0){
                if(arr[i][j] > target){
                    j--;
                }
                else if(arr[i][j] < target){
                    i++;
                }
                else{
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new M4_Find().new Q().Find(arr,5));
    }
}
