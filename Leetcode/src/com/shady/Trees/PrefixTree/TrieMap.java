package com.shady.Trees.PrefixTree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/22/16:33
 * @Description:
 */
public class TrieMap<T> {
  //The number of ASCII code
  private static final int R = 256;

  //The number of keys in the map
  private int size = 0;

  private TrieNode<T> root = null;
  private static class TrieNode<T>{
    T val = null;
    TrieNode<T> [] children = new TrieNode[R];
  }

  public void put(String key, T val){
    if(contains(key)){
      size ++;
    }
    root = put(root,key, val, 0);
  }
  private TrieNode<T> put(TrieNode<T> node, String key, T val, int i){
    if(node == null){
      //If the node doesn't exist, create a new one
      node = new TrieNode<>();
    }
    if(i == key.length()){
      node.val = val;
      return node;
    }


    char c = key.charAt(i);
    node.children[c] = put(node.children[c], key, val, i + 1);
    return node;
  }

  public boolean contains(String key){
    return get(key) != null;

  }
  private T get(String key){
    TrieNode<T> s = getNode(root, key);
    if(s == null || s.val == null){
      return null;
    }
    return s.val;
  }

  /**
   * Search for the key from the given node. If exists, return the node, otherwise return null
   * @param node
   * @param key
   * @return
   */
  private TrieNode<T> getNode(TrieNode<T> node,String key){
    TrieNode<T> cur = node;
    for (int i = 0; i < key.length(); i++) {
      if(cur == null){
        return null;
      }
      char c = key.charAt(i);
      cur = cur.children[c];
    }
    //after the loop, return cur;
    return cur;
  }

  /**
   * determine whether there's a word with a prefix of the given string
   * @param prefix
   * @return
   */
  public boolean hasKeyWithPrefix(String prefix){
    return getNode(root,prefix) != null;
  }


}
