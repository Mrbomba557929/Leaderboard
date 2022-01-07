package com.order.game.controller;

import com.order.game.domain.dto.LeaderboardDto;
import com.order.game.domain.entity.Leaderboard;
import com.order.game.factory.LeaderboardFactory;
import com.order.game.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@Log4j2
public class LeaderboardController {

    private final static String FIND_FIRST_TWELVE = "/leaderboards";
    private final static String SAVE = "/leaderboards";

    private final LeaderboardService leaderboardService;
    private final LeaderboardFactory leaderboardFactory;

    @GetMapping(FIND_FIRST_TWELVE)
    public ResponseEntity<?> findFirstTwelve() {
        List<LeaderboardDto> leaderboards = leaderboardService.findFirstTwelve()
                .stream()
                .map(leaderboardFactory::toDto)
                .collect(Collectors.toList());

        log.info(leaderboards);

        return new ResponseEntity<>(leaderboards, HttpStatus.OK);
    }

    @PostMapping(SAVE)
    public ResponseEntity<?> save(@RequestBody LeaderboardDto leaderboardDto) {

        log.info(leaderboardDto);

        Leaderboard leaderboard = leaderboardService.save(leaderboardFactory.toEntity(leaderboardDto));
        return new ResponseEntity<>(leaderboardFactory.toDto(leaderboard), HttpStatus.OK);
    }
}
