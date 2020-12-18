//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 794 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder || preorder.length < 1 || inorder.length <1) return null;
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) return null;

        Map<Integer, Integer> inMap = new HashMap<>();//创建中序遍历值的下标索引 节约后序查找时间
        for (int i =0 ;i <inLen ;i++){
            inMap.put(inorder[i], i);
        }

        return _buildTree(preorder, inMap,0, preLen-1, 0, inLen-1);
    }

    /**
     * 递归创建二叉树
     * @param preorder  前序遍历
     * @param inMap     中序遍历 和 下标索引
     * @param prLeft    前序遍历起点下标
     * @param prRight   前序遍历结尾下标
     * @param inLeft    中序遍历起点下标
     * @param inRight   中序遍历结尾下标
     * @return
     */
    private TreeNode _buildTree(int[] preorder, Map<Integer, Integer> inMap, int prLeft, int prRight, int inLeft, int inRight) {
        if (prLeft > prRight || inLeft > inRight)return null;
        int rootVal = preorder[prLeft];//找到根节点值
        TreeNode root = new TreeNode(rootVal);//创建根节点
        int rootInIndex = inMap.get(rootVal);//找到根节点在中序遍历位置
        root.left= _buildTree(preorder, inMap, prLeft+1,  rootInIndex - inLeft + prLeft , inLeft, rootInIndex -1);
        root.right = _buildTree(preorder, inMap, rootInIndex - inLeft + prLeft + 1, prRight, rootInIndex + 1, inRight);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
