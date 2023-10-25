import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/02/10:54
 * @Description:
 */
public class test2 {
  List<Integer> getPopularityOrder(List<List<Integer>> songPreferences) {
    int nSong = songPreferences.get(0).size();
    int[][] pref = new int[nSong][nSong];
    for (List<Integer> p : songPreferences) {
      Set<Integer> seen = new HashSet<>();
      for (int song : p) {
        for (int s : seen) {
          pref[s][song]++;
        }
        seen.add(song);
      }
    }
    int[] beat = new int[nSong];
    for (int i = 0; i < nSong; i++) {
      for (int j = i + 1; j < nSong; j++) {
        if (pref[i][j] > songPreferences.size() / 2) {
          beat[i]++;
        } else if (pref[i][j] == songPreferences.size() / 2) {
          beat[i]++;
        } else {
          beat[j]++;
        }
      }
    }
    List<Pair> songs = new ArrayList<>();
    for (int i = 0; i < nSong; i++) {
      songs.add(new Pair(beat[i], -i));
    }
    Collections.sort(songs);
    int[] result = new int[nSong];
    for (int i = 0; i < nSong; i++) {
      result[i] = -songs.get(i).second;
    }
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < result.length; i++) {
      res.add(result[i]);
    }
    return res;
  }

  class Pair implements Comparable<Pair> {
    int first, second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
      if (this.first != o.first) {
        return o.first - this.first; // For descending order
      }
      return this.second - o.second;
    }
  }
}

