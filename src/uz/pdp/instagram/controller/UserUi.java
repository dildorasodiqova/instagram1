package uz.pdp.instagram.controller;

import uz.pdp.instagram.domain.DTO.CommentDTO;
import uz.pdp.instagram.domain.DTO.FollowDTO;
import uz.pdp.instagram.domain.model.*;
import uz.pdp.instagram.service.Message.MessageService;
import uz.pdp.instagram.service.like.LikeService;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

import static uz.pdp.instagram.util.Util.*;


public class UserUi {
    public static void userMenu(User user) {
        showMyFollowers(user);
        while (true) {
            System.out.println("""
                    1.Message
                    2.Post
                    3.Follow
                    4.Like post
                    5.Comment
                    6.see my post
                    0.exit""");
            String a = SCANNER_STR.nextLine();
            switch (a) {
                case "1" -> {
                    messageWrite(user);
                }
                case "2" -> {
                    posting(user);
                }
                case "3" -> {
                    following(user);
                }
                case "4" -> {
                    clickLike(user);
                }
                case "5" -> {
                    comment(user);
                }
                case "6" -> {
                    seeMyPost(user);
                }
                case "0" -> {
                    return;
                }
            }
        }
    }

    public static void showMyFollowers(User user) {

        ArrayList<User>  users  =  followService.getMyFollowers(user.getUuid());
        int countt = 0;
        if ( users.isEmpty()) {
            System.out.println("<<  " + countt + "  >>" + "  Followers  ");
        }else {
            for (User myFollower : users) {
                countt++;
            }
            System.out.println("<<  " + countt + "  >>" + "  Followers  ");
            System.out.println("1.follower\t0.back");
            int g = SCANNER_INT.nextInt();
            if (g == 1) {
                for (User myFollower : followService.getMyFollowers(user.getUuid())) {
                    System.out.println(myFollower.getName() + " >> " + myFollower.getPhoneNum());
                }
            } else {
                    return;
            }
       }
    }

    private static void seeMyPost(User user) {
        int u = 1;
        ArrayList<Post> post = postService.getMyPost(user.getUuid());
        if (post.isEmpty()) {
            System.out.println("Post is not available");
            return;
        } else {

            for (Post post1 : post) {
                System.out.println(u++ + " | " + post1.getTitle() + " || " + post1.getText());
            }
            System.out.print("Enter index post -> ");
            int o = SCANNER_INT.nextInt();
            if (o == 0){
                System.out.println("wrong index !!!");
            }
            System.out.println("<<< " + post.get(o - 1).getTitle() + " >>>");
            System.out.println("1.delete post\t2.comment\t3.like\t0.back");
            String w = SCANNER_STR.nextLine();
            switch (w) {
                case "1" -> {
                    postService.remove(post.get(o - 1));
                }
                case "2" -> {
                    getMYComment(post.get(o - 1).getUuid());
                }
                case "3" -> {
                    int a = likeService.myPostLike(post.get(o - 1).getUuid());
                    System.out.println("❤️" + "   " + a + "   " + "like");
                }
                case "0" -> {
                    return;
                }
                default -> {
                    System.out.println("Wrong input");
                    return;
                }
            }
        }

    }


    private static void getMYComment(UUID uuid) {
        ArrayList<CommentDTO> comment = commentService.getComment(uuid);
        if (comment.isEmpty()) {
            System.out.println("Comment is not available");
        } else {
            for (CommentDTO commentDTO : comment) {
                System.out.println("______" + commentDTO.name() + "______ ");
                System.out.println(commentDTO.comment());
                System.out.println("______________________________");
            }
        }
    }


    private static User searchUser(User user) {
        System.out.print("search...");
        String name = SCANNER_STR.nextLine();
        ArrayList<User> users = userService.search(name);
        if (users.isEmpty()) {
            System.out.println("User not found !!!");
        } else {
            int i = 1;
            for (User user1 : users) {
                System.out.println(i++ + " || " + user1.getName());
            }
            System.out.print("enter index -> ");
            int w = SCANNER_INT.nextInt();
            return users.get(w - 1);

        }
        return null;

    }

    private static void messageWrite(User user) {
        ArrayList<User> users = myShowFollowers(user);
        if (users.isEmpty()) {
            System.out.println("You don't have a chat yet");
            System.out.println("Wait for someone to follow you");
        } else {

            System.out.print("Enter index -> ");
            int w = SCANNER_INT.nextInt();
            User user1 = users.get(w - 1);
            ArrayList<Message> messages = messageService.followerMessage(user.getUuid(), user1.getUuid());
            if (messages.isEmpty()) {
                System.out.println("🤷‍♀️🤷‍♀️🤷‍♀️🤷‍♀️🤷‍♀️");
            } else {
                for (Message message : messages) {
                    if (Objects.equals(message.getSenderId(), user.getUuid())) {
                        System.out.println("       " + message.getText());
                    } else if (Objects.equals(message.getSenderId(), user1.getUuid())) {
                        System.out.println("" + message.getText());
                    }
                }
                System.out.println("Message...");
                String massage = SCANNER_STR.nextLine();

                Message message1 = new Message.MessageBuilder()
                        .setText(massage)
                        .setReceiverId(user1.getUuid())
                        .setSenderId(user.getUuid())
                        .build();
                messageService.add(message1);
                System.out.println("👍👍👍");
                if(followService.isFollower(user.getUuid(),user1.getUuid())){

                }else {
                    Follow follow = new Follow(user1.getUuid(), user.getUuid());
                    followService.add(follow);
                    System.out.println(" You are followed this user ");
                }

            }

        }

    }

    public static ArrayList<User> myShowFollowers(User user) {
        ArrayList<User> followers = followService.getMyFollowers(user.getUuid());
        int k = 1;
        for (User user1 : followers) {
            System.out.println(k++ + " . " + user1.getName() + " || " + user1.getPhoneNum());
        }
        return followers;
    }

    private static void posting(User user) {
        System.out.print("Enter post title -> ");
        String title = SCANNER_STR.nextLine();

        System.out.print("Enter post -> ");
        String post = SCANNER_STR.nextLine();

        Post post1 = new Post.postBuilder()
                .setTitle(title)
                .setText(post)
                .setOwnerId(user.getUuid())
                .build();
        postService.add(post1);
        System.out.println("✅");
    }


    private static void following(User user) {
        User user1 = searchUser(user);
        if (user1 == null) {
            return;
        }
        if (followService.isFollower(user.getUuid(), user1.getUuid())) {
            System.out.println("Follow👌👌👌");
        } else {
            System.out.println("1.Following\t0.back");
            int f = SCANNER_INT.nextInt();
            if (f == 1) {
                System.out.println("Follow👌👌👌");
                Follow follow = new Follow(user1.getUuid(), user.getUuid());
                followService.add(follow);
            } else if (f == 0) {
                return;
            } else {
                System.out.println("Wrong index");
            }
        }

    }

    private static void clickLike(User user) {
        User user1 = searchUser(user);
        if (user1 == null) {
            return;
        } else {
            ArrayList<Post> posts = postService.getMyPost(user1.getUuid());
            if (posts.isEmpty()) {
                System.out.println("Post is not available");
            } else {
                int i = 1;
                for (Post post : posts) {
                    System.out.println(i++ + " || " + post.getTitle() + " || " + post.getText());
                }
                System.out.print("Choose post -> ");
                int d = SCANNER_INT.nextInt();

                System.out.println(posts.get(d - 1).getTitle());
                if (likeService.isLike(user.getUuid(), posts.get(d - 1).getUuid())) {
                    System.out.println("❤️");
                    System.out.println("1.Dislike\t0.back");
                    int w = SCANNER_INT.nextInt();
                    if (w == 1) {
                        System.out.println("🤍");
                        likeService.delete(user.getUuid(), posts.get(d - 1).getUuid());
                    } else {
                        return;
                    }
                } else {
                    System.out.println("🤍\t\n");
                    likeService.add(new Like(posts.get(d - 1).getUuid(), user.getUuid()));
                    System.out.println("LIKED...❤️");
                }
            }
        }
    }

    private static void comment(User user) {
        User user1 = searchUser(user);
        if (user1 == null) {
            return;
        }
        ArrayList<Post> posts = postService.getMyPost(user1.getUuid());
        if (posts.isEmpty()) {
            System.out.println("Post is not available");
        } else {
            int i = 1;
            for (Post post : posts) {
                System.out.println(i++ + " || " + post.getTitle() + " || " + post.getText());
            }
            System.out.print("Choose post -> ");
            int d = SCANNER_INT.nextInt();

            System.out.println(posts.get(d - 1));
            ArrayList<CommentDTO> comment = commentService.getComment(posts.get(d - 1).getUuid());
            if (comment.isEmpty()) {
                System.out.println("  no comment ");
            } else {
                for (CommentDTO commentDTO : comment) {
                    System.out.println(commentDTO.name() + " || " + commentDTO.comment());
                }
            }
            System.out.println("Message...");
            String message = SCANNER_STR.nextLine();

            Comment comment1 = new Comment(posts.get(d - 1).getUuid(), user.getUuid(), message);
            commentService.add(comment1);
            System.out.println("✅");


        }
    }
}
