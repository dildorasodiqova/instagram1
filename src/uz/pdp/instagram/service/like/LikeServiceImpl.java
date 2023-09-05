package uz.pdp.instagram.service.like;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.model.Like;
import uz.pdp.instagram.service.post.PostServiceImpl;

import java.util.UUID;

import static uz.pdp.instagram.util.Util.likeRepository;

public class LikeServiceImpl implements LikeService{
    private static  final LikeServiceImpl instance = new LikeServiceImpl();

    private LikeServiceImpl() {

    }
    public static LikeServiceImpl getInstance() {
        return instance;
    }

    @Override
    public BaseResponce add(Like like) {
        likeRepository.save(like);
        return new BaseResponce<>("ok" ,200);
    }

    @Override
    public int remove(Like like) {
        return 0;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public boolean isLike(UUID uuid, UUID uuid1) {
       return likeRepository.isLike(uuid,uuid1);
    }




    @Override
    public void delete(UUID uuid, UUID uuid1) {
        likeRepository.delete(uuid,uuid1);
    }

    @Override
    public int myPostLike(UUID uuid) {
        return likeRepository.myPostLike(uuid);

    }
}
