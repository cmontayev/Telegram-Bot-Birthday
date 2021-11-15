package kz.alfabank.integration.telegrambotbirthday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TelegramBotBirthdayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotBirthdayApplication.class, args);
    }

}
