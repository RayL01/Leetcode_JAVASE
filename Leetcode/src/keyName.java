import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/12/18/16:46
 * @Description:
 */
public class keyName {
  public static void main(String[] args) {
    keyName keyName = new keyName();
    String[] keyName1 = new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"};
    String[] keyTime1 = new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
    List<String> res = keyName.alertNames(keyName1, keyTime1);
    System.out.println(res);
  }
  public List<String> alertNames(String[] keyName, String[] keyTime) {
    HashMap<String, HashMap<Integer, Integer>> map = new HashMap();
    Set<String> names = new HashSet();
    for(int i = 0; i < keyName.length; i++){
      String name = keyName[i];
      String time = keyTime[i];
      int hour;

      hour = Integer.valueOf(time.substring(0, 2));
      // if(time.substring(2).equals("00")){
      //     hour -= 1;
      // }
      if(!map.containsKey(name)){
        HashMap<Integer, Integer> timeMap = new HashMap<Integer, Integer>();
        timeMap.put(hour, 1);
        if(time.substring(2).equals("00")){
          timeMap.put(hour - 1, 1);
        }
        map.put(name, timeMap);
      }else{
        HashMap<Integer, Integer> timeMap = map.get(name);
        timeMap.put(hour, timeMap.getOrDefault(hour, 0) + 1);
        if(timeMap.get(hour) == 3){
          names.add(name);
        }
        if(time.substring(3).equals("00")){
          timeMap.put(hour - 1, timeMap.getOrDefault(hour - 1, 0) + 1);
        }
        if(timeMap.containsKey(hour - 1) && timeMap.get(hour - 1) == 3){
          names.add(name);
        }
      }
    }
    List<String> res = new ArrayList<String>(names);
    Collections.sort(res);
    return res;
  }
}
