package com.shady.Trees;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/10/22:06
 * @Description:
 */
public class LowestCommonAncestorofaBinaryTree {
  class Solution {
    /**
     * Find a node which is the ancestor of the given nodes.
     * Situation 1:
     * The two given nodes are respectively left and right sub-trees of the current root node
     * In order to find the node in the tree, we are supposed to traver the left and right and examine whether we have found them in the left and right.
     * Therefore, we should examine the results in the post order position.
     *
     *
     * Situation 2: one node is the ancestor of the other. In this case, the former one is the LCA of the later one.
     * so we need to put this in the pre order position. Once we found the node, it must be the LCA of the other or the offspring of its root node, and either way works
     *
     *
     *
     * Time: O(n) Space:O(n)    (left and right)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){//base case
          return null;
        }
        if(root.val == p.val || root.val == q.val){//situation 2
          return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
          return root;
        }

        //else return null     (not found)       but if we found one in one single branch we return it, it is exactly the situation2.
        return left!=null ? left : right;
    }
  }
}
