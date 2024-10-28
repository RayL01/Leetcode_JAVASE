import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/28/16:44
 * @Description:
 */
public class RandomPickWithBlackList {
  int[] num;
  int blackSize;
  int last;
  Map<Integer, Integer> map;

  public static void main(String[] args) {
    RandomPickWithBlackList randomPickWithBlackList = new RandomPickWithBlackList(2, new int[]{});
    for (int i = 0; i < 10; i++) {
      randomPickWithBlackList.pick();
    }
  }


  public RandomPickWithBlackList(int n, int[] blacklist) {
    num = new int[n];
    blackSize = blacklist.length;
    last = num.length - 1;
    map = new HashMap();
    int i = 0;
    while(i != num.length){
      num[i] = i;
      i++;
    }
    for(int x : blacklist){
      map.put(x, Integer.MIN_VALUE);//make sure those keys already exist for the later use
    }
    for(int m : blacklist){
      if(m >= num.length - blackSize){
        continue;
      }
      while(map.containsKey(last)){
        last--;
      }
      map.put(m, last);
      last--;
    }

  }

  public int pick() {
    int randomNum = (int) Math.random() * (num.length - blackSize);
    return map.containsKey( randomNum ) ? map.get(randomNum) : randomNum;

  }

}

