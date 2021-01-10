//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 
// 👍 469 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp步骤：
     * 1.最优子结构 sub[n][m] = sub[n-1][m]+sub[n][m-1]
     * 2.中间状态记录 dp[i][j] = sub[i][j]
     * 3.dp方程 fun(n, m) = fun(n-1, m)+ fun(n,m-1)
     * @param grid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(null == obstacleGrid || obstacleGrid.length == 0 ||null == obstacleGrid[0] || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = 1;
        for (int i =1 ; i< n; i++){//初始化第一列
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0: dp[i-1][0];
        }

        for (int i =1 ; i< m; i++){//初始化第一行
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 :dp[0][i-1];
        }

        for (int i = 1; i < n ; i++){
            for (int j=1; j< m ; j++){
                dp[i][j] = (1==obstacleGrid[i][j])? 0 : (dp[i-1][j] + dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
