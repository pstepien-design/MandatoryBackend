package com.example.demo.Controllers.Candidate;

import com.example.demo.Entities.Candidate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(
        tags = "Candidate",
        description = "- An endpoint for <b>Candidates</b>"
)
@RequestMapping("/api/candidates")
public interface CandidateControllerInterface {
    @ApiOperation(
            value = " - Returns all the Candidates",
            notes = "Execute to see all <b>Candidates</b>."
    )
    @GetMapping
    public List<Candidate> findAllCandidates();

    @ApiOperation(
            value = " - Returns the Candidate by the Id",
            notes = "Enter the specific Candidate's <b>id</b> to retrieve a <b>Candidate</b>."
    )
    @GetMapping("/{id}")
    public Candidate findCandidateById(@PathVariable Long id);


    @ApiOperation(
            value = " - Returns the list of Candidates by the Party Id",
            notes = "Enter the specifi <b>partyId</b> to retrieve a list of <b>Candidate</b>."
    )
    @GetMapping("/party/{partyId}")
    public List<Candidate> findCandidateByPartyId(@PathVariable Long partyId);

    @ApiOperation(
            value = " - Creates new candidate",
            notes = "Put all the relevant information into the body to create a <b>Candidate</b>."
    )
    @PostMapping("/createCandidate")
    public void addCandidate(@RequestBody Candidate candidate);

    @ApiOperation(
            value = " - Creates new candidate for specific party",
            notes = "Put the name and party id to create a <b>Candidate</b>."
    )
    @PostMapping("/createCandidate/party/{partyId}/name/{candidateName}")
    public void addCandidateForSpecificParty(@PathVariable String candidateName, @PathVariable Long partyId);

    @ApiOperation(
            value = " - Updates the Candidate based on the id and information we provide",
            notes = "Enter the <b>id</b> of a Candidate and the information in the body in order to update an existing <b>Candidate</b>.<br> Keep in mind you need to provide <b>ONLY the name in the body </b>. The rest you enter under the body."
    )
    @PutMapping("/editCandidate/{candidateId}/party/{partyId}")
    public void editCandidateById(@RequestBody Candidate candidate, @PathVariable Long candidateId, @PathVariable Long partyId);

    @ApiOperation(
            value = " - Delete the Candidate based on the id",
            notes = "Enter the <b>id</b> of a Candidate to delete the <b>Candidate</b>"
    )
    @DeleteMapping("/deletetCandidate/{candidateId}")
    public void deleteCandidateById(@PathVariable Long candidateId);
}
