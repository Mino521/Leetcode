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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Integer> cur = new ArrayList<>();
        Stack<TreeNode> next = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        cur.add(root.val);
        ans.add(cur);
        if(root.left != null)
            next.push(root.left);
        if(root.right != null)
            next.push(root.right);
        traversal(ans, next, false);

        return ans;
    }

    public void traversal(List<List<Integer>> ans, Stack<TreeNode> curNodes, boolean direction){
        if(curNodes.size() == 0)
            return;
        List<Integer> cur = new ArrayList<>();
        Stack<TreeNode> nextLv = new Stack<>();
        while(!curNodes.isEmpty()){
            TreeNode node = curNodes.pop();
            cur.add(node.val);
            if(direction){
                if(node.left != null)
                    nextLv.add(node.left);
                if(node.right != null)
                    nextLv.add(node.right);
            }
            else{
                if(node.right != null)
                    nextLv.add(node.right);
                if(node.left != null)
                    nextLv.add(node.left);
            }
        }
        ans.add(cur);
        traversal(ans, nextLv, !direction);
    }
}