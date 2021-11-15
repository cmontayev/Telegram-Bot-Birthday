package kz.alfabank.integration.telegrambotbirthday.scheduler;

import kz.alfabank.integration.telegrambotbirthday.service.imp.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Scheduler {


    @Autowired
    private BotService botService;


    // test   @Scheduled(cron = "*/10 * * * * *")
    @Scheduled(cron = "0 0 9 * * *")
    private void process() {

        botService.sendMessage();

    }


}