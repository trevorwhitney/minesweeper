package com.github.trevorwhitney.minesweeper;

import java.util.Scanner;
import java.util.concurrent.Callable;
import lombok.val;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
    name = "minesweeper",
    description = "command line version of the classic minesweeper game",
    version = "0.1.0",
    mixinStandardHelpOptions = true)
public class App implements Callable<Integer> {
  @Option(
      names = {"-r", "--rows"},
      description = "Number of rows for the minesweeper board")
  private Integer rows = 5;

  @Option(
      names = {"-c", "--columns"},
      description = "Number of columns for the minesweeper board")
  private Integer columns = 5;

  @Option(
      names = {"-v", "--verbose"},
      description = "Print verbose output")
  private boolean verbose;

  @Option(
      names = {"-m", "--mines"},
      description = "Number of mines to place on the board")
  private Integer mines = rows * columns / 4;

  public static void main(String[] args) {
    int exitCode = new CommandLine(new App()).execute(args);
    System.exit(exitCode);
  }

  @Override
  public Integer call() {
    if (verbose) {
      System.out.println("rows = " + rows);
      System.out.println("columns = " + columns);
      System.out.println("mines = " + mines);
    }
    val board = Board.builder().rows(rows).columns(columns).mines(mines).build();

    int result = 0;
    while (result != -1) {
      System.out.println(board.printBoard());

      val sc = new Scanner(System.in);
      System.out.print("Enter next move as comma separated value row,column: ");
      String str = sc.nextLine();
      if (str.equals("exit")) {
        return 0;
      }

      String[] coordinates = str.split(",");
      result = board.makeMove(Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[0]));
    }

    return 0;
  }
}
