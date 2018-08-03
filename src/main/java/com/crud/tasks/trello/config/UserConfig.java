package com.crud.tasks.trello.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UserConfig {

    @Value("${user.name}")
    private String userName;

    @Value("${user.mail}")
    private String userMail;
}
