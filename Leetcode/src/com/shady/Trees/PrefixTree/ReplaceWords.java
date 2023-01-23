package com.shady.Trees.PrefixTree;

import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/22/18:58
 * @Description:Replace words solved by Trie(prefix tree).
 * https://leetcode.com/problems/replace-words/
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 */
public class ReplaceWords {
  public String replaceWords(List<String> dictionary, String sentence) {
    TrieMap<String> trieMap = new TrieMap<>();
    String[] strings = sentence.split(" ");

    //Then we add all the prefixes onto our Trie;
    for (String s : dictionary
         ) {
      trieMap.put(s, "key");
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < strings.length; i++) {
      String cur = trieMap.shortestPrefixOf(strings[i]);
      if(cur.isEmpty()){
        stringBuilder.append(strings[i]);
      }else{
        stringBuilder.append(cur);
      }

      //Then we add a blank space between each word, but we should notice that
      //there's no blank space behind the last word
      if(i != strings.length - 1) stringBuilder.append(" ");
    }
    return stringBuilder.toString();
  }
  @Test
  public void test(){

  }
}
