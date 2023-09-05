package uz.pdp.instagram.service.post;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.model.Post;

import java.util.ArrayList;
import java.util.UUID;

import static uz.pdp.instagram.util.Util.postRepository;

public class PostServiceImpl implements PostService{
    private static  final PostServiceImpl instance = new PostServiceImpl();

    private PostServiceImpl() {

    }
    public static PostServiceImpl getInstance() {
        return instance;
    }

    @Override
    public BaseResponce add(Post post) {
        postRepository.save(post);
        return new BaseResponce<>("ok",200);
    }

    @Override
    public int remove(Post post) {
        return 0;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public ArrayList<Post> getMyPost(UUID uuid) {
        return postRepository.getMyPost(uuid);
    }
}
