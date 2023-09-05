package uz.pdp.instagram.repository.like;

import uz.pdp.instagram.domain.model.Like;
import uz.pdp.instagram.domain.model.Message;
import uz.pdp.instagram.repository.message.MessageRepository;
import uz.pdp.instagram.repository.message.MessageRepositoryImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class LikeRepositoryImpl implements LikeRepository{
    private final ArrayList<Like> LIKE_LIST = new ArrayList<>();

    private static final LikeRepositoryImpl instance = new LikeRepositoryImpl();
    public static LikeRepositoryImpl getInstance() {
        return instance;
    }
    @Override
    public ArrayList<Like> getAll() {
        return null;
    }

    @Override
    public int save(Like like) {
       LIKE_LIST.add(like);
       return 1;
    }

    @Override
    public Like getById(UUID uuid) {
        return null;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public void remove(Like like) {

    }

    @Override
    public ArrayList<Like> getArrayById(UUID uuid) {
        return null;
    }

    @Override
    public boolean isLike(UUID uuid, UUID uuid1) {
        for (Like like : LIKE_LIST) {
            return Objects.equals(like.getUserId(), uuid) && Objects.equals(like.getPostId(), uuid1);
        }
        return false;
    }

    @Override
    public void delete(UUID uuid, UUID uuid1) {
        for (Like like : LIKE_LIST) {
            if (Objects.equals(like.getUserId(),uuid) && Objects.equals(like.getPostId(),uuid1)){
                LIKE_LIST.remove(like);
            }
        }
    }

    @Override
    public int myPostLike(UUID uuid) {
        int count = 0;
        for (Like like : LIKE_LIST) {
            if(Objects.equals( like.getPostId(),uuid)){
                count++;
            }
        }
        return count;
    }
}
