package com.shady.Trees;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/10/00:39
 * @Description:
 */
public class UniqueBinarySearchTreesII {
  class Solution {
    public List<TreeNode> generateTrees(int n) {
      // 1, 2, 3, 4, 5, 6, 7, 8

      if(n == 0){
        return new LinkedList<>();
      }
      return build(1, n);

    }
    public List<TreeNode> build(int lo, int hi){//return different root of the BST
      //First, set up the base case
      List<TreeNode> list = new LinkedList<>();
      if(lo > hi){
        list.add(null);
        return list;

      }
      // 1， 2 ， 3， 4， 5， 6， 7
      for (int i = lo; i <= hi ; i++) {
          List<TreeNode> left = build(lo, i - 1);
          List<TreeNode> right = build(i + 1, hi);
          for(TreeNode l : left){
            for (TreeNode r : right){
              TreeNode node = new TreeNode(i);
              node.left = l;
              node.right = r;
              list.add(node);
            }
          }


      }
      return list;

    }
  }
}
