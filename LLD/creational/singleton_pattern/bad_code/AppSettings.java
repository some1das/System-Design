package creational.singleton_pattern.bad_code;

public class AppSettings {
    private String databaseUrl;

    private String apiKey;

    public AppSettings() {
        this.databaseUrl = "jdbc://okey";
        this.apiKey = "whjd23ry293ruf2io3huwegydgewidhwhede9==";
    }

    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    public String getApiKey() {
        return this.apiKey;
    }
}
