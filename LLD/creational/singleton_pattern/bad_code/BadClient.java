package creational.singleton_pattern.bad_code;

public class BadClient {
    public static void main(String[] args) {
        AppSettings appSettings = new AppSettings();

        AppSettings appSettingsCopy = new AppSettings();

        System.out.println(appSettings.getApiKey());
        System.out.println(appSettingsCopy.getApiKey());

        // Here we are creating multiple instances of the class AppSettings
        // But ideally only one object should be created
        // This is leading to wastage of resources
    }
}
