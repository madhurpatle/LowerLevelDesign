package TicTacToe.Model;

public class Player {
    public String name;
    public Piece playingPiece;

    public Player(String name, Piece pieceType){
        this.name = name;
        this.playingPiece = pieceType;
    }


}
