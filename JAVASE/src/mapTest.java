import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/09/08/00:34
 * @Description:
 */
public class mapTest {
  boolean isP = false;
  boolean isQ = false;
  LinkedHashMap linkedHashMap = new LinkedHashMap();

  @Test
  public void test(){
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer i : map.keySet()
         ) {
      map.get(i);
    }

    Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

    for (Map.Entry<Integer, Integer> en: entries
         ) {
      Integer key = en.getKey();
      Integer value = en.getValue();

    }
    Collection<Integer> values = map.values();


    Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()){
      Map.Entry<Integer, Integer> next = iterator.next();

    }

    map.forEach((k, v) -> {
      System.out.println("key" + k);
      System.out.println("value" + v);
    });

  }
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(isP && isQ){
      return traverse(root, p, q);
    }
    return null;
  }
  private TreeNode traverse(TreeNode root, TreeNode p, TreeNode q){
    if(root == null) return null;



    TreeNode left = traverse(root.left, p, q);
    TreeNode right = traverse(root.right, p, q);
    if(left != null && right != null){
      return root;
    }
    if(root.val == p.val){
      isP = true;
      return root;
    }
    if(root.val == q.val){
      isQ = true;
      return root;
    }

    return left == null ? right : left;


  }
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }

  @Test
  public void test1(){

  }
}
