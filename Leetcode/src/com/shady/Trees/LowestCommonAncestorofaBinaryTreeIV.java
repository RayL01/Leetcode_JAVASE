package com.shady.Trees;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/11/00:00
 * @Description: return the LCA of the nodes in the array
 */
public class LowestCommonAncestorofaBinaryTreeIV {
  class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
      HashSet<TreeNode> set = new HashSet<>();
      set.addAll(Arrays.asList(nodes));

      return Find(root, set);
    }
    public TreeNode Find(TreeNode root, HashSet<TreeNode> set){
      if(root == null){//base case
        return null;
      }
      if(set.contains(root)){//situation 2
        return root;
      }
      TreeNode left = Find(root.left, set);
      TreeNode right = Find(root.right, set);
      if(left != null && right != null){
        return root;
      }

      //else return null     (not found)       but if we found one in one single branch we return it, it is exactly the situation2.
      return left!=null ? left : right;
    }
  }
}
