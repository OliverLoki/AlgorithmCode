package 动态规划;


public class 下降最小路径和 {
    /**
     * 1、明确状态
     * 2、确定dp[]的含义  状态转移方程
     *          dp[i]  =  Matrix[i][j] + min{dp(r + 1, c - 1), dp(r + 1, c), dp(r + 1, c + 1)}
     * 3、明确 base case
     */
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        for (int r = N - 2; r >= 0; --r) {
            for (int c = 0; c < N; ++c) {//
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = A[r + 1][c];
                if (c > 0)//
                    best = Math.min(best, A[r + 1][c - 1]);
                if (c + 1 < N)
                    best = Math.min(best, A[r + 1][c + 1]);
                A[r][c] += best;//r表示行，从下往上求出到达每一行某一列的最短距离
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x : A[0])
            ans = Math.min(ans, x);
        return ans;
    }

}
