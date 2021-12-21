package com.example.demo.Controllers.Party;


import com.example.demo.Entities.Party;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(
        tags = "Parties",
        description = "- An endpoint for <b>Parties</b>"
)
@RequestMapping("/api/parties")
public interface PartyControllerInterface {
    @ApiOperation(
            value = " - Returns all the Parties",
            notes = "Execute to see all <b>Parties</b>."
    )
    @GetMapping
    public List<Party> findAllParties();

}
