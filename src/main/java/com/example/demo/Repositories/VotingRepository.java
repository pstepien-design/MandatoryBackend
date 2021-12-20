package com.example.demo.Repositories;

import com.example.demo.Entities.VotingRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VotingRepository extends JpaRepository<VotingRecords, Long> {

    public Optional<VotingRecords> findById(Long id);

    public List<VotingRecords> findAll();

    public Optional<VotingRecords> findByCandidateId(Long candidateId);

    public Optional<VotingRecords> findByVotingDate(LocalDate votingDate);




}
