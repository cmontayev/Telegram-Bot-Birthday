package kz.alfabank.integration.telegrambotbirthday.service.imp;

import kz.alfabank.integration.telegrambotbirthday.model.Employees;
import kz.alfabank.integration.telegrambotbirthday.service.EmployeesService;
import kz.alfabank.integration.telegrambotbirthday.scheduler.Scheduler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class BotService extends TelegramLongPollingBot {
    @Autowired
    private EmployeesService service;
    private Logger logger = LoggerFactory.getLogger(Scheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private int count = 0;

    @Value("${telegram.bot.username}")
    private String username;

    @Value("${telegram.bot.token}")
    private String token;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
        }
    }

    public void sendMessage() {

        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        List<Employees> list = service.getAll(month, day);

        logger.info("this is scheduler task runing  " + (count++));
        logger.info("Текущее время:" + dateFormat.format(new Date()));
        if (!list.isEmpty()) {
            list.forEach(employees -> {
                try {
                    String bdMessage = "Happy Birthday dear " + employees.getLastName() + " " + employees.getFirsName() + "!";
                    log.info("message have been sent. User id: {}, Date: {},{}", employees.getId(),bdMessage, date);
                    execute(SendMessage.builder().chatId("-719727673").text(bdMessage).build());
                } catch (TelegramApiException e) {
                    log.error("Email can't be sent.User's id: {}, Error: {}", employees.getId(), e.getMessage());

                }
            });
        }
    }
    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

}
