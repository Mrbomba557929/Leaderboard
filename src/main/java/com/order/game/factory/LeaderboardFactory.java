package com.order.game.factory;

import com.order.game.domain.dto.LeaderboardDto;
import com.order.game.domain.entity.Leaderboard;
import org.springframework.stereotype.Component;

@Component
public class LeaderboardFactory {

    public LeaderboardDto toDto(Leaderboard leaderboard) {
        return LeaderboardDto.builder()
                .name(leaderboard.getName())
                .discord(leaderboard.getDiscord())
                .time(leaderboard.getTime())
                .email(leaderboard.getEmail())
                .build();
    }

    public Leaderboard toEntity(LeaderboardDto leaderboardDto) {
        return Leaderboard.builder()
                .name(leaderboardDto.getName())
                .discord(leaderboardDto.getDiscord())
                .time(leaderboardDto.getTime())
                .email(leaderboardDto.getEmail())
                .build();
    }
}
