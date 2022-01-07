package com.order.game.repository;

import com.order.game.domain.entity.Leaderboard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaderboardRepository extends PagingAndSortingRepository<Leaderboard, Long> {

    @Query(value = "SELECT * FROM leaderboards WHERE leaderboards.email = ?1 OR leaderboards.discord = ?2", nativeQuery = true)
    List<Leaderboard> findByEmailOrDiscord(String email, String discord);

    @Query(value = "SELECT * FROM leaderboards ORDER BY leaderboards.time LIMIT 12", nativeQuery = true)
    List<Leaderboard> findFirstTwelveOrderByTime();

    @Query(value = "SELECT COUNT(*) FROM leaderboards", nativeQuery = true)
    long getCountRecords();

    @Query(value = "SELECT * FROM leaderboards ORDER BY leaderboards.time", nativeQuery = true)
    List<Leaderboard> findAllOrderByTime();
}
