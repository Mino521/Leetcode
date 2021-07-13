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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = solve(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

        return root;
    }

    public TreeNode solve(int[] preorder, int a, int b, int[] inorder, int l, int r){
        if(a > b || l > r)
            return null;
        TreeNode root = new TreeNode(preorder[a]);
        int index = l;
        while(index <= r && inorder[index] != preorder[a])
            index++;
        root.left = solve(preorder, a+1, b, inorder, l, index-1);
        root.right = solve(preorder, a+1+index-l, b, inorder, index+1, r);

        return root;
    }
}