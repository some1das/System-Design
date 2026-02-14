package behavioural.mediator_design_pattern.bad_code;


class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void sendMessage(String msg, User recipient) {
        System.out.println(this.name + " Sending message to - "+ recipient.name);
    }
}

public class WithoutMediatorDesignPattern {
    public static void main(String[] args) {
        User suman = new User("Suman");
        User payel = new User("Payel");
        User poli = new User("Poli");

        suman.sendMessage("Hi", poli);
        poli.sendMessage("Hiiiiiiiiii!", suman);

        payel.sendMessage("Hello!", suman);
    }
}
