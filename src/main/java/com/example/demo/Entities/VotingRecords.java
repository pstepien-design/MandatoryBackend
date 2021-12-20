package com.example.demo.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table( uniqueConstraints = {
        @UniqueConstraint(
                name = "UniqueCandidateIdAndDate",
                columnNames = {"candidate_id", "votingDate"}
        ),
},
        name = "voting_records",
        schema = "mandatory"
)
public class VotingRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToOne
    private Candidate candidate;

    private int voteCounter;

    @Column(unique = true)
    private LocalDate votingDate;

    public VotingRecords(Candidate candidate, LocalDate votingDate) {
        this.candidate = candidate;
        this.votingDate = votingDate;
    }
}