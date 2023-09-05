package uz.pdp.instagram.util;

import uz.pdp.instagram.repository.comment.CommentRepository;
import uz.pdp.instagram.repository.comment.CommentRepositoryImpl;
import uz.pdp.instagram.repository.like.LikeRepository;
import uz.pdp.instagram.repository.like.LikeRepositoryImpl;
import uz.pdp.instagram.repository.message.MessageRepository;
import uz.pdp.instagram.repository.message.MessageRepositoryImpl;
import uz.pdp.instagram.repository.post.PostRepository;
import uz.pdp.instagram.repository.post.PostRepositoryImpl;
import uz.pdp.instagram.repository.user.UserRepository;
import uz.pdp.instagram.repository.user.UserRepositoryImpl;
import uz.pdp.instagram.service.Message.MessageService;
import uz.pdp.instagram.service.Message.MessageServiceImpl;
import uz.pdp.instagram.service.comment.CommentService;
import uz.pdp.instagram.service.comment.CommentServiceImpl;
import uz.pdp.instagram.service.follow.FollowService;
import uz.pdp.instagram.service.follow.FollowServiceImpl;
import uz.pdp.instagram.service.like.LikeService;
import uz.pdp.instagram.service.like.LikeServiceImpl;
import uz.pdp.instagram.service.post.PostService;
import uz.pdp.instagram.service.post.PostServiceImpl;
import uz.pdp.instagram.service.user.UserService;
import uz.pdp.instagram.service.user.UserServiceImpl;

import java.util.Scanner;

public interface Util {
    Scanner SCANNER_INT = new Scanner(System.in);
    Scanner SCANNER_STR = new Scanner(System.in);
    UserService userService = UserServiceImpl.getInstance();
    PostService postService = PostServiceImpl.getInstance();
    UserRepository userRepository = UserRepositoryImpl.getInstance();
    MessageService messageService = MessageServiceImpl.getInstance();
    CommentService commentService = CommentServiceImpl.getInstance();
    FollowService followService = FollowServiceImpl.getInstance();
    MessageRepository messageRepository = MessageRepositoryImpl.getInstance();
    PostRepository postRepository = PostRepositoryImpl.getInstance();
    LikeService likeService = LikeServiceImpl.getInstance();
    LikeRepository likeRepository = LikeRepositoryImpl.getInstance();
    CommentRepository commentRepository = CommentRepositoryImpl.getInstance();

}
