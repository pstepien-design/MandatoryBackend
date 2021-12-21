package com.example.demo.Controllers.Voting;

import com.example.demo.Entities.Party;
import com.example.demo.Entities.VotingRecords;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(
        tags = "Votes",
        description = "- An endpoint for <b>Votes</b>"
)
@RequestMapping("/api/votes")
public interface VotingControllerInterface {
    @ApiOperation(
            value = " - Returns all the votes",
            notes = "Execute to see all <b>Votes</b>."
    )
    @GetMapping
    public List<VotingRecords> findAllVotes();

}
