package uz.pdp.instagram.service.follow;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.DTO.FollowDTO;
import uz.pdp.instagram.domain.model.Follow;
import uz.pdp.instagram.domain.model.User;
import uz.pdp.instagram.repository.follow.FollowRepository;
import uz.pdp.instagram.repository.follow.FollowRepositoryImpl;
import uz.pdp.instagram.repository.user.UserRepository;
import uz.pdp.instagram.repository.user.UserRepositoryImpl;
import uz.pdp.instagram.service.post.PostServiceImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class FollowServiceImpl implements FollowService{
    private static  final FollowServiceImpl instance = new FollowServiceImpl();
    FollowRepository followRepository = FollowRepositoryImpl.getInstance();
    UserRepository userRepository = new UserRepositoryImpl();

    public static FollowServiceImpl getInstance() {
        return instance;
    }

    private FollowServiceImpl() {

    }

    @Override
    public BaseResponce add(Follow follow) {
        followRepository.save(follow);
        return new BaseResponce<>("ok",200);
    }

    @Override
    public int remove(Follow follow) {
        return 0;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public ArrayList<User> getMyFollowers(UUID userId) {
        ArrayList<UUID> myFollowers = followRepository.getMyFollowers(userId);
       return userRepository.getUsersById(myFollowers);
    }

    @Override
    public boolean isFollower(UUID uuid, UUID uuid1) {
       return followRepository.isFolLower(uuid,uuid1);
    }
}
