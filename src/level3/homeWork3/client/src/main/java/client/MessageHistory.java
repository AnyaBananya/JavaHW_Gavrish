package client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MessageHistory {
    String nickname;
    List<String> messages;

    public MessageHistory(String nickname) {
        this.nickname = nickname;

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("history_" + nickname + ".txt"));
            messages = (List<String>)in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            messages = new ArrayList<>();
        }
    }

    public void addMessage(String message) {
        messages.add(message);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("history_" + nickname + ".txt"));
            out.writeObject(messages);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getMessages() {
        int fromIndex = messages.size() >= 50 ? messages.size() : 0;
        return messages.subList(fromIndex, messages.size());
    }
}
