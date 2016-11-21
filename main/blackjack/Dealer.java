package edu.osu.blackjack;

import java.util.*;

public  class Dealer implements DealerAction{


	
	public List<Card> dealerHand = new ArrayList<Card>();
	public List<Card> deck;

	public Dealer(){
		reset();
	}

	@Override
	public void acceptCard(Card c) {
		dealerHand.add(c);
	}

	@Override
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

	@Override
	public void dealCard(CommonAction toPlayer) {
		Card c = this.dealCardFromDeck(true);
		toPlayer.acceptCard(c);
	}

	@Override
	public void compareHandAndSettle(PlayerAction p) {
		int dealerScore = handScore(dealerHand);
		int currentBet = p.getCurrentBet();
		
		if(dealerScore<handScore(p.getHand())){
			p.acceptMoney(currentBet*2);
		}
		else if(isInsuranceAvailable() && dealerScore == 21){
			p.acceptMoney(currentBet*3);
		}
		System.out.print("Dealer's handcards: ");
		for(Card c:dealerHand){
			System.out.print(c.toString() + ";");
		}
		System.out.println("");
		System.out.println("Insurance is available?: " + isInsuranceAvailable());
		System.out.println("Dealer's Hand Score: " + dealerScore);


		System.out.println("Player's Hand Score: " + handScore(p.getHand()));
		System.out.println("Player $ earned After settle " + p.toString());
		
		deck.addAll(p.getHand());
		// p.nextHand();
	
		// deck.addAll(dealerHand);
		// dealerHand.clear();
	}

	@Override
	public void nextHand(){
		deck.addAll(dealerHand);
		dealerHand.clear();
		dumpDeck(deck);
		System.out.println("------------------------------------------");
	}


	
	public void reset(){
		
		dealerHand = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		setDeck(Card.newDeck());
	}
	
	public void setDeck(List<Card> c){
		deck = c;
	}
	

	public boolean isInsuranceAvailable() {
		for(Card c: dealerHand){
			if(c.face == Card.Face.ACE && c.isVisible()){
				return true;
			}
		}
		return false;
	}

	@Override
	public int handScore(List<Card> currentHand) {
		int score = 0;
		for(Card c:currentHand){
			score += c.face.getValue();
			if(score > 21)
				return -1;
		}
		return score;
	}

	/*
	public boolean isAnyoneBroke() {
		for(PlayerState p : playerState){
			if(p.currentWallet != null && p.currentWallet < 0)
				return true;
		}
		return false;
	}*/
	
	public static void dumpDeck(List<Card> c){
		System.out.print("Deck:");
		for(Card z : c) System.out.print(z.toString() + ";");
		System.out.println("");
	}


	private Card dealCardFromDeck(boolean b) {
		Card c = deck.remove(0);
		c.setVisible(b);
		return c;
	}

	@Override
	public List<Card> getHand() {
		return dealerHand;
	}

}



	

	


