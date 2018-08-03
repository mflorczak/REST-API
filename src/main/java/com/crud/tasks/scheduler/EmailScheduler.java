package com.crud.tasks.scheduler;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.trello.config.AdminConfig;
import com.crud.tasks.trello.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleEmailService emailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private UserConfig userConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        String task = size == 1 ? " task" : " tasks";
        emailService.sendDailyMail(new Mail(adminConfig.getAdminEmail(), SUBJECT,
                "Currently in database you got: " + size + task + ".", userConfig.getUserMail()));
    }
}
