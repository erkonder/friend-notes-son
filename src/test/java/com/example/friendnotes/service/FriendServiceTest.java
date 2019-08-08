package com.example.friendnotes.service;

import com.example.friendnotes.repository.FriendRepository;
import com.example.friendnotes.request.FriendRequest;
import com.example.friendnotes.validator.FriendRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class FriendServiceTest {

    @Mock
    private FriendRepository friendRepository;
    @Mock
    private FriendRequestValidator friendRequestValidator;
    @InjectMocks
    private FriendService friendService;

    @Test
    public void should_Create() {
        //given
        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setName("Hakan");
        friendRequest.setSurname("Yusuf");

        //when
        friendService.create(friendRequest);

        //then
    }

}