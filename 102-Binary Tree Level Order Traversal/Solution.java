import java.util.*;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> cur = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        cur.add(root.val);
        ans.add(cur);
        if(root.left != null)
            next.add(root.left);
        if(root.right != null)
            next.add(root.right);
        traversal(ans, next);

        return ans;
    }

    public void traversal(List<List<Integer>> ans, List<TreeNode> curNodes){
        if(curNodes.size() == 0)
            return;
        List<Integer> cur = new ArrayList<>();
        List<TreeNode> nextLv = new ArrayList<>();
        for(TreeNode node : curNodes){
            cur.add(node.val);
            if(node.left != null)
                nextLv.add(node.left);
            if(node.right != null)
                nextLv.add(node.right);
        }
        ans.add(cur);
        traversal(ans, nextLv);
    }
}