package com.example.friendnotes.service;

import com.example.friendnotes.model.Friend;
import com.example.friendnotes.repository.FriendRepository;
import com.example.friendnotes.request.FriendRequest;
import com.example.friendnotes.response.FriendResponse;
import com.example.friendnotes.validator.FriendRequestValidator;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;

@Service
public class FriendService {

    private FriendRepository friendRepository;
    private FriendRequestValidator friendRequestValidator;

    public FriendService(FriendRepository friendRepository, FriendRequestValidator friendRequestValidator) {
        this.friendRepository = friendRepository;
        this.friendRequestValidator = friendRequestValidator;
    }

    public FriendResponse create(@Valid FriendRequest friendRequest) {
        friendRequestValidator.validate(friendRequest);
        Friend friend = saveFriend(friendRequest);
        return convertResponse(friend);
    }

    private FriendResponse convertResponse(Friend friend) {
        FriendResponse friendResponse = new FriendResponse();
        friendResponse.setFriendId(friend.getId());
        return friendResponse;
    }

    private Friend saveFriend(@Valid FriendRequest friendRequest) {
        Friend friend = new Friend();
        friend.setName(friendRequest.getName());
        friend.setSurname(friendRequest.getSurname());
        friend.setCreatedAt(new Date());
        friendRepository.save(friend);
        return friend;
    }
}
