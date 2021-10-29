package com.gameOfLife;

public class Board {
   private int[][] board;
    private int rows;
    private int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board=new int[rows][cols];

    }
    public int get(int row, int col){
        return board[row][col];
    }
    public void set(int row ,int col,int value){
        board[row][col]=value;

    }

    public int getRows(){
        return board.length;
    }

    public int getCols(){
        return board[0].length;
    }

    public String toString(){
        String boardResult="";
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols() ; col++) {
                boardResult+=board[row][col];
            }
            boardResult+= "\n";
        }
        return boardResult;
    }
}
