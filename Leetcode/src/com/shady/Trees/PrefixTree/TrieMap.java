package com.shady.Trees.PrefixTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/22/16:33
 * @Description:
 */
public class TrieMap<T> {
  //The number of ASCII code
  private static final int R = 26;

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
    node.children[c - 'a'] = put(node.children[c - 'a'], key, val, i + 1);
    return node;
  }

  public boolean contains(String key){
    return get(key) != null;

  }
  public T get(String key){
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
      cur = cur.children[c - 'a'];
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


  /**
   * Find the shortest prefix of the given string in the map
   * @param query
   * @return
   */
  public String shortestPrefixOf(String query){
    TrieNode<T> cur = root;


    for (int i = 0; i < query.length(); i++) {
      if(cur == null) return ""; //exception
      if(cur.val != null) return query.substring(0,i);
      char c = query.charAt(i);
      cur = cur.children[c - 'a'];

    }
    //However, the loop above does not include the case when the tree contains a prefix of the whole string
    //In this case, we should determine whether cur.val is null. If so, we must return the whole string as the prefix
    if(cur != null && cur.val != null){
      return query;
    }
    return "";


  }

  public boolean HaskeyWithPattern(String pattern){
    return HaskeyWithPattern(root, pattern, 0);
  }
  public boolean HaskeyWithPattern(TrieNode<T> node, String pattern, int i){
    if(node == null) return false;
    if(i == pattern.length()){
      return node.val != null;
    }
    char c = pattern.charAt(i);
    //Then, we should determine the type of the current letter
    if(c == '.'){
      for (int j = 0; j < R; j++) {
        if(HaskeyWithPattern(node.children[j],pattern,i+1))return true;
      }
    }else{
      return HaskeyWithPattern(node.children[c - 'a'],pattern, i + 1);
    }
    return false;
  }

  /**
   * return the list of keys with the given prefix
   * @param prefix
   * @return
   */
  public List<String> keysWithPrefix(String prefix){
    List<String> res = new ArrayList<>();
    //First, we should reach the node at the end of the prefix
    TrieNode<T> x = getNode(root, prefix);
    traverse(x, new StringBuilder(prefix), res); //注意，这里我们需要将StringBuilder初始化为(new Stringbuilder(prefix)
    return res;
  }
  public void traverse(TrieNode<T> node, StringBuilder path, List<String> res){
    if(node == null) return;
    if(node.val != null){
      res.add(path.toString());
    }


    for(char c = 'a'; c < 'a' + R; c ++){
      path.append(c);
      traverse(node.children[c - 'a'],path, res);
      path.deleteCharAt(path.length() - 1);
    }
  }

  public void remove(String key){
    if(!contains(key)) return;

    root = remove(root,key,0);
    size--;
  }





  /**
   * delete the key from the tree
   * @param key
   */
  public TrieNode<T> remove(TrieNode<T> node, String key,int i){
    //In order to remove the node, we should assign null to each of them.
    //We can use postorder traverse to finish it(node. child = remove()   )
    if(node == null){
      return null;
    }
    if(i == key.length()){
      node.val = null;
    }else{
      char c = key.charAt(i);
      node.children[c - 'a'] = remove(node.children[c - 'a'],key, i+ 1);
    }

    if(node.val != null){
      return node;
    }

    for (int j = 0; j < R; j++) {
      if(node.children[j] != null){
        return node;
      }
    }
    return null;
  }


}
