package com.weiqian.leetcodesolutions.algorithm;

/*
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 * board =
 * [
 *  ['A','B','C','E'],
 *  ['S','F','C','S'],
 *  ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 */

public class A79_WordSearch {

    public boolean exist(char[][] board, String word) {

        // Step1: Corner case
        if(board == null && word != null) return false;
        if(board.length == 0 && word.length() != 0) return false;

        // Step2: Since each letter can be use at most once, need a matrix to record used or not
        boolean[][] visit = new boolean[board.length][board[0].length];

        // Step3: For every cell, treat this cell as a start point, because the search can start from anywhere
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){

                if(existFromSomewhere(board, word, visit, 0, i, j)) return true;
            }
        }

        return false;

    }

    // need a index to keep tracking which letter of this word that we're currently looking
    public boolean existFromSomewhere(char[][] board, String word, boolean[][] visit, int charIndex, int row, int col){
        if(charIndex == word.length()) return true;
        if(row > board.length-1 || row < 0) return false;
        if(col > board[0].length-1 || col < 0) return false;
        if(word.charAt(charIndex) != board[row][col]) return false;
        if(visit[row][col]) return false;

        visit[row][col] = true;

        // search towards 4 directions.
        if(existFromSomewhere(board, word, visit, charIndex+1, row, col+1)
                || existFromSomewhere(board, word, visit, charIndex+1, row, col-1)
                || existFromSomewhere(board, word, visit, charIndex+1, row-1, col)
                || existFromSomewhere(board, word, visit, charIndex+1, row+1, col)) return true;

        visit[row][col] = false;
        return false;
    }





    /*
     * Backtracking
     */
    private char[][] board;
    private int ROWS;
    private int COLS;

    public boolean exist2(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row)
            for (int col = 0; col < this.COLS; ++col)
                if (this.backtrack(row, col, word, 0))
                    return true;
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
        /* Step 1). check the bottom case. */
        if (index >= word.length())
            return true;

        /* Step 2). Check the boundaries. */
        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
                || this.board[row][col] != word.charAt(index))
            return false;

        /* Step 3). explore the neighbors in DFS */
        boolean ret = false;
        // mark the path before the next exploration
        this.board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
            if (ret)
                break;
        }

        /* Step 4). clean up and return the result. */
        this.board[row][col] = word.charAt(index);
        return ret;
    }
}
