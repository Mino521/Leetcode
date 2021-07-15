/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        calculate(root, map);
        return Collections.max(map.values());
    }

    public int calculate(TreeNode root, Map<TreeNode,Integer> map){
        if(root == null)
            return 0;
        int leftv = calculate(root.left, map);
        int rightv = calculate(root.right, map);
        int max1 = Math.max(root.val, Math.max(root.val+leftv, root.val+rightv));
        int maxv = Math.max(max1, root.val+rightv+leftv);
        map.put(root, maxv);

        return max1;
    }
}