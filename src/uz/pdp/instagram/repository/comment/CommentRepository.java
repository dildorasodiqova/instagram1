package uz.pdp.instagram.repository.comment;

import uz.pdp.instagram.domain.DTO.CommentDTO;
import uz.pdp.instagram.domain.model.Comment;
import uz.pdp.instagram.repository.BaseRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface  CommentRepository extends BaseRepository<Comment> {
    ArrayList<CommentDTO> getCommentDTO(UUID uuid);
}
