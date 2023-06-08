/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/06/08/14:53
 * @Description:
 */

import java.util.Scanner;

/**
 * Cisco OA
 * Algorithm Question1:
 * You are given a grid of letters, followed by some words. The words can occur anywhere in the grid on a row or a colmun. However, there are no diagonal words. Write an algorithm to find if the given word occurs in the grid on arow or a column, forward or backwards
 *
 * Input The first line of input consists of two integers grid_row and grid_col, representing the number of columns(M) and the number of rows(N) of the letter grid, respectively. The next M lines consist of N space-separated characters representing the letters of the grid. The next line consists of an integer word_size, representing the number of words to be searched from the given grid(K) The last line consists of K space-separated strings representing the words to search for in the grid.
 *
 * Output Print L space-separated strings consisting of “Yes” if the word is present in the grid of “No” if the word is not present in the grid.
 *
 * Note All the inputs are case-sensitive, meaning “a” and “A” are considered as two different characters/
 *
 * Example
 * Input:
 * 3 3
 * C A T
 * I D O
 * N O M
 * 4
 * CAT TOM ADO MOM
 *
 * Output:
 * Yes Yes Yes No
 *
 * Explanation: From the given words “CAT” is found at the first row, “TOM” is found at last column, “ADO” is found at the middle column, but “MOM” is not found anywhere in the grid. So, the output is [“Yes”, “Yes”, “No”]
 */
class Question1 {
  public static boolean wordInStr(String str, String word) {
    return str.contains(word) || new StringBuilder(str).reverse().toString().contains(word);
  }

  public static void  funcPuzzle(char[][] grid, String[] words)
  {
    // Create rows and columns strings
    String[] rows = new String[grid.length];
    String[] cols = new String[grid[0].length];

    // Initialize rows and cols with empty strings
    for (int i = 0; i < grid.length; i++)
      rows[i] = "";
    for (int i = 0; i < grid[0].length; i++)
      cols[i] = "";

    // Fill rows and cols with grid characters
    for(int i = 0; i < grid.length; i++)
    {
      for(int j = 0; j < grid[i].length; j++)
      {
        rows[i] += grid[i][j];
        cols[j] += grid[i][j];
      }
    }

    for (String word : words) {
      boolean found = false;
      // Check rows and cols
      for (int i = 0; i < grid.length && !found; i++)
        if (wordInStr(rows[i], word) || wordInStr(cols[i], word))
          found = true;
      System.out.print((found ? "Yes" : "No") + " ");
    }
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    // input for grid
    int grid_row = in.nextInt();
    int grid_col = in.nextInt();
    char grid[][] = new char[grid_row][grid_col];
    for(int idx = 0; idx < grid_row; idx++)
    {
      for(int jdx = 0; jdx < grid_col; jdx++)
      {
        grid[idx][jdx] = in.next().charAt(0);
      }
    }
    //input for word
    int word_size = in.nextInt();
    String word[] = new String[word_size];
    for(int idx = 0; idx < word_size; idx++)
    {
      word[idx] = in.next();
    }


    funcPuzzle(grid, word);
    in.close();
  }

}