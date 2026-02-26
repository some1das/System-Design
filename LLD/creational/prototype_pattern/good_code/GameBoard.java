package LLD.creational.prototype_pattern.good_code;

import java.util.ArrayList;
import java.util.List;

public class GameBoard implements Prototype<GameBoard> {
    private List<GamePiece> pieces = new ArrayList<>();

    public void addPiece(GamePiece piece) {
        this.pieces.add(piece);
    }

    public List<GamePiece> getPieces() {
        return this.pieces;
    }

    public void showCurrentBoardState() {
        for(GamePiece p: pieces) {
            System.out.println(p);
        }
    }

    @Override
    public GameBoard clone() {
        GameBoard newGameBoard = new GameBoard();
        for(GamePiece gp: pieces) {
            newGameBoard.addPiece(gp.clone());
        }
        return newGameBoard;
    }
}
