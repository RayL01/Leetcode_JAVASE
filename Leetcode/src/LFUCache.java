import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/14/23:24
 * @Description:
 */
public class LFUCache {
  HashMap<Integer, Integer> keyToVal;
  HashMap<Integer, Integer> keyToFreq;
  HashMap<Integer, LinkedHashSet> freqToKeys;
  int capacity;
  int minFreq;

  public LFUCache(int capacity){
    this.capacity = capacity;
    keyToVal = new HashMap<>();
    keyToFreq = new HashMap<>();
    freqToKeys = new HashMap<Integer, LinkedHashSet>();
  }
  public int get(int key){
    if(!keyToVal.containsKey(key)){
      return -1;
    }
    increaseKeyFreq(key);
    return keyToVal.get(key);
  }

  /**
   * increase the frequency of the key
   * 1. increase keyToFreq by 1
   * 2. delete the older freq in the freqTokeys
   * if that list becomes empty after deleted, delete that whole list
   * and also if the deleted freq equals to the minFreq, we should update
   * minFreq++ since we are also inserting a freq + 1 in the freqToKeys
   * 3. insert the new freq into freqToKeys
   *
   * @param key
   */
  private void increaseKeyFreq(int key){
    int prevFreq = keyToFreq.get(key);
    keyToFreq.put(key, prevFreq + 1);

    freqToKeys.get(prevFreq).remove(key);
    if(freqToKeys.get(prevFreq).isEmpty()){
      freqToKeys.remove(freqToKeys);
      if(prevFreq == this.minFreq) minFreq++;
    }
    freqToKeys.putIfAbsent(prevFreq + 1, new LinkedHashSet<>());
    freqToKeys.get(prevFreq + 1).add(key);

  }

  /**
   * update the (key, val) pair
   * 1. if this pair already exists:
   * a. change keyToVal
   * b. increase keyToFreq
   * c. call increaseKeyFreq
   *
   * 2. if this pair does not exist
   * determine whether the capacity has been reached
   * a. if not (update keyToVal, keyToFreq(1), freqToKeys)
   * b. otherwise call removeMinFreq()
   * (update keyToVal, keyToFreq(1), freqToKeys)
   * @param key
   * @param value
   */
  public void put(int key, int value){
    if(keyToVal.containsKey(key)){
      keyToVal.put(key, value);
      increaseKeyFreq(key);
      return;
    }

    //non existing
    if(this.capacity == keyToVal.size()){
      removeMinFreq();
    }
    keyToVal.put(key, value);
    keyToFreq.put(key, 1);
    freqToKeys.putIfAbsent(1, new LinkedHashSet());
    freqToKeys.get(1).add(key);
    minFreq = 1;



  }

  /**
   * remove the key with the minfreq from the freqToKeys, keyToVal, keyToFreq
   */
  private void removeMinFreq(){


    LinkedHashSet<Integer> linkedHashSet = freqToKeys.get(minFreq);
    Integer deletedKey = linkedHashSet.iterator().next();
    linkedHashSet.remove(deletedKey);
    if(linkedHashSet.isEmpty()){
      freqToKeys.remove(minFreq);
      //there's no need to update minFreq here, since we only call this method within put()
      // and minFeq would always be updated to 1 after removeMinFreq being called
    }
    keyToVal.remove(deletedKey);
    keyToFreq.remove(deletedKey);


  }


}
