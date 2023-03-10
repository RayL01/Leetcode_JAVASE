package com.shady.BackTracking;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }
    private boolean backtrack(char[][] board, int i, int j){
        int m = 9, n = 9; //size of the board
        //set up the base case
        if(j == n){
            //backtrack to the next row
           return backtrack(board, i + 1, 0);


        }
        if(i == m) return true;

        if(board[i][j] != '.'){ //It's the pre-filled number on the board and we just jump to the next column
            return backtrack(board,i, j + 1);

        }

        for (char ch = '1'; ch <= '9';ch ++) {
            if(!isValid(board, i, j, ch)){//Invalid, jump to the next choice
                continue;

            }
            //make a choice here
            board[i][j] = ch;


            if(backtrack(board, i, j + 1)){
                return true;//avoid iterating through the loop
            }



            //Undo our choice
            board[i][j] = '.';

        }
        return false;
    }
    boolean isValid(char[][] board, int i, int j, char a){
        //Here we should determine whether there are duplicates
        // in the current row, column, and 3 * 3 grid that of the current position
        for (int k = 0; k < 9; k++) {
            //Determine whether there are duplicates in the row
            if(board[i][k] == a) return false;

            //Determine whether there are duplicates in the column
            if(board[k][j] == a) return false;

            //Determine whether there are duplicates in the 3 * 3 grid that the current position locates at
            if(board[(i/3) * 3 + k / 3][(j/3) * 3 + k % 3] == a) return  false;
        }
        return true;
    }
}
