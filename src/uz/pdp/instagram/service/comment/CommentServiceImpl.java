package uz.pdp.instagram.service.comment;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.DTO.CommentDTO;
import uz.pdp.instagram.domain.model.Comment;
import uz.pdp.instagram.service.post.PostServiceImpl;

import java.util.ArrayList;
import java.util.UUID;

import static uz.pdp.instagram.util.Util.commentRepository;

public class CommentServiceImpl implements CommentService{
    private static  final CommentServiceImpl instance = new CommentServiceImpl();

    private CommentServiceImpl() {

    }
    public static CommentServiceImpl getInstance() {
        return instance;
    }
    @Override
    public BaseResponce add(Comment comment) {
        commentRepository.save(comment);
        return new BaseResponce<>("✅",200);
    }

    @Override
    public int remove(Comment comment) {
        return 0;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public ArrayList<CommentDTO> getComment(UUID uuid) {
        return commentRepository.getCommentDTO(uuid);
    }
}
