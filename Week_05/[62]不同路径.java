//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 850 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp步骤：
     * 1.最优子结构 sub[n][m] = sub[n-1][m]+sub[n][m-1]
     * 2.中间状态记录 dp[i][j] = sub[i][j] 或者滚动数组dp[i] = dp[i]+ dp[i-1]
     * 3.dp方程 fun(n, m) = fun(n-1, m)+ fun(n,m-1)
     * @param grid
     * @return
     */
    public int uniquePaths(int m, int n) {
        if(n == 0 || m == 0) return 0;
        int[] dp= new int[m];

        for (int i =0 ; i< n;i++){
            for (int j =0 ; j<m ; j++){
                dp[j] = (i==0 || j == 0)?1: dp[j-1]  + dp[j];
            }
        }

        return dp[m-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
