package com.shady;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandPostorderTraversal {
  class Solution {
    Map<Integer, Integer> ValToIndex = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
      for (int i = 0; i < postorder.length; i++) {
        ValToIndex.put(postorder[i], i);
      }
      return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode build(int [] preorder, int preLo, int preHi, int [] postorder, int poLo, int poHi){
      if(preLo > preHi){
        return null;
      }
      if(preLo == preHi){
        return new TreeNode(preorder[preLo]); //when there 's only one element in the array, preLo + 1 will cause array out of bound exception
      }
      int rootval = preorder[preLo];
      //create the root node

      int leftRoot = preorder[preLo + 1];

      int index = ValToIndex.get(leftRoot);


      int leftsize = index - poLo + 1;


      TreeNode root = new TreeNode(rootval);

      root.left = build(preorder, preLo + 1, preLo + leftsize, postorder, poLo, index);
      root.right = build(preorder, preLo + leftsize + 1, preHi, postorder, index + 1, poHi - 1 );
      return root;
    }
  }
}
