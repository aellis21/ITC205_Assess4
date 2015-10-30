
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BugTests {

	Dice d1, d2, d3;
    Player player;
    Game game;
    int balance;

    @Before
    public void setUp() throws Exception {
        Dice d1 = mock(Dice.class);
        when(d1.getValue()).thenReturn(DiceValue.values()[0]);
        Dice d2 = mock(Dice.class);
        when(d2.getValue()).thenReturn(DiceValue.values()[1]);
        Dice d3 = mock(Dice.class);
        when(d3.getValue()).thenReturn(DiceValue.values()[2]);


        balance = 100;
        player = new Player("Fred", balance);
        game = new Game(d1, d2, d3);
    }

    @After
    public void tearDown() throws Exception {
    	player = null;
    	game = null;
    }

    @Test
    public void receiveWinnings_SingleDieCorrect() {
        int bet = 10;
    	player.setLimit(0);
        DiceValue diceFace = DiceValue.values()[0];
        game.playRound(player, diceFace, bet);
        
        assertEquals(balance + bet, player.getBalance());
        
    }
    
    @Test
    public void balanceExceedsLimitBy_PlayerCanReachLimit(){
    	assertTrue(player.balanceExceedsLimitBy(player.getBalance()));
    }
    
}
