package org.example.application.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @BeforeEach
    void setUp() throws Exception {
        Method initBoard = TicTacToe.class.getDeclaredMethod("initBoard");
        initBoard.setAccessible(true);
        initBoard.invoke(null);
    }

    @Test
    void testInitBoard() throws Exception {
        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        char[][] board = (char[][]) boardField.get(null);
        for (char[] row : board) {
            for (char cell : row) {
                assertEquals(' ', cell);
            }
        }
    }

    @Test
    void testCheckWinnerRows() throws Exception {
        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        char[][] board = (char[][]) boardField.get(null);
        board[1][0] = board[1][1] = board[1][2] = 'X';

        Method checkWinner = TicTacToe.class.getDeclaredMethod("checkWinner", char.class);
        checkWinner.setAccessible(true);
        assertTrue((boolean) checkWinner.invoke(null, 'X'));
    }

    @Test
    void testCheckWinnerColumns() throws Exception {
        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        char[][] board = (char[][]) boardField.get(null);
        board[0][2] = board[1][2] = board[2][2] = 'O';

        Method checkWinner = TicTacToe.class.getDeclaredMethod("checkWinner", char.class);
        checkWinner.setAccessible(true);
        assertTrue((boolean) checkWinner.invoke(null, 'O'));
    }

    @Test
    void testCheckWinnerDiagonals() throws Exception {
        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        char[][] board = (char[][]) boardField.get(null);
        board[0][0] = board[1][1] = board[2][2] = 'X';

        Method checkWinner = TicTacToe.class.getDeclaredMethod("checkWinner", char.class);
        checkWinner.setAccessible(true);
        assertTrue((boolean) checkWinner.invoke(null, 'X'));
    }

    @Test
    void testIsDraw() throws Exception {
        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        char[][] board = (char[][]) boardField.get(null);
        char[][] drawBoard = {
            {'X', 'O', 'X'},
            {'X', 'O', 'O'},
            {'O', 'X', 'X'}
        };
        for (int i = 0; i < 3; i++)
            System.arraycopy(drawBoard[i], 0, board[i], 0, 3);

        Method isDraw = TicTacToe.class.getDeclaredMethod("isDraw");
        isDraw.setAccessible(true);
        assertTrue((boolean) isDraw.invoke(null));
    }

    @Test
    void testNotDrawIfEmptyCell() throws Exception {
        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        char[][] board = (char[][]) boardField.get(null);
        board[0][0] = 'X';
        board[0][1] = 'O';
        board[0][2] = 'X';
        board[1][0] = 'O';
        board[1][1] = 'X';
        board[1][2] = 'O';
        board[2][0] = 'O';
        board[2][1] = 'X';
        board[2][2] = ' ';

        Method isDraw = TicTacToe.class.getDeclaredMethod("isDraw");
        isDraw.setAccessible(true);
        assertFalse((boolean) isDraw.invoke(null));
    }
}