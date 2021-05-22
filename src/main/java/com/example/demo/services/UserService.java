package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private static List<User> users = new ArrayList<User>();

    static {
        User user1 = new User();
        user1.setId("1");
        user1.setEmail("eric.kizaki@gmail.com");
        user1.setFirstName("Eric");
        user1.setLastName("Kizaki");
        users.add(user1);

        User user2 = new User();
        user2.setId("2");
        user2.setEmail("bob@gmail.com");
        user2.setFirstName("Bob");
        user2.setLastName("Test");
        users.add(user2);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;

    }
}