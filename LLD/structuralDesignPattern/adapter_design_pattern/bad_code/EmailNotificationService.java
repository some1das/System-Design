package LLD.structuralDesignPattern.adapter_design_pattern.bad_code;


// Legacy code
public class EmailNotificationService implements NotificationService{
    public void send(String to, String subject, String body) {
        System.out.println("Sending = " + to);
        System.out.println("Subject = " + subject);
        System.out.println("Body = " + body);
    }
}
