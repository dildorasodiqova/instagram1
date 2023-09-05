package uz.pdp.instagram.repository.follow;

import uz.pdp.instagram.domain.DTO.FollowDTO;
import uz.pdp.instagram.domain.model.Follow;
import uz.pdp.instagram.domain.model.Like;
import uz.pdp.instagram.repository.like.LikeRepositoryImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class FollowRepositoryImpl implements FollowRepository{
    private final ArrayList<Follow> FOLLOW_LIST = new ArrayList<>();

    private static final FollowRepositoryImpl instance = new FollowRepositoryImpl();
    public static FollowRepositoryImpl getInstance() {
        return instance;
    }
    @Override
    public ArrayList<Follow> getAll() {
        return FOLLOW_LIST;
    }

    @Override
    public int save(Follow follow) {
        FOLLOW_LIST.add(follow);
        return 1;
    }

    @Override
    public Follow getById(UUID uuid) {
        return null;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public void remove(Follow follow) {

    }

    @Override
    public ArrayList<Follow> getArrayById(UUID uuid) {
        return null;
    }

    @Override
    public ArrayList<UUID> getMyFollowers(UUID userId) {
        ArrayList<UUID> follows = new ArrayList<>();
        for (Follow follow : FOLLOW_LIST) {
            if (Objects.equals(follow.getOwnerId(),userId)){
                follows.add(follow.getFollowerId());
            }
        }
        return follows;
    }

    @Override
    public boolean isFolLower(UUID uuid, UUID uuid1) {
        for (Follow follow : FOLLOW_LIST) {
            if (Objects.equals(follow.getFollowerId(),uuid) && Objects.equals(follow.getOwnerId(),uuid1)){
                return true;
            }
        }return false;
    }
}
