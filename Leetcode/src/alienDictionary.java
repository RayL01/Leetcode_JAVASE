import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/09/30/00:51
 * @Description:
 */
public class alienDictionary {



  List<Character> postorder = new ArrayList<>();
  boolean hasCycle = false;
  boolean[] visited = new boolean[26];
  boolean[] onPath = new boolean[26];
  public String alienOrder(String[] words){
    Deque<Integer> deque = new ArrayDeque<>();
    List<Character>[] alphabet = new List[26];
    int n = words.length;
    for (int i = 0; i < n - 1; i++) {
      String first = words[i];
      String second = words[i + 1];
      if(first.length() > second.length() && first.contains(second)) return "";
      int j = 0;
      while(first.charAt(j) == second.charAt(j)){
        j++;
      }
      //now j is at the index where first[j] differs from second[j]
      //first.charAt[j] - > second.charAt[j]


      if (alphabet[first.charAt(j) - 'a'] == null) {
        alphabet[first.charAt(j) - 'a'] = new ArrayList<>();
      }
      alphabet[first.charAt(j) - 'a'].add(second.charAt(j));


    }
    for (int i = 0; i < 26; i++) {
      if(alphabet[i] != null && !visited[i]){
        traverse(alphabet, (char) (i + 'a'));
      }
    }
    if (hasCycle){
      return "";
    }
    //reverse the postorder
    Collections.reverse(postorder);
    StringBuilder sb = new StringBuilder();
    for (Character c: postorder
         ) {
      sb.append(c);
    }
    return sb.toString();




  }
  private void traverse(List<Character>[] alphabet, char start){
    if(onPath[start - 'a']){
      hasCycle = true;
      return;
    }
    if(visited[start - 'a']) return;
    if(hasCycle) return;
    onPath[start - 'a'] = true;
    visited[start - 'a'] = true;
    for (Character character:alphabet[start - 'a']
         ) {
      traverse(alphabet, character);
    }
    postorder.add(start);
    onPath[start - 'a'] =false;
  }
}
