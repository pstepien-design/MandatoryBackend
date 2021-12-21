package com.example.demo.Services.VotingService;

import com.example.demo.Entities.VotingRecords;
import com.example.demo.Repositories.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VotingServiceImp implements VotingService {

    @Autowired
    private VotingRepository votingRepository;

    @Override
    public VotingRecords findById(Long id) {
        return votingRepository.findById(id).orElseThrow(() -> new RuntimeException("Voting record with this id not found"));
    }

    @Override
    public List<VotingRecords> findAll() {
       return votingRepository.findAll();
    }

    @Override
    public VotingRecords findByPartyId(Long partyId) {
        return votingRepository.findByPartyId(partyId).orElseThrow(() -> new RuntimeException("Voting record with this partyId not found"));

    }

    @Override
    public VotingRecords findByVotingDate(LocalDate votingDate) {
        return votingRepository.findByVotingDate(votingDate).orElseThrow(() -> new RuntimeException("Voting record with this voting date not found"));

    }

    @Override
    public void incrementVoteCounterByPartyId(Long partyId) {
    VotingRecords myVotingRecords = votingRepository.findByPartyId(partyId).orElseThrow(() -> new RuntimeException("Voting record with this partyId not found"));
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
    myVotingRecords.setParty(votingRecords.getParty());
    myVotingRecords.setVoteCounter(votingRecords.getVoteCounter());
    votingRepository.save(myVotingRecords);
    }

    @Override
    public void deleteVotingRecords(Long id){
        VotingRecords myVotingRecords =  votingRepository.findById(id).orElseThrow(() -> new RuntimeException("Voting record with this id not found"));
        votingRepository.delete(myVotingRecords);
    }
}
