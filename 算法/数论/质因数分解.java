package 数论;

import java.util.Scanner;

public class 质因数分解 {
    /*
    每个合数都可以写成几个质数相乘的形式，其中每个质数都是这个合数的因数，
    把一个合数用质因数相乘的形式表示出来，叫做分解质因数。如30=2×3×5 。
    分解质因数只针对合数。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer a = sc.nextInt();
        Integer b = sc.nextInt();
        for (int i = a; i <= b; i++) {
            // 输入值大于等于3
            if (i >= 3) {
                String m = "";
                int k = 2;
                int j = i;
                while (j != k) {
                    // 如果n>k，但n能被k整除，则应打印出k的值，并用n除以k的商作为新的正整数n
                    if (j % k == 0) {
                        m = m + k + "*";
                        j = j / k;
                    }
                    // 如果n不能被k整除，则用k+1作为k的值
                    else if (j % k != 0) {
                        k++;
                    }
                }
                m = m + k;
                System.out.println(i + "=" + m);
            } else {
                System.out.println(i + "=" + i);
            }
        }
    }
}
