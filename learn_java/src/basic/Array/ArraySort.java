package basic.Array;
//插入排序  直接插入排序、折半插入排序、Shell排序
//交换排序  冒泡排序、快速排序（或分区交换排序）
//选择排序  简单选择排序、堆排序
//归并排序
//基数排序

//(1)若n较小(如n≤50)，可采用直接插入或直接选择排序。当记录规模较小时，直接插入排序较好；
//   否则因为直接选择移动的记录数少于直接插入，应选直接选择排序为宜。
//(2)若文件初始状态基本有序(指正序)，则应选用直接插入、冒泡或随机的快速排序为宜；
//(3)若n较大，则应采用时间复杂度为O(nlgn)的排序方法：快速排序、堆排序或归并排序。
import java.util.Arrays;


public class ArraySort {
    public static void main(String[] args){
        int[] arr = new int[]{12,43,9,0,-65,-99,100,9};
        int[] arr2 = new int[]{12,43,9,0,-65,-99,100,9};
        int temp;
//冒泡排序：
//        相邻两元素进行比较，如有需要则进行交换，每完成一次循环就将最大元素排在最后（如从小到大排序），
//        下一次循环是将其它的数进行类似操作。
        for(int j = 0;j < arr.length-1; j++) {
            for (int i = 0; i < arr.length - j-1; i++) {
                //暂定从小打到，如果从大到小，就把下一行的 > 换 < 。
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for(int i = 0; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
//直接选择排序：
//        将待排序的元素分为已排序（初始为空）和未排序两组，依次将未排序的元素中值最小的元素放入已排序的组中。
//        实质每次排序都将要排序位置放置当前为排序组中最小的值

//        for(int i = 0;i < arr2.length - 1 ; i++){
//            for(int j = i+1;j < arr2.length;j++){
//                if(arr2[i] > arr2[j]){
//                    temp = arr2[j];
//                    arr2[j] = arr2[i];
//                    arr2[i] = temp;
//                }
//            }
//        }
        //这种方法比上一种更简单
//        for(int i = 0; i < arr2.length - 1; i++){
//			int t = i;//默认i处是最小的
//			for(int j = i;j < arr2.length;j++){
//				//一旦在i后发现存在比其小的元素，就记录那个元素的下角标
//				if(arr2[t] > arr2[j]){
//					t = j;
//				}
//			}
//			if(t != i){
//				temp = arr2[t];
//				arr2[t] = arr2[i];
//				arr2[i] = temp;
//			}
//		}
        Arrays.sort(arr2);
        for(int i = 0; i < arr2.length ; i++){
            System.out.print(arr2[i]+" ");
        }
    }
}


