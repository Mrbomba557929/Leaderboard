package com.order.game.job;

import com.order.game.domain.MailSender;
import com.order.game.factory.LeaderboardFactory;
import com.order.game.repository.LeaderboardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
@Log4j2
@RequiredArgsConstructor
public class SendEmailNotificationJob {

    private final static long TIME_OF_TASK = 120000L;
    private final static long TIME_OF_DELAY = 120000L;
    private final static long TARGET_COUNT_RECORDS = 5L;

    private final MailSender mailSender;
    private final LeaderboardFactory leaderboardFactory;
    private final LeaderboardRepository leaderboardRepository;

    private boolean isSent;

    @Value("${mail.to}")
    private String mailTo;

    @Value("${mail.subject}")
    private String mailSubject;

    @Scheduled(initialDelay = TIME_OF_DELAY, fixedDelay = TIME_OF_TASK)
    public void sendNotificationWhen500Records() {
        if (!isSent) {
            long countRecords = leaderboardRepository.getCountRecords();

            log.info("count records = " + countRecords);

            if (countRecords >= TARGET_COUNT_RECORDS) {
                AtomicInteger counter = new AtomicInteger(1);
                String message = leaderboardRepository.findAllOrderByTime()
                        .stream()
                        .map(item -> counter.getAndIncrement() + ". " + leaderboardFactory.toDto(item).toString())
                        .collect(Collectors.joining("\n"));

                log.info("message = " + message);

                mailSender.send(mailTo, mailSubject, message);
                isSent = true;
            }
        }
    }
}
