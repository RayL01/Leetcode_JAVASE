package com.shady.Trees;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/11/15:11
 * @Description: FInd the LCA given that the Node has a parent pointer in its structure
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
 */
public class LowestCommonAncestorofaBinaryTreeIII {
  class Solution{
    public Node lowestCommonAncestor(Node p, Node q){
      HashSet<Node> set = new HashSet<>();
      Node a = p;
      Node b = q;
      while(a != null){
        set.add(a);
        a = a.parent;
      }

      while(b != null){
        if(set.contains(b)){
          return b;
        }
        b = b.parent;
      }
      return null;
    }
  }
}
