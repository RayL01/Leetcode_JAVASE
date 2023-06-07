package com.shady.Trees;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/06/06/16:51
 * @Description:
 */
public class SerializeandDeserializeBST {
  public class Codec {
    private static String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder stringBuilder = new StringBuilder();
      serialize(root,stringBuilder);
      return stringBuilder.toString();
    }
    private void serialize(TreeNode root, StringBuilder sb){
      if(root == null) return;

      sb.append(root.val).append(SEP);
      serialize(root.left, sb);
      serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if(data.isEmpty()) return null;
      //convert it to a list

      LinkedList<Integer> inorder = new LinkedList<>();
      for (String s:data.split(SEP)
           ) {
        inorder.add(Integer.parseInt(s));
      }
      return deserialize(inorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode deserialize(LinkedList<Integer> nodes, int min, int max){
      /**
       * 2    1     3
       */
      if(nodes.isEmpty()) return null;

      int rootVal = nodes.getFirst();
      if(rootVal > max || rootVal < min) return null;
      nodes.removeFirst();
      TreeNode root = new TreeNode(rootVal);
      root.left = deserialize(nodes, min, root.val);
      root.right = deserialize(nodes, root.val, max);

      return root;
    }
  }
}
