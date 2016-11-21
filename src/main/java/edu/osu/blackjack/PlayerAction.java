package edu.osu.blackjack;

import java.util.*;

public interface PlayerAction  extends CommonAction{

	public enum ActionType {HIT , DOUBLE, STAND};
	
	public int makeBet();
	public int doubleDownBet();
	public int makeInsuranceBet();
	public ActionType getAction();
	public int getCurrentBet();
	public void acceptMoney(int i);
}
