package com.gameOfLife;

import javax.swing.*;

public class Life {
    public static final int sleepTimer = 500;

    public static void initializeBoard(Board board) {
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getCols(); col++) {
                int randomVal = (int) (Math.random() * 3);
                if (randomVal == 0) {
                    board.set(row, col, 1);
                }
            }
        }
    }

    public static void calculateNextGeneration(Board board, Board newBoard) {
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getCols(); col++) {
                int numberOfNeighbors = countNeighbors(row, col, board);
                //existing cell dies if fewer than 2 neighbors
                if (board.get(row, col) == 1 && numberOfNeighbors < 2 ) {
                    newBoard.set(row, col, 0);
                }
                //existing cell dies if greater than 3 neighbors
                else if (board.get(row, col) == 1 && numberOfNeighbors > 3 ) {
                    newBoard.set(row, col, 0);
                }
                //existing cell lives if 2-3 neighbors
                else if (board.get(row, col) == 1 && numberOfNeighbors <= 3 ) {
                    newBoard.set(row, col, 1);
                }

            else if (board.get(row, col) == 0 && numberOfNeighbors == 3) {
                    newBoard.set(row, col, 1);
                }
                else {
                    newBoard.set(row, col, 0);
                }

            }

        }
    }

    public static int countNeighbors(int row, int col, Board board) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
                for (int c = col - 1; c <= col + 1; c++) {
                    if (c >= 0 && c < board.getCols() &&
                            r >= 0 && r < board.getRows() &&
                            !(r == row && c == col) &&
                            board.get(r, c) == 1) {
                        count=count+1;
                    }
                }
              }
        return count;

    }
    //used to replace the old generation with new one
    public static void transferNewToCurrent(Board board,Board newBoard){
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                board.set(r,c,newBoard.get(r,c));

            }

        }
    }

    public static void displayBoard(Board board) {
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getCols(); col++) {
                if (board.get(row, col) == 0) {
                    System.out.print("."+" ");
                } else {
                    System.out.print("*"+" ");
                }

            }
            System.out.println();
        }
    }

}
