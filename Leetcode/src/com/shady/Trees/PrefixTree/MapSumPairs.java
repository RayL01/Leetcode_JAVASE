package com.shady.Trees.PrefixTree;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/02/01/21:10
 * @Description: Solved by Trie(Prefix Tree)
 * https://leetcode.com/problems/map-sum-pairs/
 */
public class MapSumPairs {
  class MapSum {

    private TrieMap<Integer> map;
    public MapSum() {
      map =  new TrieMap();
    }

    public void insert(String key, int val) {
      map.put(key,val);
    }

    public int sum(String prefix) {
      List<String> strings = map.keysWithPrefix(prefix);
      int sum = 0;
      for (String s: strings
      ) {
        sum += map.get(s);
      }
      return sum;
    }
  }
}
