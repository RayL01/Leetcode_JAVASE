//package com.shady.Trees;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//import javax.swing.tree.TreeNode;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shadyyyyyl
// * @Date: 2023/03/28/16:27
// * @Description:
// * https://leetcode.com/problems/binary-tree-paths/
// */
//public class BinaryTreePaths {
//  LinkedList<String> res = new LinkedList<>();
//  LinkedList<String> path = new LinkedList<>();
//
//
//
//  public List<String> binaryTreePaths(TreeNode root) {
//    traverse(root);
//    return res;
//  }
//  private void traverse(TreeNode root){
//
//    //Set up base case
//    if(root == null){
//      return;
//    }
//    path.add("" + root.val);
//    if(root.left == null && root.right == null){
//      res.add(String.join("->", path));
//    }
//
//    //pre-order traversal position
//
//
//    traverse(root.left);
//    traverse(root.right);
//
//    path.removeLast();
//
//  }
//}
