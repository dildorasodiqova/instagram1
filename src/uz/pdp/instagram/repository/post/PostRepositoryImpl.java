package uz.pdp.instagram.repository.post;

import uz.pdp.instagram.domain.model.Post;
import uz.pdp.instagram.domain.model.User;
import uz.pdp.instagram.repository.user.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class PostRepositoryImpl implements PostRepository{
    private final ArrayList<Post> POST_LIST = new ArrayList<>();

    private static final PostRepositoryImpl instance = new PostRepositoryImpl();
    public static PostRepositoryImpl getInstance() {
        return instance;
    }

    @Override
    public ArrayList<Post> getAll() {
        return POST_LIST;
    }

    @Override
    public int save(Post post) {
       POST_LIST.add(post);
       return 1;
    }

    @Override
    public Post getById(UUID uuid) {
        return null;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public void remove(Post post) {

    }

    @Override
    public ArrayList<Post> getArrayById(UUID uuid) {
        return null;
    }

    @Override
    public ArrayList<Post> getMyPost(UUID uuid) {
        ArrayList<Post> posts = new ArrayList<>();
        for (Post post : POST_LIST) {
            if (Objects.equals(post.getOwnerId(),uuid)){
                posts.add(post);
            }
        }
        return posts;
    }
}
