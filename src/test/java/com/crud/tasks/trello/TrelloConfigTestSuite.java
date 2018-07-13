package com.crud.tasks.trello;

import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    public void testFetchConfig() {
        //Given
        String trelloApiEndpoint;
        String trelloAppKey;
        String trelloToken;
        String trelloUsername;

        //When
        trelloApiEndpoint = trelloConfig.getTrelloApiEndpoint();
        trelloAppKey = trelloConfig.getTrelloAppKey();
        trelloToken = trelloConfig.getTrelloToken();
        trelloUsername = trelloConfig.getTrelloUsername();

        //Then
        assertEquals("https://api.trello.com/1", trelloApiEndpoint);
        assertEquals("064d8d4e5bd1457ed9bc15cd49a83b7e", trelloAppKey);
        assertEquals("e25e32f67549d2f5fbbe4f70ccb5a53f4912c9fce5cc5375add73a0f4ad9d123", trelloToken);
        assertEquals("michaflorczak", trelloUsername);
    }
}
