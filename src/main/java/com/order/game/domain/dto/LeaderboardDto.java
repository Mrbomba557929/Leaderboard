package com.order.game.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardDto {
    private String name;
    private String email;
    private String discord;

    @Min(value = 13, message = "You cheater!")
    private double time;

    @Override
    public String toString() {
        return String.format("(%s  %g  %s  %s)", name, time, email, discord);
    }
}
