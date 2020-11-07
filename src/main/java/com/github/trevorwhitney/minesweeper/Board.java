package com.github.trevorwhitney.minesweeper;

import java.util.Random;
import lombok.Builder;

public class Board {
  private final Integer rows;
  private final Integer columns;

  private final int[][] board;
  private final Random random = new Random();

  @Builder
  public Board(Integer rows, Integer columns, Integer mines) {
    this.rows = rows;
    this.columns = columns;

    board = new int[columns][rows];

    for (int i = 0; i < mines; i++) {
      int r = random.nextInt(rows);
      int c = random.nextInt(columns);
      while (board[c][r] != 0) {
        r = random.nextInt(rows);
        c = random.nextInt(columns);
      }

      board[c][r] = -1;
    }
  }

  public String printBoard() {
    StringBuilder boardString = new StringBuilder("\t");
    for (int r = -1; r < rows; r++) {
      if (r == -1) {
        for (int c = 0; c < columns; c++) {
          boardString.append(" " + c);
        }
      } else {
        for (int c = 0; c < columns; c++) {
          if (c == 0) {
            if (board[c][r] == -1) {
              boardString.append(r + "\t M ");
            } else {
              boardString.append(r + "\t x ");
            }
          } else {
            if (board[c][r] == -1) {
              boardString.append("M ");
            } else {
              boardString.append("x ");
            }
          }
        }
      }
      boardString.append("\n");
    }

    return boardString.toString();
  }

  public Integer makeMove(int r, int c) {
    return board[c][r];
  }
}
