package com.shady.Trees.PrefixTree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/22/16:22
 * @Description:
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class ImplementTrie {
  class Trie {
    TrieMap<String> trieMap;
    public Trie() {
      trieMap = new TrieMap<>();
    }

    public void insert(String word) {
        //map.put
      trieMap.put(word, "");
    }

    public boolean search(String word) {
        //return map.contains
      return trieMap.contains(word);
    }

    public boolean startsWith(String prefix) {
        //return map.hasKeyWithPrefix
      return trieMap.hasKeyWithPrefix(prefix);
    }
  }
}
