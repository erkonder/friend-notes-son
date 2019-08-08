package com.example.friendnotes.service;


import com.example.friendnotes.model.Intersactions;
import com.example.friendnotes.repository.IntersactionsRepository;
import com.example.friendnotes.request.IntersactionsRequest;
import com.example.friendnotes.response.IntersactionsResponse;
import com.example.friendnotes.validator.IntersactionsRequestValidator;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;

@Service
public class IntersactionsService {

    private IntersactionsRepository intersactionsRepository ;
    private IntersactionsRequestValidator intersactionsRequestValidator ;

    public IntersactionsService(IntersactionsRepository intersactionsRepository, IntersactionsRequestValidator intersactionsRequestValidator) {
        this.intersactionsRepository = intersactionsRepository;
        this.intersactionsRequestValidator = intersactionsRequestValidator;
    }

    public IntersactionsResponse create(@Valid IntersactionsRequest intersactionsRequest)
    {
        intersactionsRequestValidator.validate(intersactionsRequest);
        Intersactions intersactions = saveIntersactions(intersactionsRequest);
        return  convertResponse(intersactions);
    }

    private IntersactionsResponse convertResponse(Intersactions intersactions) {
        IntersactionsResponse intersactionsResponse = new IntersactionsResponse();
        intersactionsResponse.setId(intersactions.getId());
        return intersactionsResponse;
    }

    private Intersactions saveIntersactions(IntersactionsRequest intersactionsRequest) {

        Intersactions intersactions = new Intersactions();
        intersactions.setName(intersactionsRequest.getName());
        intersactions.setSurname(intersactionsRequest.getSurname());
        intersactions.setCreatedAt(new Date());
        intersactionsRepository.save(intersactions);
        return intersactions;
    }
}
