package edu.osu.blackjack;


import java.util.ArrayList;
import java.util.List;



public  class Player implements PlayerAction{

	public Integer currentBet;
	public Integer currentWallet = 1000;
	public Integer currentInsurance ;

	public List<Card> currentHand = new ArrayList<Card>();
	
	@Override
	public void acceptCard(Card c) {
		currentHand.add(c);
	}
	@Override
	public int makeBet(){
		this.currentBet = 10;
		return currentBet;
	}
	@Override
	public  int doubleDownBet(){
		this.currentBet *= 2;
		return this.currentBet;
	}
	@Override
	public  int makeInsuranceBet(){
			this.currentInsurance = 5;
			System.out.println("Insurance bet placed for amount: " + this.currentInsurance);
		return this.currentInsurance;
	}
	@Override
	public  ActionType getAction(){
		return ActionType.STAND;
	}
	@Override
	public List<Card> getHand() {
		return this.currentHand;
	}
	@Override
	public int getCurrentBet() {
		return this.currentBet;
	}
	@Override
	public void acceptMoney(int i) {
		this.currentWallet += i;
	}
	
	
	public void moveMoneyToInsurance(int amount) {
		if (this.currentWallet >= amount) {
			this.currentWallet = this.currentWallet - amount;
			this.currentInsurance = amount;
		} else
			throw new RuntimeException();
	}
	public void moveMoneyToBet(int amount) {
		if (this.currentWallet >= amount) {
			this.currentBet = amount;
			this.currentWallet -= amount;
		} else
			throw new RuntimeException();
	}
	@Override
	public void nextHand() {
		this.currentBet = null;
		this.currentInsurance = null;
		this.currentHand.clear();
	}

	@Override	
	public String toString() {
		return "Player: " + this.currentHand + " w: " +this.currentWallet + " b: " + this.currentBet + " i: " + this.currentInsurance;
	}

	@Override
	public int handScore(List<Card> currentHand) {
		int score = 0;
		for(Card c:this.currentHand){
			score += c.face.getValue();
			if(score > 21)
				return -1;
		}
		return score;
	}

	
}
