import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/02/12:17
 * @Description:
 */
public class test4 {
  boolean[][] visited;
  List<String> res = new ArrayList();
  @Test
  public void test(){
    char[][] board = new char[][]{
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
    };
    String[] words = new String[]{"oath","pea","eat","rain"};
    List<String> result = findWords(board, words);
    Stack stack = new Stack();
  }
  class TrieNode{
    Integer val = null;
    HashMap<Character, TrieNode> children = new HashMap();
  }
  public List<String> findWords(char[][] board, String[] words) {
    int m = board.length;
    int n = board[0].length;
    visited = new boolean[m][n];
    TrieMap trieMap = new TrieMap();
    //add the words into trie
    for(String word: words){
      trieMap.addword(word);
    }
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        dfs(board, new StringBuilder(), i, j, trieMap.root);
      }
    }
    return res;
  }
  void dfs(char[][] board, StringBuilder sb, int row, int col, TrieNode root){
    //going over the boundary
    if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
      return;
    }
    //in case retracing
    if(visited[row][col]) return;
    //find the answer
    if(root.val != null){
      res.add(sb.toString());
      return;
    }

    char c = board[row][col];
    //check whether the current character is in the trie
    if(!root.children.containsKey(c)) return; //invalid

    visited[row][col] = true;

    TrieNode next = root.children.get(c);
    sb.append(c);
    //top traversal
    dfs(board, sb, row - 1, col, next);

    //bottom
    dfs(board, sb, row + 1, col, next);

    //left
    dfs(board, sb, row, col - 1, next);

    //right
    dfs(board, sb, row, col + 1, next);


    //undo
    visited[row][col] = false;

  }
  class TrieMap{

    TrieNode root = null;
    public TrieMap(){
      root = new TrieNode();
    }
    //the defualt value for the key is 1
    void addword(String key){
      TrieNode tmp = root;
      for(int i = 0; i < key.length(); i++){
        char c = key.charAt(i);
        // tmp.children[c - 'a'] = new TrieNode();
        tmp.children.put(c, new TrieNode());
        tmp = tmp.children.get(c);
        if(i == key.length() - 1){
          tmp.val = 1;
        }
      }
    }

  }
}
