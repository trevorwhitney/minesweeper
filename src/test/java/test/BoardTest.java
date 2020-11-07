package test;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.trevorwhitney.minesweeper.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {
  @Test
  @DisplayName("makeMove returns 1 if there is no mine in the spot")
  public void makeMove_1() {
    Board board = Board.builder().rows(1).columns(2).mines(0).build();
    assertThat(board.makeMove(0, 1)).isEqualTo(0);
  }

  @Test
  @DisplayName("makeMove returns -1 if there is no mine in the spot")
  public void makeMove_2() {
    Board board = Board.builder().rows(1).columns(2).mines(2).build();
    assertThat(board.makeMove(0, 1)).isEqualTo(-1);
  }
}
