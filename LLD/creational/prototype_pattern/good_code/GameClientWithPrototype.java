package LLD.creational.prototype_pattern.good_code;

public class GameClientWithPrototype {
    public static void main(String[] args) {
        GameBoard gb = new GameBoard();
        gb.addPiece(new GamePiece("Red", 0));
        gb.addPiece(new GamePiece("Green", 1));

        gb.showCurrentBoardState();


        // Let's save the game 
        GameBoard checkPoint1 = new GameBoard();

        for(GamePiece gp: gb.getPieces()) {
            checkPoint1.addPiece(new GamePiece(gp.getColor(), gp.getPosition()));
        }

        checkPoint1.showCurrentBoardState();

    }
}
