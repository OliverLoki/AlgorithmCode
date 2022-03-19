package 稀疏数组;

public class 五子棋demo {
    public static void main(String[] args) {
        //初始化棋盘
        int[][] arr = new int[8][8];
        //给棋盘赋值,1表示黑子，2表示白子，默认值0表示无子
        arr[1][2] = 1;
        arr[6][4] = 2;
        //打印原始数据
        五子棋demo.printChessboard(arr);
        // 将二维数组转稀疏数组
        //先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建一个稀疏数组
        //第0行记录原数组的大小和数据的个数
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0]=8;
        sparseArr[0][1]=8;
        sparseArr[0][2]=sum;
        //写入稀疏数组
        int count =0;//记录第几个非0数据
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;//记录行
                    sparseArr[count][1] = j;//记录列
                    sparseArr[count][2] = arr[i][j];//记录值
                }
            }
        }
        //打印稀疏数组
        System.out.println("==============");
        五子棋demo.printChessboard(sparseArr);
        //恢复稀疏数组并展示
        System.out.println("================");
        //初始化数组
        int arr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //赋值
        for (int i = 1; i < sparseArr.length; i++) {
            arr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //打印
        五子棋demo.printChessboard(arr2);
    }

    //输出二维数组
    public static void printChessboard(int[][] arr) {
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
