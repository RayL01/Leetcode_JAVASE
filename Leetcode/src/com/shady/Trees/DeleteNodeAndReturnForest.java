package com.shady.Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/04/11/14:03
 * @Description:
 */
public class DeleteNodeAndReturnForest {
  Set<Integer> delSet = new HashSet<>();
  List<TreeNode> res = new ArrayList<>();
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    if(root == null) return new ArrayList<>();
    for (Integer i:to_delete
         ) {
      delSet.add(i);
    }
    traverse(root, false);
    return res;
  }
  private TreeNode traverse(TreeNode root,boolean hasParent){
    if(root == null) return null;
    boolean isDeleted = delSet.contains(root.val);

    if(!isDeleted && !hasParent){
      res.add(root);
    }
    root.left = traverse(root.left,!isDeleted);
    root.right = traverse(root.right, !isDeleted);

    return isDeleted ? null : root;


  }
}
