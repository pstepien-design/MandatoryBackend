package com.example.demo.Controllers.Candidate;

import com.example.demo.Entities.Candidate;
import com.example.demo.Services.CandidateService.CandidateServiceImp;
import com.example.demo.Services.PartyRepository.PartyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CandidateController implements CandidateControllerInterface{

    @Autowired
    private CandidateServiceImp candidateService;

    @Autowired
    private PartyServiceImp partyService;


    @Override
    public List<Candidate> findAllCandidates() {
        return candidateService.findAll();
    }

    @Override
    public Candidate findCandidateById(Long id) {
        return candidateService.findCandidateById(id);
    }

    @Override
    public List<Candidate> findCandidateByPartyId(Long partyId) {
       return candidateService.findCandidateByPartyId(partyId);
    }

    @Override
    public void addCandidate(Candidate candidate) {
        candidateService.addCandidate(candidate);
    }

    @Override
    public void addCandidateForSpecificParty(String candidateName, Long partyId) {
        Candidate candidate  = new Candidate(candidateName, partyService.findPartyById(partyId));
        candidateService.addCandidateForSpecificParty(partyId, candidate);
    }

    @Override
    public void editCandidateById(Candidate candidate, Long candidateId, Long  partyId) {
        candidate.setParty(partyService.findPartyById(partyId));
        candidateService.editCandidateById(candidateId, candidate);
    }

    @Override
    public void deleteCandidateById(Long candidateId) {
        candidateService.deleteCandidate(candidateId);
    }
}
