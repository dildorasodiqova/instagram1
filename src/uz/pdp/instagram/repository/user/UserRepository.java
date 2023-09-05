package uz.pdp.instagram.repository.user;

import uz.pdp.instagram.domain.DTO.FollowDTO;
import uz.pdp.instagram.domain.model.Follow;
import uz.pdp.instagram.domain.model.User;
import uz.pdp.instagram.repository.BaseRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface UserRepository extends BaseRepository<User> {
    ArrayList<User> getUsersById(ArrayList<UUID> myFollowers);

    ArrayList<User> search(String name);
}
