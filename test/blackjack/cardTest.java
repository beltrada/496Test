package edu.osu.blackjack;

import static org.junit.Assert.*;
import org.junit.Test;

public class cardTest{

	@Test
	public void testToString(){

	Card test = new Card(Card.Face.ACE, Card.Suit.SPADE);

	String test2 = "ACESPADE";

	assertEquals(test2, test.toString());



	}

	
	@Test
	public void testVisible(){

		Card test = new Card(Card.Face.ACE, Card.Suit.SPADE);

		boolean result = test.isVisible();
		assertFalse(result);

		test.setVisible(true);

		boolean result2 = test.isVisible();
		assertTrue(result2);

		test.setVisible(false);

		boolean result3 = test.isVisible();
		assertFalse(result3);
	}

}
