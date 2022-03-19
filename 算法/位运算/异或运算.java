package 位运算;

public class 异或运算 {
    //前提是a和b在内存里是独立的两块区域，即不在一个内存

    // 使用异或运算符交换两数
    public static void exchangeTwoNumber() {
        int a = 17, b = 22;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a + "b=" + b);
    }

    //在一个数组中，有一个数出现了奇数次，请找出这个数,要求时间复杂度O(N)
    public static void demo01(int[] arr) {
        //0异或出现偶数次的数=0，异或出现基数次的数=1
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }


    //在一个数组中，有一个数字出现了偶数次，请找出这个数




    //在一个数组中，有两个数出现了基数次，请找出这个数,要求时间复杂度O(N)
    public static void demo02(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;//提取出二进制最右边的那个1
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

}
