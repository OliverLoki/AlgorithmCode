package 排序算法;

public class SelectionSort {

    //选择排序
    public static void selectionSort(int[] arr) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //交换arr[i]和arr[minindex]
            arr[i] ^= arr[minIndex];
            arr[minIndex] ^= arr[i];
            arr[i] ^= arr[minIndex];
        }
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("选择排序运行时间： " + (endTime - startTime) + "ms");
    }
}
