import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/12/17/15:19
 * @Description:
 */
public class longestHappyString {
  class Pair{
    char type;
    int num;
    public Pair(char type, int num){
      this.type = type;
      this.num = num;
    }
  }

  public static void main(String[] args) {
    longestHappyString longestHappyString = new longestHappyString();
    String res = longestHappyString.longestDiverseString(1, 1, 7);
    System.out.println(res);
    Set set = new HashSet();
    List list = new ArrayList(set);
    //sort it in ascending alphabetical order
  }

  //Greedy algorithm
  public String longestDiverseString(int a, int b, int c) {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> y.num - x.num);

    if(a > 0){
      pq.add(new Pair('a', a));
    }
    if(b > 0){
      pq.add(new Pair('b', b));
    }
    if(c > 0){
      pq.add(new Pair('c', c));
    }
    StringBuilder sb = new StringBuilder();
    while(!pq.isEmpty()){
      Pair p = pq.poll();
      int curNum = p.num;
      if(sb.length() >= 2 && sb.charAt(sb.length() - 1) == p.type && sb.charAt(sb.length() - 2) == p.type){
        //the previous two characters are equal to the current largest char
        //In this case, we move to the next greater character in the pq

        //first, we gonna check if the pq is empty or not
        if(pq.isEmpty()){
          break;
        }else{
          Pair p2 = pq.poll();
          sb.append(p2.type);
          if(p2.num > 1){
            pq.add(new Pair(p2.type, p2.num - 1));
          }
        }
      }else{
        sb.append(p.type);
        curNum--;
      }
      if(curNum != 0){
        pq.add(new Pair(p.type, curNum));
      }
    }
    return sb.toString();
  }
}
