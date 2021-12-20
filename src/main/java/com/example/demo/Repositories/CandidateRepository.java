package com.example.demo.Repositories;

import com.example.demo.Entities.Candidate;
import com.example.demo.Entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

        public Optional<Candidate> findCandidateById(Long id);

        public Optional<Candidate> findCandidateByName(String name);

        public Optional<Candidate> findCandidateByPartyId(Long partyId);

        public List<Candidate> findAll();

}
