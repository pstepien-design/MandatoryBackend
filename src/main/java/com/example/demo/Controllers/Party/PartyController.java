package com.example.demo.Controllers.Party;


import com.example.demo.Entities.Party;
import com.example.demo.Services.PartyRepository.PartyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartyController implements PartyControllerInterface{
    @Autowired
    private PartyServiceImp partyService;

    @Override
    public List<Party> findAllParties() {
        return partyService.findAll();
    }
}
