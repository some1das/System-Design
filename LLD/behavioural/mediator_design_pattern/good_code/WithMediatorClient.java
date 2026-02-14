package behavioural.mediator_design_pattern.good_code;

import java.util.ArrayList;
import java.util.List;

class ChatUser {
    private String name;

    public ChatUser(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void recieveMessage(String msg, ChatUser sender) {
        System.out.println(sender.name+ " Sayes to - "+ this.name + " : " + msg);
    }
}

interface ChatMediator {

    void sendMessage(String msg, ChatUser user);

    void addUser(ChatUser user);
}

class ChatRoom implements ChatMediator {

    private List<ChatUser> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, ChatUser sender) {
        for(ChatUser user: this.users) {
            if(user.equals(sender)) continue;
            user.recieveMessage(msg, sender);
        }
    }

    @Override
    public void addUser(ChatUser user) {
        users.add(user);
    }
    
}

public class WithMediatorClient {

    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        ChatUser suman = new ChatUser("Suman");
        ChatUser payel = new ChatUser("Payel");
        ChatUser poli = new ChatUser("Poli");

        chatRoom.addUser(suman);
        chatRoom.addUser(payel);
        chatRoom.addUser(poli);

        chatRoom.sendMessage("Hiiiii", suman);
    }
}