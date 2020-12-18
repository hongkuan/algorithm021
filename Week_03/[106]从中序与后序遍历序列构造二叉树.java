//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 420 👎 0


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || null == postorder || inorder.length < 1 || postorder.length <1) return null;
        int postLen = postorder.length;
        int inLen = inorder.length;
        if (postLen != inLen) return null;

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i =0 ;i <inLen ;i++){
            inMap.put(inorder[i], i);
        }

        return _buildTreeInAndPost(inMap, postorder,0, postLen-1, 0, inLen-1);
    }

    private TreeNode _buildTreeInAndPost(Map<Integer, Integer> inMap, int[] postorder, int postLeft, int postRight, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) return null;
        int rootVal = postorder[postRight];
        TreeNode rootNode = new TreeNode(rootVal);
        int rootIndex = inMap.get(rootVal);
        rootNode.left = _buildTreeInAndPost(inMap, postorder, postLeft, rootIndex - inLeft + postLeft-1, inLeft, rootIndex - 1);
        rootNode.right = _buildTreeInAndPost(inMap, postorder,rootIndex - inLeft + postLeft, postRight-1, rootIndex + 1 , inRight );
        return rootNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
