package com.gameOfLife;

public class GameOfLife {
    public static void main(String[] args) throws InterruptedException {
        final int rows=5;
        final int cols=6;
        Board board=new Board(rows,cols);
        Board newBoard=new Board(rows,cols);
        Life.initializeBoard(board);

      for (int i = 0; i < 20; i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Life.displayBoard(board);
            Thread.sleep(500);
            Life.calculateNextGeneration(board,newBoard);
            Life.transferNewToCurrent(board,newBoard);
            System.out.println();
            System.out.println();

        }

    }
}
