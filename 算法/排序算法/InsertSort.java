package 排序算法;

public class InsertSort {
    //插入排序
    public static void insertSort(int[] arr) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        //假定第i个元素有序,i=1，这个for循环说明了n个数的数组需要遍历n-1次
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1; //定义
            int current = arr[i]; //定义待插入的数
            //遍历有序列表找到合适的插入位置
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

}
