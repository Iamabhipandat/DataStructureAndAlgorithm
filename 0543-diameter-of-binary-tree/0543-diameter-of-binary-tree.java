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
    static int max;
    public int diameterOfBinaryTree(TreeNode root) {
      max = 0;
      levels(root);
      return max;
        
    }
    private  int levels(TreeNode root){
        if(root==null)return 0;
        int rightLevel = levels(root.right);
        int leftLevel = levels(root.left);
        max = Math.max(max,leftLevel+rightLevel);
      
        return 1+Math.max(leftLevel,rightLevel);
    }
}