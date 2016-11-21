// package edu.osu.blackjack;


// import static org.junit.Assert.*;
// import org.junit.Test;
// import java.util.Random;
// import static org.mockito.Mockito.*;
// import edu.osu.blackjack.Dealer;
// import edu.osu.blackjack.Dealer.*;
// import edu.osu.blackjack.Player;
// import edu.osu.blackjack.Player.*;
// import edu.osu.blackjack.Card;
// import edu.osu.blackjack.Card.*;

// public class VerifiedTest {
//     @Test
//     public void testAcceptCard(){

//     	Dealer dealerTest = new Dealer();
//     	Card testCard = new Card(Card.Face.ACE, Card.Suit.CLUB);

//     	dealerTest.acceptCard(testCard);

//         Card temp1 = dealerTest.getHand()

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

//     @Test
//     public void testDouble(){
//     // Does it run without errors for a simple case?
//     DealerAction dt = mock(DealerAction.class);
//     PlayerAction pa = mock(PlayerAction.class);

//     //  This player is feeling charitiable....
//     when(pa.getAction()).thenReturn(PlayerAction.ActionType.DOUBLE);                          
//     SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
//     j.playRound();
//     verify(dt, times(3)).dealCard(pa);
//     }
// }