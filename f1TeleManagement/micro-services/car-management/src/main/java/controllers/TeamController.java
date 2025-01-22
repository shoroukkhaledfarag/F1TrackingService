package controllers;

import contracts.ITeamService;
import lombok.RequiredArgsConstructor;
import models.CreateTeamDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    private final ITeamService teamService;

    @PostMapping
    public void createTeam(@RequestBody CreateTeamDto teamDto) {

    }

    @PutMapping
    public void updateTeam() {

    }

    @DeleteMapping
    public void deleteTeam() {

    }

    @GetMapping("/{id}")
    public void getTeamById() {

    }

    @GetMapping
    public void getAllTeams() {

    }
}
