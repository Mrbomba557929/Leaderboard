package com.order.game.repository;

import com.order.game.domain.entity.Leaderboard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaderboardRepository extends PagingAndSortingRepository<Leaderboard, Long> {

    @Query("SELECT l FROM Leaderboard l WHERE l.email = ?1 OR l.discord = ?2")
    List<Leaderboard> findByEmailOrDiscord(String email, String discord);

    @Query("SELECT l FROM Leaderboard l ORDER BY l.time ASC")
    List<Leaderboard> findAllOrderByTime();
}
