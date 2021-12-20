package com.example.demo.Repositories;

import com.example.demo.Entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    public Optional<Party> findPartyById(Long id);

    public Optional<Party> findPartyByName(String name);

    public List<Party> findAll();
}
