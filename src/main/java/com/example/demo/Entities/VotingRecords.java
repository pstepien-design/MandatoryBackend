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
                columnNames = {"votingDate", "party_id"}
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
    private Party party;

    @Column(nullable = false)
    private int voteCounter;

    @Column(nullable = false)
    private LocalDate votingDate;

    public VotingRecords(Party party, LocalDate votingDate) {
        this.party = party;
        this.votingDate = votingDate;
    }

    public VotingRecords(Party party, int voteCounter, LocalDate votingDate) {
        this.party = party;
        this.voteCounter = voteCounter;
        this.votingDate = votingDate;
    }
}
