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
        schema = "by0tsq76lc9331ak"
)
public class VotingRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;



    @OneToOne
    private Candidate candidate;

    @Column(nullable = false)
    private int voteCounter;

    @Column(nullable = false)
    private LocalDate votingDate;

    public VotingRecords(Candidate candidate, LocalDate votingDate) {
        this.candidate = candidate;
        this.votingDate = votingDate;
    }

    public VotingRecords(Candidate candidate, int voteCounter, LocalDate votingDate) {
        this.candidate = candidate;
        this.voteCounter = voteCounter;
        this.votingDate = votingDate;
    }
}
