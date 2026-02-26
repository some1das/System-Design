package creational.builder_pattern.bad_code;

public class House {
    private String foundation;
    private String Structure;
    private String roof;
    private int rooms;
    private int floors;
    private int swimmingPool;

    public House(String foundation) {
        this.foundation = foundation;
    }

    public House(String roof, int swimmingPool) {
        this.roof = roof;
        this.swimmingPool = swimmingPool;
    }
    
}
