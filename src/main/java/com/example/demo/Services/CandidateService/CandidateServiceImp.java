package com.example.demo.Services.CandidateService;

import com.example.demo.Entities.Candidate;
import com.example.demo.Repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Candidate findCandidateById(Long id) {
        return candidateRepository.findCandidateById(id).orElseThrow( () -> new RuntimeException("Candidate with this id not found"));
    }

    @Override
    public Candidate findCandidateByName(String name) {
        return candidateRepository.findCandidateByName(name).orElseThrow( () -> new RuntimeException("Candidate with this name not found"));

    }

    @Override
    public Candidate findCandidateByPartyId(Long partyId) {
       return candidateRepository.findCandidateByPartyId(partyId).orElseThrow(() -> new RuntimeException("Candidate with this party id not found"));
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
    public void deleteCandidate(Long id) {
    Candidate myCandidate = candidateRepository.findCandidateById(id).orElseThrow( () -> new RuntimeException("Candidate with this id not found"));
    candidateRepository.delete(myCandidate);
    }
}
