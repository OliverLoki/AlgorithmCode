package 图;

import java.util.*;

public class Dijkstra算法 {
    final static int C = 999999999;//定义该点无直达
    public static void main(String[] args) {
        //初始化邻接矩阵
        int[][] map = new int[2050][2050];
        //首先初始化为最大值
        for (int[] temp : map) {
            for (int i = 0; i < temp.length; i++) {
                temp[i] = C;
            }
        }
        //按照题意赋值
        for (int i = 1; i <= 2021; i++) {
            for (int j = i; j <= i + 21; j++) {
                //对a,b相差21以内的边赋权
                map[i][j] = lcm(i, j);
            }
        }
        //Dijkstra:按路径长度递增次序产生最短路径
        /*
        V:代表所有顶点
        bj:代表顶点是否已确定最短路径
        */
        boolean bj[] = new boolean[2050];//用来标记该点是否找到最短路径
        int dis[] = new int[2050];//存储源点到其他顶点的初始路径
        for (int i = 1; i <= 2021; i++)
            dis[i] = map[1][i];//先赋值为直达路径
        int min, minIdx = 0;
        //没执行一次while循环，确定到一个点的最短路径
        while (!bj[2021]) {//如果2021点的最短路径还没求到就一直循环
            min = Integer.MAX_VALUE;
            //每次找到从源点出发最近的距离
            for (int i = 2; i <= 2021; i++) {
                if (!bj[i] && dis[i] < min) {
                    //交换
                    min = dis[i];
                    minIdx = i;
                }
            }
            bj[minIdx] = true;//循环一圈以后，可以确定一个最短的点，然后进行下一次循环，直到bj[2021]==true

            //从最近的这个点当中间点，找到 V(0) -- V(minIdx) -- V(和V(minIdx)有直连的点)，再一次更新最短路径
            for (int i = minIdx + 1; i <= minIdx + 21; i++) {
                //如果该点到源点没有边
                if (dis[i] == C)
                    dis[i] = dis[minIdx] + map[minIdx][i];
                    //两边之和小于直达边，更新距离
                else if (dis[minIdx] + map[minIdx][i] < dis[i])
                    dis[i] = dis[minIdx] + map[minIdx][i];
            }
        }
        System.out.println(dis[2021]);
    }

    //求最大公约数
    public static int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }
    public static int lcm(int x, int y) {//最小公倍数
        return x * y / gcd(x, y);
    }
}

