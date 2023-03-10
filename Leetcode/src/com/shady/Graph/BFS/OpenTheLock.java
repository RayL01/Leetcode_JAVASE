package com.shady.Graph.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/open-the-lock/
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            visited.add(deadends[i]);
        }


        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();


                if(target.equals(cur)){
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                     String up = pullUp(cur, j);
                     if(!visited.contains(up)){
                         q.offer(up);
                         visited.add(up);
                     }
                     String down = pullDown(cur, j);
                     if(!visited.contains(down)){
                         q.offer(down);
                         visited.add(down);
                     }
                }

            }
            step++;
        }
        return -1;
    }
    private String pullUp(String s, int position){
        char[] chars = s.toCharArray();
        if(chars[position] == '9'){
            chars[position] = '0';
        }else{
            chars[position] += 1;
        }

        return chars.toString();
    }
    private String pullDown(String s, int position){
        char[] chars = s.toCharArray();
        if(chars[position] == '0'){
            chars[position] = '9';
        }else{
            chars[position] -= 1;
        }

        return new String(chars);
    }

}
