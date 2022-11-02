package com.shady;

import java.util.ArrayList;
import java.util.List;

public class SerializeandDeserializeBinaryTreePostorder {

  public class Codec {
    String SP = ",";
    String NULL = "#";
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      buildSeries(root);
      return sb.toString();

    }
    public void buildSeries(TreeNode root){
      if(root == null){
        sb.append(NULL).append(SP);
        return;
      }
      serialize(root.left);
      serialize(root.right);
      sb.append(root.val).append(SP);
      return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      //First we need to covert the String data into an array or arraylist.

      List<String> list = new ArrayList<>();
      for (String s: data.split(SP)){
        list.add(s);
      }
      return buildTrees(list);
    }
    public TreeNode buildTrees(List<String> list){
      //base case
      String s = list.get(list.size() - 1);
      list.remove(list.size() - 1);
      if(s == null){
        return null;
      }
      if(s.equals(NULL)){
        return null;
      }
      TreeNode root = new TreeNode(Integer.parseInt(s));
      root.right = buildTrees(list);
      root.left = buildTrees(list);

      return root;
    }
  }
}
