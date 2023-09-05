package uz.pdp.instagram.service.Message;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.model.Message;
import uz.pdp.instagram.service.post.PostServiceImpl;

import java.util.ArrayList;
import java.util.UUID;

import static uz.pdp.instagram.util.Util.messageRepository;

public class MessageServiceImpl implements MessageService{
    private static  final MessageServiceImpl instance = new MessageServiceImpl();


    private MessageServiceImpl() {

    }
    public static MessageServiceImpl getInstance() {
        return instance;
    }

    @Override
    public BaseResponce add(Message message) {
        messageRepository.save(message);
        return new BaseResponce("ok",200);
    }

    @Override
    public int remove(Message message) {
        return 0;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public ArrayList<Message> followerMessage(UUID uuid, UUID uuid1) {
       ArrayList<Message> messages =  messageRepository.followerMessage(uuid,uuid1);
       return messages;
    }
}
