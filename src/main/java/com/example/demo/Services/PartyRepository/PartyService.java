package com.example.demo.Services.PartyRepository;

import com.example.demo.Entities.Party;

import java.util.List;
import java.util.Optional;

public interface PartyService {

    public Party findPartyById(Long id);

    public Party findPartyByName(String name);

    public List<Party> findAll();

    public void addParty(Party party);

    public void editParty(Long id, Party party);

    public void deleteParty(Long id);
}
