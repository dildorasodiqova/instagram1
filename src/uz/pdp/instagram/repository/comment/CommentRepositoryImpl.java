package uz.pdp.instagram.repository.comment;

import uz.pdp.instagram.domain.DTO.CommentDTO;
import uz.pdp.instagram.domain.model.Comment;
import uz.pdp.instagram.domain.model.Like;
import uz.pdp.instagram.domain.model.User;
import uz.pdp.instagram.repository.like.LikeRepositoryImpl;
import uz.pdp.instagram.repository.user.UserRepository;
import uz.pdp.instagram.repository.user.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class CommentRepositoryImpl implements CommentRepository{
    private final ArrayList<Comment> COMMENT_LIST = new ArrayList<>();

    private static final CommentRepositoryImpl instance = new CommentRepositoryImpl();
     UserRepository  userRepository =  UserRepositoryImpl.getInstance();
    public static CommentRepositoryImpl getInstance() {
        return instance;
    }
    @Override
    public ArrayList<Comment> getAll() {
        return null;
    }

    @Override
    public int save(Comment comment) {
        COMMENT_LIST.add(comment);
        return 1;
    }

    @Override
    public Comment getById(UUID uuid) {
        return null;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public void remove(Comment comment) {

    }

    @Override
    public ArrayList<Comment> getArrayById(UUID uuid) {
        return null;
    }

    @Override
    public ArrayList<CommentDTO> getCommentDTO(UUID uuid) {
        ArrayList<CommentDTO> commentDTO = new ArrayList<>();
        for (Comment comment : COMMENT_LIST) {
            if (Objects.equals(comment.getPostId(),uuid)){
                for (User user1 : userRepository.getAll()) {
                    if (Objects.equals(comment.getUserId(),user1.getUuid())){
                        CommentDTO commentDTO1 = new CommentDTO(user1.getName(),comment.getText());
                        commentDTO.add(commentDTO1);
                    }
                }

            }
        }
        return commentDTO;
    }
}
