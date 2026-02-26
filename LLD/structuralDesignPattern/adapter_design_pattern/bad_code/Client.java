package LLD.structuralDesignPattern.adapter_design_pattern.bad_code;

public class Client {
    public static void main(String[] args) {
        NotificationService emailService = new EmailNotificationService();
        emailService.send("sumandas@gamil.com", "Job - Software Engineer", "Job Description");

        // Use sendgrid service for email
        NotificationService newNotificationServivce = new SendGridAdapter(new SendGridSrvice());
        newNotificationServivce.send("payel@gmail.com", "Hi, Payel", "Message body");
    }
}
