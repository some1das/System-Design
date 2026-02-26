package LLD.creational.prototype_pattern.bad_code;

public class GamePiece {
    private String color;
    private int position;

    public GamePiece(String color, int position) {
        this.color = color;
        this.position = position;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public String getColor() {
        return this.color;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return "{" + "color = " + color + " ," + "position = " + position + "}";
    }
}
