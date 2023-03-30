package LinkedList;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;

        //If it exists, we should mark it as most recently used
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);

            makeRecently(key);

            return;
        }else{
            //First we should check the size of the cache
            if(cache.size() >= cap){
                Integer head = cache.keySet().iterator().next();
                cache.remove(head);
                cache.put(key,value);
            }
            else{
                cache.put(key,value);
            }
        }
    }
    private void makeRecently(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
