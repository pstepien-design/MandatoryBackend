package com.example.demo.Configuration;

import com.example.demo.Entities.Candidate;
import com.example.demo.Entities.Party;
import com.example.demo.Entities.User;
import com.example.demo.Entities.VotingRecords;
import com.example.demo.Services.CandidateService.CandidateService;
import com.example.demo.Services.PartyRepository.PartyService;
import com.example.demo.Services.UserService.UserService;
import com.example.demo.Services.VotingService.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Profile("!test")
public class DatabaseConfigurator implements CommandLineRunner {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private PartyService partyService;

    @Autowired
    private VotingService votingService;

    @Autowired
    private UserService userService;


    @Override
    public void run(String... args) throws Exception {
        createParties();
        createCandidates();
        createUsers();
        createVotingRecords();

    }

    private void createParties() {
        if (partyService.findAll().isEmpty()) {
            partyService.addParty(new Party("Socialdemokratiet", "A"));
            partyService.addParty(new Party("Det konservative Folkeparti", "C"));
            partyService.addParty(new Party("Socialistisk Folkeparti", "SF"));
            partyService.addParty(new Party("Enhedslisten - De Rød-Grønne", "Ø"));
            partyService.addParty(new Party("Dansk Folkeparti", "O"));
            partyService.addParty(new Party("Venstre, Danmarks Liberale Parti", "V"));


        }
    }

    private void createCandidates() {
        if (candidateService.findAll().isEmpty()) {
            Party socialdemokratiet = partyService.findPartyByName("Socialdemokratiet");
            candidateService.addCandidate(new Candidate("Marcel Meijer", socialdemokratiet));
            candidateService.addCandidate(new Candidate("Helle Hansen", socialdemokratiet));

            Party folkeparti = partyService.findPartyByName("Det konservative Folkeparti");
            candidateService.addCandidate(new Candidate("Peter Askjær", folkeparti));
            candidateService.addCandidate(new Candidate("Sigfred Jensen", folkeparti));

            Party socialistisk = partyService.findPartyByName("Socialistisk Folkeparti");
            candidateService.addCandidate(new Candidate("Ulla Holm", socialistisk));
            candidateService.addCandidate(new Candidate("Anne Grethe Olsen", socialistisk));

            Party venstre = partyService.findPartyByName("Venstre, Danmarks Liberale Parti");
            candidateService.addCandidate(new Candidate("Anita Elgaard Højholt Olesen", venstre));
            candidateService.addCandidate(new Candidate("Anja Guldborg", venstre));

            Party enhedslisten = partyService.findPartyByName("Enhedslisten - De Rød-Grønne");
            candidateService.addCandidate(new Candidate("Katrine Høegh Mc Quaid", enhedslisten));
            candidateService.addCandidate(new Candidate("Pia Birkmand", enhedslisten));


        }
    }

    private void createVotingRecords() {
        if (votingService.findAll().isEmpty()) {
            Candidate candidate1 = candidateService.findCandidateById(1L);
            Candidate candidate2 = candidateService.findCandidateById(2L);
            Candidate candidate3 = candidateService.findCandidateById(3L);
            Candidate candidate4 = candidateService.findCandidateById(4L);
            Candidate candidate5 = candidateService.findCandidateById(5L);
            Candidate candidate6 = candidateService.findCandidateById(6L);
            LocalDate date = LocalDate.of(2021, 12, 20);
            votingService.addVotingRecords(new VotingRecords(candidate1, 250, date));
            votingService.addVotingRecords(new VotingRecords(candidate2, 200, date));
            votingService.addVotingRecords(new VotingRecords(candidate3, 209, date));
            votingService.addVotingRecords(new VotingRecords(candidate4, 100, date));
            votingService.addVotingRecords(new VotingRecords(candidate5, 50, date));
            votingService.addVotingRecords(new VotingRecords(candidate6, 300, date));


        }
    }

    private void createUsers() {
        if (userService.findAll().isEmpty()) {
            userService.addUser(new User("Paweł Stępień", "pawel@kea.dk", 2901019999L, "test123", "admin"));
            userService.addUser(new User("Jan Kowalski", "jank@kea.dk", 1809990000L, "test123", "user"));
            userService.addUser(new User("John Smith", "john@kea.dk", 1212891234L, "test123", "user"));


        }
    }
}
