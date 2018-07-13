package com.crud.tasks;

import com.crud.tasks.domain.Trello;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TasksApplicationTests {

	@Test
	public void testTrelloClass() {
		//Given
		Trello trello = new Trello(1,2);


		//When
		int board = trello.getBoard();
		int card = trello.getCard();

		//Then
		assertEquals(1, board);
		assertEquals(2, card);
	}

}
