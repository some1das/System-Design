package LLD.structuralDesignPattern.adapter_design_pattern.bad_code;

public class SendGridSrvice {
    public void sendEmil(String recipient, String title, String content) {
        System.out.println("Sending email via send grid to " + recipient);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }
}
