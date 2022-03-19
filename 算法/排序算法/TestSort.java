package 排序算法;

import java.util.Arrays;
import java.util.Comparator;

public class TestSort {
    /*tips:
    函数中直接对数组元素的操作属于对对象的操作,数组作为参数传递时传递的只是数组在内存中的地址值（即引用值），而不是将数组的元素直接传给形参；
    这样的引用传递使方法的形参和实参同时指向数组在内存中的位置，所以无论是通过形参还是实参修改数组，内存中的数组的值都会发生改变

    这跟除了 String 外的所有引用数据类型相似(String是被final修饰的常量)，需要注意的是 Java 中只有值的传递而没有引用传递
     */
    public static void main(String[] args) {
        //生成一个八万个随机数的数组,测试效率
        int[] arr = new int[80002];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        //这个数组是为了理解排序规则
        int[] arr2 = {3,12,4,5,62,7};

        //originSort(arr); //java Api排序
        //BubbleSort.bubbleSort(arr); //冒泡排序
        //SelectionSort.selectionSort(arr); //选择排序
        //QuickSort.quickSort(arr); //快速排序
        //InsertSort.insertSort(arr); //插入排序

        //System.out.println(Arrays.toString(arr)); //输出排序后数组进行检查

    }

    //Java Api
    public static void originSort(int[] arr) {
        long startTime = System.currentTimeMillis();
        Arrays.sort(arr);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("Java Api运行时间： " + (endTime - startTime) + "ms");
    }

    //Java Api实现逆序
    public static void reverseOrder(Integer[] arr) {
        Arrays.sort(arr,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }






}
