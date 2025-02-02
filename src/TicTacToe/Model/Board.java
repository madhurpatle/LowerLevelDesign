package TicTacToe.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public Piece[][] board;

    public Board(int size){
        this.size = size;
        board = new Piece[size][size];
    }

    public boolean addPiece(int row, int col, Piece piece){

        if(row<0 || col<0 || row>=size || col>=size){
            return false;
        }
        if (board[row][col]==null){
            board[row][col] = piece;
            return true;
        }
        return false;
    }

    public List<Pair<Integer,Integer>> getFreeCells(){
        List<Pair<Integer,Integer>> freeCells = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    freeCells.add(new Pair<>(i,j));
                }
            }
        }
        return freeCells;
    }
}
