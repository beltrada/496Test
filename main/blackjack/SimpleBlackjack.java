package edu.osu.blackjack;




public class SimpleBlackjack {
	public enum ActionType {HIT , DOUBLE, STAND};
	private int numPlayers;
	
	DealerAction dealer;
	PlayerAction[] players ;

	
	public SimpleBlackjack(DealerAction d, PlayerAction[] ip){
		this.dealer = d;
		this.players = ip;
	}

	public void clearPlayerBets(){
		int playerNum = 1;
		for(PlayerAction p: players){
			p.nextHand();
			System.out.println("Player" +playerNum + " status after nextHand() is called: " + p.toString());
			playerNum++;
		}
	}

	public void clearDealerHand(){
		dealer.nextHand();
	}
	
	public void playRound(){

		dealer.shuffleDeck();
		
		for(PlayerAction p: players ){
			p.makeBet();
		}
		
		dealer.dealCard(dealer);
		dealer.dealCard(dealer);

		for(PlayerAction p: players ){
		
			dealer.dealCard(p);
			dealer.dealCard(p);
		}
	
		if(dealer.isInsuranceAvailable()){
			int playerNum = 1;
			for(PlayerAction p: players ){
				p.makeInsuranceBet();
				System.out.println("Player" +playerNum + " status after makeInsuranceBet() is called: " + p.toString());
				playerNum++;
			}
		}

		for(PlayerAction p: players ){
			boolean turnOver = false;
			while(!turnOver){
				PlayerAction.ActionType a = p.getAction();	
				switch(a){
					case HIT:
						dealer.dealCard(p);		
						break;
					case DOUBLE:
						p.doubleDownBet();
						dealer.dealCard(p);
						turnOver = true;
						break;
					default: // stand
						turnOver = true;
						break;
				}
		
			}
		}

		for(PlayerAction p: players){
			dealer.compareHandAndSettle(p);
		}
	}
}
