import org.junit.Test;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/10/19:00
 * @Description:
 */
public class findCheapeastPrice {
  @Test
  public void test5(){
    String s = "123";
    System.out.println(s.substring(3));
    StringBuilder sb = new StringBuilder();

  }
  @Test
  public void test(){
    int res = findCheapestPrice(
            4,
            new int[][]{
                    {0, 1, 1,},
                    {0, 2, 5},
                    {1, 2, 1},
                    {2, 3, 1}
            },
            0, 3, 1
            );
    System.out.println(res);
  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<int[]>[] graph =  new List[n];

    for(int i = 0; i < n; i++){
      graph[i] = new ArrayList<>();
    }

    for(int[] flight: flights){
      int from = flight[0];
      int to = flight[1];
      int dist = flight[2];
      graph[from].add(new int[]{to, dist});

    }
    return dijkstra(graph, src, dst, k);


  }
  private int dijkstra(List<int[]> []graph, int src, int dst, int k){
    PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(a -> a.distFromStart));
    int[] distFromSrc = new int[graph.length];
    Arrays.fill(distFromSrc, Integer.MAX_VALUE);
    distFromSrc[src] = 0;
    int[] stepsFromStart = new int[graph.length];
    Arrays.fill(stepsFromStart, Integer.MAX_VALUE);
    stepsFromStart[src] = 0;
    String s ="123";

    //add the starting point
    pq.add(new Node(src, 0, 0));
    while(!pq.isEmpty()){
      Node node = pq.poll();
      if(node.id == dst){
        return node.distFromStart;
      }
//      if(node.step){
//        continue;
//      }
      for(int[] edge: graph[node.id]){
        //here we check all the neighbors of the current node
        int neighborId = edge[0];
        int distToNeighbor = edge[1];


          if(node.distFromStart + distToNeighbor < distFromSrc[neighborId]){
            distFromSrc[neighborId] = node.distFromStart + distToNeighbor;
            stepsFromStart[neighborId] = node.step + 1;
          }
          //trimming
          if(node.distFromStart + distToNeighbor > distFromSrc[neighborId] && node.step + 1 > stepsFromStart[neighborId]){
            continue;
          }
          pq.offer(new Node(neighborId, node.distFromStart + distToNeighbor, node.step + 1));
      }
    }
    return -1;
  }
  class Node{
    //node number
    int id;


    //sum of distance from the starting point
    int distFromStart;

    //# of steps required to get to this point
    int step;
    public Node(int id, int distFromStart, int step){
      this.id = id;
      this.distFromStart = distFromStart;
      this.step = step;
    }
  }
}
