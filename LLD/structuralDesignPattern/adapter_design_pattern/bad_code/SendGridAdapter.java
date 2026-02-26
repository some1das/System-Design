package LLD.structuralDesignPattern.adapter_design_pattern.bad_code;

public class SendGridAdapter implements NotificationService{

    private SendGridSrvice sendGridSrvice;

    public SendGridAdapter(SendGridSrvice service) {
        this.sendGridSrvice = service;
    }

    @Override
    public void send(String to, String subject, String body) {
        // Adapter method - converts parametaers and call function of sendGrid
        sendGridSrvice.sendEmil(to, subject, body);
    }
}
