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
    static boolean flag;
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
       flag = true;
       levels(root);
       return flag;
        
    }
    private  int levels(TreeNode root){
        if(root==null)return 0;
        int rightLevel = levels(root.right);
        int leftLevel = levels(root.left);
         if(Math.abs(rightLevel-leftLevel)>1)flag =  false;
        return 1+Math.max(leftLevel,rightLevel);
    }
}