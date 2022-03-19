package 排序算法;

public class BubbleSort {

    //冒泡排序--O(n^2)
    public static void bubbleSort(int[] arr) {
        long startTime = System.currentTimeMillis();   //获取开始时间

        for (int i = 0; i < arr.length - 1; i++) {//循环一次可以确定一个最大的数
            //i可以理解为最后已经排好序的元素的个数
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //通过位运算交换两数字
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                }
            }
        }
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("冒泡排序运行时间： " + (endTime - startTime) + "ms");
    }
}
