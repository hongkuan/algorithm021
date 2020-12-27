

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        /*if(null == root) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelRes= new ArrayList<>();
            for (int i =0 ;i < levelSize; i++){
                TreeNode node = queue.poll();
                levelRes.add(node.val);
                if (null != node.left) queue.offer(node.left);
                if (null != node.right) queue.offer(node.right);
            }
            res.add(levelRes);
        }*/
        return res;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> res){
        if (null == node)return;
        if (res.size() == level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        dfs(node.left, level+1, res);
        dfs(node.right, level+1, res);
    }
}
