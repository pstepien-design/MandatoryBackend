package com.example.demo.Controllers.Voting;


import com.example.demo.Entities.VotingRecords;
import com.example.demo.Services.VotingService.VotingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VotingController implements VotingControllerInterface {
    @Autowired
    private VotingServiceImp votingService;
    public List<VotingRecords> findAllVotes() {
        return votingService.findAll();
    }
}
