package com.shady.Trees;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/06/07/19:06
 * @Description:
 */
public class BinarySearchIterator {
  class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
      pushAll(root);
    }
    private void pushAll(TreeNode p){
      while(p != null){
        stack.push(p);
        p = p.left;
      }
    }

    public int next() {
      TreeNode p = stack.pop();
      pushAll(p.right);
      return p.val;
    }

    public boolean hasNext() {
      return !stack.isEmpty();
    }
  }
}
