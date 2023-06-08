package com.shady.Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/06/08/15:44
 * @Description:
 */
public class AllElementsinTwoBinarySearchTrees {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    LinkedList<Integer> res = new LinkedList<>();
    BSTIterator bstIterator1 = new BSTIterator(root1);
    BSTIterator bstIterator2 = new BSTIterator(root2);
    while (bstIterator1.hasNext() && bstIterator2.hasNext()){
      if(bstIterator1.peek() > bstIterator2.peek()){
        res.add(bstIterator2.next());
      }else{
        res.add(bstIterator1.next());
      }
    }

    //It's possible that the length of two trees are not the same, so we have to deal with the one left
    while(bstIterator1.hasNext()){
      res.add(bstIterator1.next());
    }
    while(bstIterator2.hasNext()){
      res.add(bstIterator2.next());
    }
    return res;

  }
  class BSTIterator{
    Stack<TreeNode> stack = new Stack<>();

    private void pushAll(TreeNode p){
      while(p != null){
        stack.push(p);
        p = p.left;
      }
    }
    public BSTIterator(TreeNode node){
      pushAll(node);
    }
    public int peek(){
      return stack.peek().val;
    }
    public int next(){
      TreeNode node = stack.pop();
      pushAll(node.right);
      return node.val;
    }
    public boolean hasNext(){
      return !stack.isEmpty();
    }
  }
}
