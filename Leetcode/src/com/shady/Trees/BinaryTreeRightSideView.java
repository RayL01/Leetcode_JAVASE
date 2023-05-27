package com.shady.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/03/28/20:05
 * @Description: https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {



    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    if(root == null){
      return res;
    }


    while(!queue.isEmpty()){
      int size = queue.size();


      //We traverse all the nodes at the specific level.
      //Before that, we should get the head of the current queue
      TreeNode node = queue.peek();

      //And add it to the res List
      res.add(node.val);
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if(cur.left != null){
          queue.offer(cur.right);
        }
        if(cur.right != null){
          queue.offer(cur.left);
        }

      }
    }
    return res;
  }
}
