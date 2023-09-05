package uz.pdp.instagram.repository.post;

import uz.pdp.instagram.domain.model.Post;
import uz.pdp.instagram.repository.BaseRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface PostRepository extends BaseRepository<Post> {
    ArrayList<Post> getMyPost(UUID uuid);
}
