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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int a  =  levels(root.right)+levels(root.left);
        int b = diameterOfBinaryTree(root.right);
        int c = diameterOfBinaryTree(root.left);
        return Math.max(a,Math.max(b,c));
        
    }
    private  int levels(TreeNode root){
        if(root==null)return 0;
        int rightLevel = levels(root.right);
        int leftLevel = levels(root.left);
      
        return 1+Math.max(leftLevel,rightLevel);
    }
}