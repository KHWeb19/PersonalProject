package com.example.backend.util;

import com.example.backend.entity.Post;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;


import java.security.Principal;


public class PostUtility {

    private UserService userService;

    public PostUtility(UserService userService){
        this.userService = userService;
    }


    public Post settingAuthor(Post post, Principal principal){
        String username = principal.getName();
        User user = userService.getUser(username);
        user.addPost(post);
        post.setAuthor(username);

        return post;
    }
}
