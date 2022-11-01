package com.shady;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {



  class Solution {
    Map<String, Integer> map = new HashMap<>();//contains the structures in the tree.
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      Find(root);

      return ans;
    }
    public String Find(TreeNode root){
      if(root == null){
        return "#";
      }
      String left = Find(root.left);
      String right = Find(root.right);
      String mySelf = left + "," + right + "," + root.val;
      if(map.containsKey(mySelf)){//the node in already in the set
        if(map.get(mySelf) == 1){
          ans.add(root);
        }
        map.put(mySelf, map.get(mySelf) + 1);

      }else{
        map.put(mySelf, 1);//Initialization
      }
      return mySelf;
    }
  }
}
