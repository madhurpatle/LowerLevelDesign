package TicTacToe;

import TicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Piece crossPiece = new PieceX();
        Piece zeroPiece = new PieceO();

        Player player1 = new Player("Madhur", crossPiece);
        Player player2 = new Player("Pallavi", zeroPiece);

        Deque<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);

        int boardSize = 3;

        TicTacToeGame game = new TicTacToeGame(players, boardSize);
        System.out.println("Game winner is: " + game.startGame());
    }
}