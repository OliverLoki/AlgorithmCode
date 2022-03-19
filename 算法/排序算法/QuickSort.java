package 排序算法;

import java.util.Arrays;

public class QuickSort {
    /*
    注释内容是为了更好的理解排序
     */
    public static void quickSort(int[] ins) {
        long start = System.currentTimeMillis();
        QuickSort.quickSort(ins,0,ins.length-1); //快速排序
        long end = System.currentTimeMillis();
        System.out.println("排序时间为"+(end-start)+"ms");
    }
    public static int[] quickSort(int[] ins, int start, int end) {
        if (start >= end) {
            return ins;//这个返回值并没有影响，因为这个返回值没有使用到。
        }
        int pivot = ins[start];//定义基准
        int low = start;
        int hight = end;

        while (low < hight) {
            while (low < hight && ins[hight] >= pivot) {//从右边开始找一个小于mid的数
                hight -= 1;
            }
            ins[low] = ins[hight];//找到arr[hight]小于基准，放在基准的位置上
            //System.out.println(Arrays.toString(ins) + "low = " + low + "   hight = " + hight);
            while (low < hight && ins[low] < pivot) {//从左开始找一个大于mid的数
                low += 1;
            }
            ins[hight] = ins[low];//找到ins[low]小于基准，放在基准的位置上
            //System.out.println(Arrays.toString(ins) + "low = " + low + "   hight = " + hight);
        }
        ins[low] = pivot;//当low>=height时，停止查找，将基准归位
        //System.out.println(Arrays.toString(ins) + "low = " + low + "   hight = " + hight);
        quickSort(ins, start, low - 1);
        quickSort(ins, low + 1, end);
        return ins;
    }
}
