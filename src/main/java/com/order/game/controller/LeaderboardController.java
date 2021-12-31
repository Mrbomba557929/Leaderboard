package com.order.game.controller;

import com.order.game.domain.dto.LeaderboardDto;
import com.order.game.domain.entity.Leaderboard;
import com.order.game.factory.LeaderboardFactory;
import com.order.game.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class LeaderboardController {

    private final static String FIND_ALL = "/leaderboards";
    private final static String SAVE = "/leaderboards";

    private final LeaderboardService leaderboardService;
    private final LeaderboardFactory leaderboardFactory;

    @GetMapping(FIND_ALL)
    public ResponseEntity<?> findAll() {
        List<LeaderboardDto> leaderboards = leaderboardService.findAll()
                .stream()
                .map(leaderboardFactory::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(leaderboards, HttpStatus.OK);
    }

    @PostMapping(SAVE)
    public ResponseEntity<?> save(@RequestBody LeaderboardDto leaderboardDto) {
        Leaderboard savedLeaderboard = leaderboardService.save(leaderboardFactory.toEntity(leaderboardDto));
        return new ResponseEntity<>(leaderboardFactory.toDto(savedLeaderboard), HttpStatus.OK);
    }
}