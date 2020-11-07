package com.github.trevorwhitney.minesweeper;

import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
    name = "minesweeper",
    description = "command line version of the classic minesweeper game",
    version = "0.1.0",
    mixinStandardHelpOptions = true
)
public class App implements Callable<Integer> {
    @Option(names = {"-r", "--rows"}, description = "Number of rows for the minesweeper board")
    private Integer rows = 5;

    @Option(names = {"-c", "--columns"}, description = "Number of columns for the minesweeper board")
    private Integer columns  = 5;

    @Option(names = {"-v", "--verbose"}, description = "Print verbose output")
    private boolean verbose;

    @Option(names = {"-m", "--mines"}, description = "Number of mines to place on the board")
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
        System.out.println(buildBoard());
        return 0;
    }

    public String buildBoard() {
        StringBuilder board = new StringBuilder();
        for(int r = 0; r < rows; r++) {
            board.append("x ".repeat(Math.max(0, columns)));
            board.append("\n");
        }

        return board.toString();
    }
}
