// package edu.osu.blackjack;


// import static org.junit.Assert.*;
// import org.junit.Test;
// import java.util.Random;
// import edu.osu.blackjack.Dealer;
// import edu.osu.blackjack.Dealer.*;
// import edu.osu.blackjack.Player;
// import edu.osu.blackjack.Player.*;
// import edu.osu.blackjack.Card;
// import edu.osu.blackjack.Card.*;

// public class DealerTest {
//     @Test
//     public void testAcceptCard(){

//     	Dealer dealerTest = new Dealer();
//     	Card testCard = new Card(Card.Face.ACE, Card.Suit.CLUB);

//     	dealerTest.acceptCard(testCard);

//         Card temp1 = dealerTest.currentHand.get(0);

//     	assertEquals(testCard.toString(), temp1.toString());


//     }

//     @Test
//     public void testGetHand(){

//         Dealer dealerTest = new Dealer();
//         Player playerTest = new Player();
//         Card testCard = new Card(Card.Face.ACE, Card.Suit.CLUB);
//         Card testCard2 = new Card(Card.Face.JACK, Card.Suit.CLUB);
//         dealerTest.acceptCard(testCard);
//         dealerTest.acceptCard(testCard2);


//         dealerTest.setDeck(dealerTest.getHand());

//         dealerTest.dealCard(playerTest);

//         Card temp1 = playerTest.currentHand.get(0);

//         assertEquals(testCard.toString(), temp1.toString());

//     }
// }