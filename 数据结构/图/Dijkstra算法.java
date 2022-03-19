package 图;

import java.util.*;

public class Dijkstra算法 {
    public static void main(String[] args) {

        int[][] arr = new int[300][300];
        long ans = 0;
        //初始化
        Scanner sc = new Scanner(System.in);
        for (int[] is : arr) {
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                String s1 = String.valueOf(s.charAt(i));
                int i1 = Integer.parseInt(s1);
                is[i]=i1;
            }
        }
        for (int i =0; i < arr.length;i++ ) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]==2&&arr[i+1][j]==0&&arr[i+2][j]==2&&arr[i+3][j]==0)
                    ans++;//橫向
                if(arr[i][j]==2&&arr[i][j+1]==0&&arr[i][j+2]==2&&arr[i][j+3]==0)
                    ans++;//纵向
                if(arr[i][j]==2&&arr[i+1][j+1]==0&&arr[i+2][j+2]==2&&arr[i+3][j+3]==0)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}

