package uz.pdp.instagram.repository.follow;

import uz.pdp.instagram.domain.model.Follow;
import uz.pdp.instagram.repository.BaseRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface FollowRepository extends BaseRepository<Follow> {
    ArrayList<UUID> getMyFollowers(UUID userId);

    boolean isFolLower(UUID uuid, UUID uuid1);
}
