package uz.pdp.instagram.repository.like;

import uz.pdp.instagram.domain.model.Like;
import uz.pdp.instagram.repository.BaseRepository;

import java.util.UUID;

public interface LikeRepository extends BaseRepository<Like> {
    boolean isLike(UUID uuid, UUID uuid1);

    void delete(UUID uuid, UUID uuid1);

    int myPostLike(UUID uuid);
}
