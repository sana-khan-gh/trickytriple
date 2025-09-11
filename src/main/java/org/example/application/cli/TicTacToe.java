package org.example.application.cli;

import java.util.Scanner;

/**
 * A simple command-line Tic-Tac-Toe game for two players.
 * Players take turns to enter their moves until one wins or the game is a draw.
 */
public class TicTacToe {
    /**
     * The size of the Tic-Tac-Toe board (3x3).
     */
    private static final int SIZE = 3;
    /**
     * The game board.
     */
    private static char[][] board = new char[SIZE][SIZE];

    /**
     * The main entry point for the Tic-Tac-Toe game.
     * Handles user input and manages the game loop.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            initBoard();
            System.out.print("Player 1, choose your symbol (X/O): ");
            char player1 = scanner.nextLine().trim().toUpperCase().charAt(0);
            char player2 = (player1 == 'X') ? 'O' : 'X';
            char currentPlayer = player1;
            boolean gameEnded = false;

            while (!gameEnded) {
                printBoard();
                System.out.println("Player " + (currentPlayer == player1 ? "1" : "2") + " (" + currentPlayer + ") turn.");
                int row, col;
                while (true) {
                    System.out.print("Enter row (0-2): ");
                    row = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter column (0-2): ");
                    col = Integer.parseInt(scanner.nextLine());
                    if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == ' ') {
                        board[row][col] = currentPlayer;
                        break;
                    } else {
                        System.out.println("Invalid move, try again.");
                    }
                }
                if (checkWinner(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + (currentPlayer == player1 ? "1" : "2") + " (" + currentPlayer + ") wins!");
                    gameEnded = true;
                } else if (isDraw()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            }
            System.out.println("Restarting game...\n");
        }
    }

    /**
     * Initializes the game board to empty cells.
     */
    private static void initBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = ' ';
    }

    /**
     * Prints the current state of the game board to the console.
     */
    private static void printBoard() {
        System.out.println("   0   1   2");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < SIZE - 1) System.out.print("|");
            }
            System.out.println();
            if (i < SIZE - 1) System.out.println("  ---+---+---");
        }
    }

    /**
     * Checks if the specified player has won the game.
     *
     * @param player the player's symbol ('X' or 'O')
     * @return true if the player has won, false otherwise
     */
    private static boolean checkWinner(char player) {
        for (int i = 0; i < SIZE; i++)
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    /**
     * Checks if the game is a draw (no empty cells left).
     *
     * @return true if the game is a draw, false otherwise
     */
    private static boolean isDraw() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }
}