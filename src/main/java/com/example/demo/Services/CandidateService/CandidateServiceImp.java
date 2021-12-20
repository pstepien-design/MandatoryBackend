package com.example.demo.Services.CandidateService;

import com.example.demo.Entities.Candidate;
import com.example.demo.Entities.Party;
import com.example.demo.Repositories.CandidateRepository;
import com.example.demo.Repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Override
    public Candidate findCandidateById(Long id) {
        return candidateRepository.findCandidateById(id).orElseThrow( () -> new RuntimeException("Candidate with this id not found"));
    }

    @Override
    public Candidate findCandidateByName(String name) {
        return candidateRepository.findCandidateByName(name).orElseThrow( () -> new RuntimeException("Candidate with this name not found"));
    }

    @Override
    public List<Candidate> findCandidateByPartyId(Long partyId) {
        return candidateRepository.findCandidateByPartyId(partyId);
    }

    @Override
    public List<Candidate> findAll() {
       return candidateRepository.findAll();
    }

    @Override
    public void editCandidateById(Long id, Candidate candidate) {
        Candidate myCandidate = candidateRepository.findCandidateById(id).orElseThrow(() -> new RuntimeException("Candidate with this id not found"));
        myCandidate.setName(candidate.getName());
        myCandidate.setParty(candidate.getParty());
        candidateRepository.save(myCandidate);
    }

    @Override
    public void addCandidate(Candidate candidate) {
    candidateRepository.save(candidate);
    }

    @Override
    public void addCandidateForSpecificParty(Long partyId, Candidate candidate){
      Party party = partyRepository.findPartyById(partyId).orElseThrow( () -> new RuntimeException("Party not found"));
        candidate.setParty(party);
        candidateRepository.save(candidate);
    }

    @Override
    public void deleteCandidate(Long id) {
    Candidate myCandidate = candidateRepository.findCandidateById(id).orElseThrow( () -> new RuntimeException("Candidate with this id not found"));
    candidateRepository.delete(myCandidate);
    }
}
