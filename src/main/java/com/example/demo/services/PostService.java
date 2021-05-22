package com.example.demo.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.example.models.Post;
import com.example.models.Reactions;

import com.example.utils.NullAwareBeanUtils;

import org.springframework.stereotype.Component;

@Component
public class PostService {

    private static List<Post> posts = new ArrayList<Post>();

    static {
        Post post1 = new Post();
        post1.setId("1");
        post1.setDate(toISODate());
        post1.setTitle("My Title");
        post1.setContent("My Content");
        post1.setUser("1");
        post1.setReactions(new Reactions());
        posts.add(post1);

        Post post2 = new Post();
        post2.setId("2");
        post2.setDate(toISODate());
        post2.setTitle("My Title 2");
        post2.setContent("My Content 2");
        post2.setUser("2");
        post2.setReactions(new Reactions());
        posts.add(post2);
    }

    private static String toISODate() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        return nowAsISO;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Post getPost(String id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }
        return null;

    }

    public Post addPost(Post postToAdd) {
        String id = (posts.size() + 1) + "";

        Post newPost = new Post();
        newPost.setId(id);
        newPost.setTitle(postToAdd.getTitle());
        newPost.setContent(postToAdd.getContent());
        newPost.setUser(postToAdd.getUser());
        newPost.setDate(toISODate());
        newPost.setReactions(new Reactions());

        posts.add(newPost);

        return newPost;
    }

    public Post updatePost(String id, Post updateData) {
        int i = 0;
        Post postToUpdate = null;

        for (; i < posts.size(); i++) {
            Post currentPost = posts.get(i);
            if (currentPost.getId().equals(id)) {

                NullAwareBeanUtils.copyNonNullProperties(updateData, currentPost);

                postToUpdate = currentPost;
                break;
            }
        }

        return postToUpdate;
    }

    public Post removePost(String id) {
        int i = 0;
        Post postToRemove = null;

        for (; i < posts.size(); i++) {
            Post currentPost = posts.get(i);

            if (currentPost.getId().equals(id)) {
                postToRemove = currentPost;
                posts.remove(i);
                break;
            }
        }

        return postToRemove;
    }

    public List<Post> getPostsByUserId(String id) {
        List<Post> postsByUser = new ArrayList<Post>();

        for (Post post : posts) {
            if (post.getUser().equals(id)) {
                postsByUser.add(post);
            }
        }

        return postsByUser;
    }

}