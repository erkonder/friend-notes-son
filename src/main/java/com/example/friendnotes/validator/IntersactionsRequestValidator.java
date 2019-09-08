package com.example.friendnotes.validator;


import com.example.friendnotes.exception.IntersactionsValidationException;
import com.example.friendnotes.request.IntersactionsRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

//TODO: validationları unutma
@Component
public class IntersactionsRequestValidator {
    public void validate(@Valid IntersactionsRequest intersactionsRequest) {
        if (StringUtils.isBlank(intersactionsRequest.getName())) {
            throw new IntersactionsValidationException("name could not be blank");
        }

        if (StringUtils.isBlank(intersactionsRequest.getSurname()))
        {
            throw new IntersactionsValidationException("surname could not be blank");
        }

        if (StringUtils.isBlank(intersactionsRequest.getTitle()))
        {
            throw new IntersactionsValidationException("title could not be blank");
        }

        if(StringUtils.isBlank(intersactionsRequest.getContent()))
        {
            throw new IntersactionsValidationException("content could not be blank");
        }
    }
}
