package com.order.game.service.impl;

import com.order.game.domain.entity.Leaderboard;
import com.order.game.repository.LeaderboardRepository;
import com.order.game.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation {@link LeaderboardService} service.
 */
@RequiredArgsConstructor
@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    private final LeaderboardRepository leaderboardRepository;

    @Override
    public Leaderboard save(Leaderboard leaderboard) {
        List<Leaderboard> leaderboards = leaderboardRepository.findByEmailOrDiscord(leaderboard.getEmail(), leaderboard.getDiscord());

        Leaderboard leaderboardForSave = leaderboard;

        for (Leaderboard leaderboardDb : leaderboards) {

            if (leaderboardForSave.getTime() <= leaderboardDb.getTime()) {
                leaderboardRepository.delete(leaderboardDb);
            } else {
                leaderboardForSave = leaderboardDb;
            }

        }

        return leaderboardRepository.save(leaderboardForSave);
    }

    @Override
    public List<Leaderboard> findAll() {
        return leaderboardRepository.findFirstTwelveOrderByTime();
    }
}
