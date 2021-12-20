package com.example.demo.Services.VotingService;

import com.example.demo.Entities.VotingRecords;
import com.example.demo.Repositories.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VotingServiceImp implements VotingService {

    @Autowired
    private VotingRepository votingRepository;

    @Override
    public VotingRecords findById(Long id) {
        return votingRepository.findById(id).orElseThrow(() -> new RuntimeException("Voting record with this id not found"));
    }

    @Override
    public VotingRecords findByCandidateId(Long candidateId) {
        return votingRepository.findByCandidateId(candidateId).orElseThrow(() -> new RuntimeException("Voting record with this candidateId not found"));

    }

    @Override
    public VotingRecords findByVotingDate(LocalDate votingDate) {
        return votingRepository.findByVotingDate(votingDate).orElseThrow(() -> new RuntimeException("Voting record with this voting date not found"));

    }

    @Override
    public void incrementVoteCounterByCandidateId(Long candidateId) {
    VotingRecords myVotingRecords = votingRepository.findByCandidateId(candidateId).orElseThrow(() -> new RuntimeException("Voting record with this candidateId not found"));
    myVotingRecords.setVoteCounter(myVotingRecords.getVoteCounter()+1);
    editVotingRecords(myVotingRecords.getId(), myVotingRecords);
    }

    @Override
    public void addVotingRecords(VotingRecords votingRecords) {
    votingRepository.save(votingRecords);
    }

    @Override
    public void editVotingRecords(Long id, VotingRecords votingRecords) {
    VotingRecords myVotingRecords =  votingRepository.findById(id).orElseThrow(() -> new RuntimeException("Voting record with this id not found"));
    myVotingRecords.setVotingDate(votingRecords.getVotingDate());
    myVotingRecords.setCandidate(votingRecords.getCandidate());
    myVotingRecords.setVoteCounter(votingRecords.getVoteCounter());
    votingRepository.save(myVotingRecords);
    }

    @Override
    public void deleteVotingRecords(Long id){
        VotingRecords myVotingRecords =  votingRepository.findById(id).orElseThrow(() -> new RuntimeException("Voting record with this id not found"));
        votingRepository.delete(myVotingRecords);
    }
}
