package com.shady.Trees.PrefixTree;

import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/24/23:27
 * @Description:
 * https://leetcode.com/problems/implement-trie-ii-prefix-tree/
 * Implement the Trie class:2
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * int countWordsEqualTo(String word) Returns the number of instances of the string word in the trie.
 * int countWordsStartingWith(String prefix) Returns the number of strings in the trie that have the string prefix as a prefix.
 * void erase(String word) Erases the string word from the trie.
 */
public class ImplementTrieII<T> {
  class Trie<T> {
    TrieMap<Integer> trieMap;
    public Trie() {
      trieMap = new TrieMap<>();
    }

    /**
     * Inserts the string word into the trie
     * @param word
     */
    public void insert(String word) {
        if(!trieMap.contains(word)){
          trieMap.put(word, 1);
        }else{
          trieMap.put(word, trieMap.get(word) + 1);
        }
    }


    /**
     * Returns the number of instances of the string word in the trie.
     * @param word
     * @return
     */
    public int countWordsEqualTo(String word) {
        if(!trieMap.contains(word)) return 0;
        return trieMap.get(word);
    }

    /**
     * Returns the number of strings in the trie that have the string prefix as a prefix.
     * @param prefix
     * @return
     */

    public int countWordsStartingWith(String prefix) {
      List<String> strings = trieMap.keysWithPrefix(prefix);
      int sum = 0;
      for (String s: strings
           ) {
        sum += trieMap.get(s);
      }
      return sum;
    }


    /**
     *  Erases the string word from the trie. (Decrease the number of it if total number is larger than 1)
     * @param word
     */
    public void erase(String word) {

      if(trieMap.get(word)==null) return;
      if(trieMap.get(word) > 1){
        trieMap.put(word, trieMap.get(word) - 1);
      }else{
        trieMap.remove(word);
      }


      /**
       * int freq = trieMap.get(word);
       *       if (freq - 1 == 0) {
       *         trieMap.remove(word);
       *       } else {
       *         trieMap.put(word, freq - 1);
       *       }
       *     }
       */

    }
  }
  @Test
  public void test(){
    Trie trie = new Trie();
    trie.insert("apple");
    trie.insert("apple");
    int i  = trie.countWordsEqualTo("apple");
    System.out.println(i);
    System.out.println(trie.countWordsStartingWith("app"));
  }
  @Test
  public void  test1(){
    System.out.println((int)'a');
  }
}
