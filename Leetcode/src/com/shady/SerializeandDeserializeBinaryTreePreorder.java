package com.shady;

import java.util.ArrayList;
import java.util.List;

//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
//Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeandDeserializeBinaryTreePreorder {
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

      sb.append(root.val).append(SP);
      serialize(root.left);
      serialize(root.right);
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
      String s = list.get(0);
      list.remove(0);
      if(s == null){
        return null;
      }
      if(s.equals(NULL)){
        return null;
      }
      TreeNode root = new TreeNode(Integer.parseInt(s));
      root.left = buildTrees(list);
      root.right = buildTrees(list);
      return root;
    }
  }

}
