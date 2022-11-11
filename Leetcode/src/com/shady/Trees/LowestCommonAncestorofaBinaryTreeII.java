package com.shady.Trees;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/11/00:16
 * @Description: Find the LCA of the nodes, the presence of nodes is not guaranteed. And return null if not found.
 */
public class LowestCommonAncestorofaBinaryTreeII {
  class Solution {
    /**
     * Since we need to examine whether the other node exists in the current tree, we should traverse the whole left and right.
     * In this case, we need to write the code at the post-order position, so that the left and right can be fully traversed.
     * Why put it in the post-order position? Because, if its in the pre-order position, once it meets the condition of the
     * if statement, left and right recursion will not be executed.
     * @param root
     * @param p
     * @param q
     * @return
     */
    boolean FoundP = false, FoundQ = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        TreeNode Q = ans(root, p, q);
        if(FoundP == false || FoundQ == false){
          return null;
        }
        return Q;
    }
    public TreeNode ans(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null){
        return null;
      }
      TreeNode left = ans(root.left, p, q);//it would update foundP and foundQ
      TreeNode right = ans(root.right, p, q);//it would update foundP and foundQ

      //situation 1:
      if(left != null && right != null){
        return root;
      }

      //situation2

      if(root == p){
          FoundP = true;
          return root;
      }
      if(root == q){
        FoundQ = true;
        return root;
      }
      return left != null ? left : right;//situation1 returning position
    }
  }
}
