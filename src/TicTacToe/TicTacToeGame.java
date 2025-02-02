package TicTacToe;

import TicTacToe.Model.*;

import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public Deque<Player> players;
    public Board gameBoard;

    public TicTacToeGame(Deque<Player> players, Integer size){
        this.players = players;
        this.gameBoard = new Board(size);
    }

    public String startGame() {
        printBoard(gameBoard);
        boolean noWinner = true;
        while(noWinner){
            Player playerTurn = players.removeFirst();

            List<Pair<Integer,Integer>> freeCells = gameBoard.getFreeCells();

            if(freeCells.isEmpty()){
                noWinner = false;
                continue;
            }

            System.out.println("Player "+playerTurn.name+" enter row,col: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] val = s.split(",");
            if (val.length!=2) {
                System.out.println("Invalid input give, try again!");
                players.addFirst(playerTurn);
                continue;
            }
            int inputRow = Integer.parseInt(val[0]), inputCol = Integer.parseInt(val[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputCol,playerTurn.playingPiece);

            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect position choosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow,inputCol,playerTurn.playingPiece.pieceType);
            if(winner){
                return playerTurn.name;
            }

            printBoard(gameBoard);
        }
        return "tie";
    }

    boolean isThereWinner(Integer row, Integer col, PieceType pieceType){
        int n=gameBoard.size;
        boolean checkRow=true,checkCol=true,checkD=true,checkAd=true;
        //check row & col
        for(int i=0;i<n;i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                checkRow = false;
                break;
            }
        }

        for(int i=0;i<n;i++) {
            if(gameBoard.board[i][col] ==null || gameBoard.board[i][col].pieceType != pieceType){
                checkCol = false;
                break;
            }
        }

        //check diagonal

        for(int i=0,j=0;i<n && j<n;i++,j++){
            if(gameBoard.board[i][j] ==null || gameBoard.board[i][j].pieceType != pieceType){
                checkD = false;
                break;
            }
        }
        //check anti diagonal
        for(int i=n-1,j=0;i>=0 && j<n;i--,j++){
            if(gameBoard.board[i][j] ==null || gameBoard.board[i][j].pieceType != pieceType){
               checkAd = false;
               break;
            }
        }

        return  checkRow || checkCol || checkD || checkAd;
    }

    public void printBoard(Board gameBoard) {
        int n = gameBoard.size;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (gameBoard.board[i][j] != null) {
                    System.out.print(" " + gameBoard.board[i][j].pieceType + " ");
                } else {
                    System.out.print("   ");
                }
                if (j < n - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < n - 1) {
                System.out.println("---+---+---");
            }
        }
    }

}
