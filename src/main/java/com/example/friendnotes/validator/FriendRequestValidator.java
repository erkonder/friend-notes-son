package com.example.friendnotes.validator;

import com.example.friendnotes.exception.FriendValidationException;
import com.example.friendnotes.model.Friend;
import com.example.friendnotes.request.FriendRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

//TODO: validationları unutma
@Component
public class FriendRequestValidator {
    public void validate(@Valid FriendRequest friendRequest) {
        if (StringUtils.isBlank(friendRequest.getName())) {
            throw new FriendValidationException("name could not be blank");
        }

        //TODO : validate all fields

        if (StringUtils.isBlank(friendRequest.getSurname()))
        {
            throw  new FriendValidationException("surname could not be blank");
        }
    }
}
