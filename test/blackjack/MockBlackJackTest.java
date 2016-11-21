// package edu.osu.blackjack;


// import static org.junit.Assert.*;
// import org.junit.Test;
// import java.util.Random;
// import static org.mockito.Mockito.*;

// public class MockBlackJackTest {
//     @Test
//     public void testDouble(){
// 	// Does it run without errors for a simple case?
// 	DealerAction dt = mock(DealerAction.class);
// 	PlayerAction pa = mock(PlayerAction.class);

// 	//  This player is feeling charitiable....
// 	when(pa.getAction()).thenReturn(PlayerAction.ActionType.DOUBLE);                          
// 	SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
// 	j.playRound();
// 	verify(dt, times(3)).dealCard(pa);
//     }
	

// 	 @Test
//     public void testStand(){
// 	// Does it run without errors for a simple case?
// 	DealerAction dt = mock(DealerAction.class);
// 	PlayerAction pa = mock(PlayerAction.class);

// 	//  This player is feeling charitiable....
// 	when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);	                          
// 	SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
// 	j.playRound();
// 	verify(dt, times(2)).dealCard(pa);
//     }
	
// 	@Test
//     public void testDealToDealer(){
// 	// Does it run without errors for a simple case?
// 	DealerAction dt = mock(DealerAction.class);
// 	PlayerAction pa = mock(PlayerAction.class);

// 	//  This player is feeling charitiable....
// 	when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);	                          
// 	SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
// 	j.playRound();
// 	verify(dt, times(2)).dealCard(dt);
//     }
	
// 	@Test
// 	public void testPlayerBet(){
// 		DealerAction dt = mock(DealerAction.class);
// 		PlayerAction pa = mock(PlayerAction.class);
// 		when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);
// 		SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
// 		j.playRound();
// 		verify(pa,times(1)).makeBet();

// 	}

// 	@Test
// 	public void testDealerShuffle(){
// 		DealerAction dt = mock(DealerAction.class);
// 		PlayerAction pa = mock(PlayerAction.class);
// 		when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);
// 		SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
// 		j.playRound();
// 		verify(dt,times(1)).shuffleDeck();

// 	}

// 	@Test
// 	public void testMulptiplePlayers(){
// 		DealerAction dt = mock(DealerAction.class);
// 		PlayerAction pa = mock(PlayerAction.class);
// 		PlayerAction pa2 = mock(PlayerAction.class);
// 		when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);
// 		when(pa2.getAction()).thenReturn(PlayerAction.ActionType.HIT)
// 							 .thenReturn(PlayerAction.ActionType.HIT)
// 							 .thenReturn(PlayerAction.ActionType.HIT)
// 							 .thenReturn(PlayerAction.ActionType.STAND);
// 		SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa, pa2});
// 		j.playRound();
// 		verify(dt,times(1)).compareHandAndSettle(pa);
// 		verify(dt,times(1)).compareHandAndSettle(pa2);

// 	}
// }

