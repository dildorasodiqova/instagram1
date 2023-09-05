package uz.pdp.instagram.domain.model;

import java.util.UUID;

public sealed class BaseModel permits Comment, Follow, Like, Message, Post, User {
    {
        this.uuid = UUID.randomUUID();
    }

   protected UUID uuid;


    public UUID getUuid() {
        return uuid;
    }
}
