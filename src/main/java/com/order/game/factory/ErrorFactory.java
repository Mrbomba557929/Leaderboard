package com.order.game.factory;

import com.order.game.domain.dto.ErrorDto;
import org.springframework.stereotype.Component;

@Component
public class ErrorFactory {

    public ErrorDto toError(String message, Throwable cause) {
        return ErrorDto.builder()
                .message(message)
                .cause(cause)
                .build();
    }
}
