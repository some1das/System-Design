package creational.singleton_pattern.good_code;

public class GoodClient {
    public static void main(String[] args) {
        AppSettings setting1 = AppSettings.getInstance();
        AppSettings setting2 = AppSettings.getInstance();

        System.out.println(setting1.equals(setting2));
    }
}
