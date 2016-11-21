package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import java.util.*;
import edu.osu.blackjack.Dealer;
import edu.osu.blackjack.Dealer.*;
import edu.osu.blackjack.Player;
import edu.osu.blackjack.Player.*;
import edu.osu.blackjack.Card;
import edu.osu.blackjack.Card.*;



public class simpleBlackjackRandomTest{

	@Test
	public void test_randomRound(){
		Random psuedoRandElement = new Random();
		psuedoRandElement.setSeed(System.currentTimeMillis());
		int numPlayers = psuedoRandElement.nextInt(4)+1;
		System.out.println("Number of players: " + numPlayers);
		Player[] players = new Player[numPlayers];

		for (int i=0; i<numPlayers; i++){
			int spendingPower = psuedoRandElement.nextInt(51)+50; //each wallet between $50-100
			players[i] = new Player();
			players[i].currentWallet = spendingPower;
			System.out.println("Player #" + (i+1) + " wallet: " + players[i].currentWallet);
		}

		Dealer dealer = new Dealer();

		List<Card> randomDeck; //only ACES and TENS cards to simulate insurance available
		randomDeck = new ArrayList<Card>();
		int numCards = psuedoRandElement.nextInt(53)+16;
		System.out.println("Number of Cards: " + numCards);
		dealer.reset();

		for(int i=0; i <numCards; i++){
			randomDeck.add(dealer.deck.get(psuedoRandElement.nextInt(dealer.deck.size()-1)));
		}

		dealer.setDeck(randomDeck); //don't shuffle here
		assertThat(randomDeck.size(), greaterThanOrEqualTo(16));


		int numOfRounds = psuedoRandElement.nextInt(2)+1; //up to 2 rounds
		System.out.println("Total # of rounds: " + numOfRounds);
		SimpleBlackjack j = new SimpleBlackjack(dealer,players);
		//play random number of times
		for (int i= 0; i < numOfRounds; i++ ){
			System.out.println("BEGIN Round #" + (i+1) + " of Insurance & Random Wallet");

			j.playRound();
			for (int n=0; n <numPlayers; n++ ){
				assertThat("wallets are all positive", players[n].currentWallet, greaterThan(0));
			}

			j.clearPlayerBets();
			assertThat("p1 insurance cleared", players[0].currentInsurance, nullValue());
			assertThat("p1 bet cleared", players[0].currentBet, nullValue());
			assertThat("p1 wallet still there", players[0].currentWallet, greaterThan(0));
			assertThat("p1 hand is clearedd", players[0].getHand(), is(empty()));
			assertThat("p2 insurance cleared", players[1].currentInsurance, nullValue());
			assertThat("p2 bet cleared", players[1].currentBet, nullValue());
			assertThat("p2 wallet still there", players[1].currentWallet, greaterThan(0));
			assertThat("p2 hand is clearedd", players[1].getHand(), is(empty()));


			j.clearDealerHand();
			assertThat("dealerHand is empty", dealer.getHand(), is(empty()));
			System.out.println("--------------------------------------------");
			//start next round
		}
	}
}