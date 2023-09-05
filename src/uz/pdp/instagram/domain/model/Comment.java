package uz.pdp.instagram.domain.model;

import java.util.ArrayList;
import java.util.UUID;

public non-sealed class Comment extends BaseModel{
   private UUID postId;
   private UUID userId;
   private String text;



    public Comment(UUID postId, UUID userId, String text) {
        this.postId = postId;
        this.userId = userId;
        this.text = text;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }


}
