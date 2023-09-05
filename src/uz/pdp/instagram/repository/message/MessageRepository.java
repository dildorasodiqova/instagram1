package uz.pdp.instagram.repository.message;

import uz.pdp.instagram.domain.model.Message;
import uz.pdp.instagram.repository.BaseRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface MessageRepository extends BaseRepository<Message> {
    ArrayList<Message> followerMessage(UUID uuid, UUID uuid1);
}
