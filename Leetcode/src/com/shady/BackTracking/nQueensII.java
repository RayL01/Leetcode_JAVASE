package com.shady.BackTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/02/06/13:09
 * @Description:
 * https://leetcode.com/problems/n-queens-ii/
 * Input : n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 */
public class nQueensII {
  //nested arraylist to store result
  int total = 0;
  public int totalNQueens(int n) {
    //First we should initialize the nested arraylist ('.' indicates empty)


    //Initialize the board with "."
    List<String> board = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String string = "";
      for (int j = 0; j < n; j++) {
        string += ".";
      }
      board.add(string);
    }
    backtrack(board, 0);
    return total;

  }
  void backtrack(List<String> board, int row){
    //The board has been filled with queens, and we should return.

    if(row == board.size()) {
      //Add the current board to the res arraylist
      //We should notice that each res[i] is pointing to the reference of a board, so
      //if we simply add board, any update on board would modify the data the res as well
      //Therefore, we should create a new object which is independent on the object board.
      total++;
      return;
    }

    //Then we should traverse the current row by loop

    //Calculate the size of the column
    int n = board.get(row).length();
    for (int column = 0; column < n; column++) {
      //We should determine whether the queen can stand on the current location
      if(!isQueen(board, row, column)) continue;

      //Then we should make a choice(do something) set the current location as the 'Q'
      String s = board.get(row).substring(0, column) + 'Q' + board.get(row).substring(column + 1);
      //Update the current row(placing a queen there)
      board.set(row, s);
      //Then we should jump into the decision tree at next row by doing recursive calls

      int nextrow = row + 1;
      backtrack(board, nextrow);

      //after the branch is over, we should undo our previous choices and jump into another acceptable column at current row.
      String s1 = board.get(row).substring(0,column) + '.' + board.get(row).substring(column + 1);

      //Don't forget to reset the board due to Java's String manipulation
      board.set(row, s1);




    }
  }
  boolean isQueen(List<String> board, int row, int column){
    //Since we are placing each queen from top to bottom, we only need to check upper left corner, upper right corner, and the upper rows.
    //Check the upper rows
    for (int i = 0; i < row ; i++) {
      if (board.get(i).charAt(column) == 'Q'){
        return false;
      }
    }

    //Check the upper left corner
    for(int i = row - 1, j = column - 1; i >=0 && j >= 0; i--, j--){
      if (board.get(i).charAt(j) == 'Q'){
        return false;
      }
    }

    //Check the upper right corner
    for (int i = row - 1, j  = column + 1; i >= 0 && j < board.size(); i--, j ++) {
      if (board.get(i).charAt(j) == 'Q'){
        return false;
      }
    }
    return true;
  }

}
