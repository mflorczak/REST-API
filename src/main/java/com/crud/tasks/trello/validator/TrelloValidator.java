package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrelloValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloValidator.class);

    public List<TrelloBoard> validateTrelloBoards(List<TrelloBoard> trelloBoards) {
        LOGGER.info("Starting filtering boards...");
        List<TrelloBoard> filterBoards = trelloBoards.stream()
                .filter(trelloBoard -> !trelloBoard.getName().equalsIgnoreCase("test"))
                .collect(Collectors.toList());
        LOGGER.info("Boards have been filtered. Current list size: " + filterBoards.size());

        return filterBoards;
    }

    public void validateCard(final TrelloCard trelloCard) {
        if(trelloCard.getName().contains("test")) {
            LOGGER.info("Someone is testing my application");
        } else {
            LOGGER.info("Seems that my application is used in proper way.");
        }
    }
}
