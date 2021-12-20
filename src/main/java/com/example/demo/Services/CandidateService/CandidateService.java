package com.example.demo.Services.CandidateService;

import com.example.demo.Entities.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    public Candidate findCandidateById(Long id);

    public Candidate findCandidateByName(String name);

    public Candidate findCandidateByPartyId(Long partyId);

    public List<Candidate> findAll();

    public void editCandidateById(Long id, Candidate candidate);

    public void addCandidate(Candidate candidate);

    public void deleteCandidate(Long id);
}
