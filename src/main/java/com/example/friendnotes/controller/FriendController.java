package com.example.friendnotes.controller;


import com.example.friendnotes.model.Friend;
import com.example.friendnotes.repository.FriendRepository;
import com.example.friendnotes.request.FriendRequest;
import com.example.friendnotes.response.FriendResponse;
import com.example.friendnotes.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FriendController {

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    FriendService friendService;

    //Get All Friends
    @GetMapping("/friends")
    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    // Create a new Friend
    @PostMapping("/friends")
    public FriendResponse createNote(@Valid @RequestBody FriendRequest friendRequest) {
        return friendService.create(friendRequest);
    }
}
