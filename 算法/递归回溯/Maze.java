package 递归回溯;

import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        //创建一个二维数组模拟迷宫
        //1代表墙，2代表轨迹，0代表可以进入
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int j = 1; j < 7; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }
        for (int res[] :map){
            System.out.println(Arrays.toString(res)+" ");
        }
        //设置挡板, 1 表示
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("===========");
        setWay(map, 1, 1);


       for (int res[] :map){
           System.out.println(Arrays.toString(res)+" ");
       }


    }

    //使用递归回溯给小球找路
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定： 当 map[i][j] 为 0 表示该点没有走过 当为 1 表示墙 ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯

    /**
     * @param map 表示地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路，就返回 true, 否则返回 false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 通路已经找到 ok
            return true;
        } else {
            if (map[i][j] == 0) { //如果当前这个点还没有走过
                //按照策略 下->右->上->左 走
                map[i][j] = 2; // 假定该点是可以走通.
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { //向上
                    return true;
                } else if (setWay(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果 map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }

}
