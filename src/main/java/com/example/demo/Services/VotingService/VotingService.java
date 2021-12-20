package com.example.demo.Services.VotingService;

import com.example.demo.Entities.VotingRecords;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VotingService {
    public List<VotingRecords> findAll();

    public VotingRecords findById(Long id);

    public VotingRecords findByCandidateId(Long candidateId);

    public VotingRecords findByVotingDate(LocalDate votingDate);

    public void incrementVoteCounterByCandidateId(Long candidateId);

    public void addVotingRecords(VotingRecords votingRecords);

    public void editVotingRecords(Long id, VotingRecords votingRecords);

    public void deleteVotingRecords(Long id);
}
