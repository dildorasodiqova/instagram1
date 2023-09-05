package uz.pdp.instagram.repository.message;

import uz.pdp.instagram.domain.model.Message;
import uz.pdp.instagram.domain.model.User;
import uz.pdp.instagram.repository.post.PostRepositoryImpl;
import uz.pdp.instagram.repository.user.UserRepositoryImpl;
import uz.pdp.instagram.service.Message.MessageServiceImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class MessageRepositoryImpl implements MessageRepository{
    private final ArrayList<Message> MESSAGE_LIST = new ArrayList<>();

    private static final MessageRepository instance = new MessageRepositoryImpl();
    public static MessageRepository getInstance() {
        return instance;
    }
    @Override
    public ArrayList<Message> getAll() {
        return MESSAGE_LIST;
    }

    @Override
    public int save(Message message) {
         MESSAGE_LIST.add(message);
         return 1;
    }

    @Override
    public Message getById(UUID uuid) {
        for (Message message : MESSAGE_LIST) {
            if (Objects.equals(message.getUuid(),uuid)){
                return message;
            }
        }
        return null;
    }

    @Override
    public void remove(UUID uuid) {
        for (Message message : MESSAGE_LIST) {
            if (Objects.equals(message.getUuid(),uuid)){
                MESSAGE_LIST.remove(message);
            }
        }
    }

    @Override
    public void remove(Message message) {
        for (Message messages : MESSAGE_LIST) {
            if (Objects.equals(messages, message)) {
                MESSAGE_LIST.remove(message);
            }
        }
    }

    @Override
    public ArrayList<Message> getArrayById(UUID uuid) {

    return null;}

    @Override
    public ArrayList<Message> followerMessage(UUID uuid, UUID uuid1) {
        ArrayList<Message> messages = new ArrayList<>();
        for (Message message : MESSAGE_LIST) {
            if (Objects.equals(message.getSenderId(),uuid) && (Objects.equals(message.getReceiverId(),uuid1)) ||
                    Objects.equals(message.getSenderId(),uuid1) && (Objects.equals(message.getReceiverId(),uuid))){
                messages.add(message);
            }
        }
        return messages;
    }
}
