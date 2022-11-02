package com.shady;

import java.util.LinkedList;
import java.util.Queue;

public class SerializaAndDeserializeBinaryTreeLevelOrder {
  public class Codec {
    String SP = ",";
    String NULL = "#";
    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      buildSeries(root);
      return sb.toString();

    }

    public void buildSeries(TreeNode root) {
      if (root == null) {
        sb.append(NULL).append(SP);
        return;
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while(!queue.isEmpty()){//different from level order traversal, we need to put the null node into the queue
        TreeNode cur = queue.remove();
        if(cur == null){
          sb.append(NULL).append(SP);
        }else{
          sb.append(cur.val).append(SP);
          queue.offer(root.left);
          queue.offer(root.right);
        }

      }

    }
    public TreeNode derialize(String data) {
      if (data == null){
        return null;
      }
      String[] nodes = data.split(SP);
      //create a linked list
      Queue<TreeNode> list = new LinkedList<>();
      TreeNode root  = new TreeNode(Integer.parseInt(nodes[0]));
      list.offer(root);// put the first node into the list.

      int i = 1;//current index of nodes[]
      while(!list.isEmpty()){
        TreeNode cur = list.poll();
        String left = nodes[i++];
        if(!left.equals(NULL)){//the left node is not null
          cur.left = new TreeNode(Integer.parseInt(left));
          list.offer(cur.left);
        }else{
          cur.left = null;
        }

        String right = nodes[i++];
        if(!right.equals(NULL)){//the left node is not null
          cur.right = new TreeNode(Integer.parseInt(right));
          list.offer(cur.right);
        }else{
          cur.right = null;
        }
      }
      return root;
    }
  }
}
