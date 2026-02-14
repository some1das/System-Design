package creational.singleton_pattern.good_code;

public class AppSettings {
    private String databaseUrl;

    private String apiKey;

    // Create Instance of Self
    private static AppSettings instance;

    private AppSettings() {
        this.databaseUrl = "jdbc://okey";
        this.apiKey = "whjd23ry293ruf2io3huwegydgewidhwhede9==";
    }

    public static AppSettings getInstance() {
        if(instance != null) {
            return instance;
        }
        instance = new AppSettings();
        return instance;
    }

    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    public String getApiKey() {
        return this.apiKey;
    }
}
