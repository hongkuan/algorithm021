//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 754 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp步骤：
     * 1.最优子结构 sub[n][m] = min(sub[n-1][m], sub[n][m-1]) +grid[n][m];
     * 2.中间状态记录 dp[i][j] = sub[i][j] 或者 dp[i] = min(dp[i-1], dp[i])+ grid[i][j]
     * 3.dp方程 fun(n, m) = min(fun[n-1][m] + fun[n][m-1])+ grid[n][m]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (null ==grid || grid.length== 0 || null == grid[0] || grid[0].length == 0)return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
        for (int i =0 ;i < n; i++){
            for (int j =0; j< m; j++){
                if (j == 0 && i == 0) dp[j] = grid[i][j];
                else if (j !=0 && i ==0) dp[j] = dp[j-1] + grid[i][j];
                else if (j ==0 && i !=0) dp[j] = dp[j]  + grid[i][j];
                else dp[j] =(Math.min(dp[j-1], dp[j])+ grid[i][j] );
            }
        }
        return dp[m-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
