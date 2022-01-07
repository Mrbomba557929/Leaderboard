package com.order.game.service;

import com.order.game.domain.entity.Leaderboard;

import java.util.List;

/**
 * Interface for {@link Leaderboard} entity.
 */
public interface LeaderboardService {

    /**
     * Method for saving the {@link Leaderboard} entity.
     *
     * @param leaderBoard - the {@link Leaderboard} entity.
     * @return saved the {@link Leaderboard} entity.
     */
    Leaderboard save(Leaderboard leaderBoard);

    /**
     * Method for find first twelve the {@link Leaderboard} entities.
     *
     * @return list of the {@link Leaderboard} entities.
     */
    List<Leaderboard> findFirstTwelve();
}
