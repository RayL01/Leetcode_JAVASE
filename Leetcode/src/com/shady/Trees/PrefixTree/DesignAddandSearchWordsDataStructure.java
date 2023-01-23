package com.shady.Trees.PrefixTree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/22/19:20
 * @Description: Solved by Prefix tree
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class DesignAddandSearchWordsDataStructure {
  class WordDictionary {
    TrieMap<String> trieMap;

    public WordDictionary() {
      trieMap = new TrieMap<>();
    }

    public void addWord(String word) {
      trieMap.put(word, "key");
    }

    public boolean search(String word) {
      return trieMap.HaskeyWithPattern(word);
    }
  }

}
