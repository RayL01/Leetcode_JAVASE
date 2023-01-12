package com.shady.Graph.unionFind;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/11/21:56
 * @Description: The template for Union Find problems
 */
public class UF {
  private int count;//存储节点的个数
  private int[] parents;

  public UF(int count) {
    this.count = count;//初始化
    this.parents = new int[count];
    for (int i = 0; i < count; i++) {
      parents[i] = i;//the parent of each node is initialized as itself
    }
  }
  public void union(int p, int q){
      int rootP = find(p);
      int rootQ = find(q);

      if (rootP == rootQ) return;
      parents[rootQ] = rootP;
      count--;
  }
  public int find(int s){
    if(parents[s] != s){
      parents[s] = find(parents[s]);
    }
    return parents[s];
  }
  public boolean connected(int p, int q){
    int rootP = find(p);
    int rootQ = find(q);
    return rootP == rootQ;
  }

  public int count(){
    return this.count;
  }
}
