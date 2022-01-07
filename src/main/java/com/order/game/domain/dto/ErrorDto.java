package com.order.game.domain.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDto {
    private String message;
    private Throwable cause;
}
