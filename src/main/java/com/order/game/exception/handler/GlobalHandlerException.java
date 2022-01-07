package com.order.game.exception.handler;

import com.order.game.domain.dto.ErrorDto;
import com.order.game.factory.ErrorFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@RequiredArgsConstructor
@ControllerAdvice
public class GlobalHandlerException {

    private final ErrorFactory errorFactory;

    @ExceptionHandler(MailException.class)
    public ResponseEntity<?> handMailException(MailException exception) {
        ErrorDto error = errorFactory.toError(exception.getMessage(), exception.getCause());
        log.error(error);
        return ResponseEntity.badRequest().body(error);
    }
}
