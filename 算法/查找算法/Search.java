package 查找算法;

import java.util.ArrayList;
import java.util.List;

public class Search {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        lineSearch(arr, 1000); //顺序查找
        binarySearch(arr, 1000); //二分查找

    }

    //顺序查找算法
    public static void lineSearch(int[] arr, int value) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0, length = arr.length; i < length; i++) {
            if (arr[i] == value) {
                list.add(i);
            }
        }
        if (list.size() != 0) {
            System.out.println(value + " 顺序查找的索引值为:" + list);
            return;
        }
        System.out.println("未找到");

    }

    //二分查找
    public static void binarySearch(int[] arr, int value) {
        search(arr, 0, arr.length - 1, value);
        serarch2(arr,0, arr.length - 1, value);

    }
    //递归版本
    public static void search(int[] arr, int left, int right, int findVal) {

        int mid = (left + right) / 2;
        if (arr[mid] < findVal) {//向右递归
            search(arr, mid + 1, arr.length - 1, findVal);
        }
        if (arr[mid] > findVal) {//向左递归
            search(arr, left, mid - 1, findVal);
        }
        if (arr[mid] == findVal) {//找到索引值,扫描其左右侧
            List<Integer> list = new ArrayList<Integer>();
            //扫描左侧
            for (int i = left; i < mid; i++) {
                if (arr[i] == findVal)
                    list.add(i);
            }
            //扫描右侧
            for (int i = mid; i < right; i++) {
                if (arr[i] == findVal)
                    list.add(i);
            }
            System.out.println(findVal + " 二分查找的索引值为:" + list);
        }
    }
    //二分查找非递归版本
    public static void serarch2(int[] arr, int left, int right, int findVal){
        while(left <= right) { //说明继续查找
            int mid = (left + right) / 2;
            if(arr[mid] == findVal) {
                System.out.println("二分非递归索引位置："+mid);
                break;
            } else if ( arr[mid] > findVal) {
                right = mid - 1;//需要向左边查找
            } else {
                left = mid + 1; //需要向右边查找
            }
        }

    }


    //插值查找
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        //注意：findVal < arr[0] 和 findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 求出 mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 说明应该向右边递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 说明向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

}