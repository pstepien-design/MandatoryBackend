package com.example.demo.Services.PartyRepository;


import com.example.demo.Entities.Party;
import com.example.demo.Repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PartyServiceImp implements PartyService {

    @Autowired
    private PartyRepository partyRepository;

    @Override
    public Party findPartyById(Long id) {
        return partyRepository.findPartyById(id).orElseThrow( () -> new RuntimeException("Party with this id not found"));
    }

    @Override
    public Party findPartyByName(String name) {
        return partyRepository.findPartyByName(name).orElseThrow( () -> new RuntimeException("Party with this name not found"));

    }

    @Override
    public List<Party> findAll() {
       return partyRepository.findAll();
    }

    @Override
    public void addParty(Party party) {
    partyRepository.save(party);
    }

    @Override
    public void editParty(Long id, Party party) {
    Party myParty = partyRepository.findPartyById(id).orElseThrow( () ->new RuntimeException("Party with this id not found"));
    myParty.setLetter(party.getLetter());
    myParty.setName(party.getName());
    partyRepository.save(myParty);
    }

    @Override
    public void deleteParty(Long id) {
        Party myParty = partyRepository.findPartyById(id).orElseThrow( () ->new RuntimeException("Party with this id not found"));
    partyRepository.delete(myParty);
    }
}
