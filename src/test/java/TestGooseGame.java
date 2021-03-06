import org.junit.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public
class TestGooseGame {

    @Test
    public void TestPippo() {
        GooseGame gooseGame = new GooseGame();
        assertEquals("players: Pippo", gooseGame.addPlayerAndMove("add player Pippo"));
        //assertThat( gooseGame.addPlayerAndMove("add player Pippo"), is("player Pippo"));
    }

    @Test
    public void TestWrongFirstUser() {
        GooseGame gooseGame = new GooseGame();
        assertEquals("Wrong string", gooseGame.addPlayerAndMove("add player Claudio"));
    }

    @Test
    public void TestWrongUser() {
        GooseGame gooseGame = new GooseGame();
        gooseGame.addPlayerAndMove("add player Pippo");
        assertEquals("Error", gooseGame.addPlayerAndMove("add player Claudio"));
    }

    @Test
    public void TestPluto() {
        GooseGame gooseGame = new GooseGame();
        gooseGame.addPlayerAndMove("add player Pippo");
        assertEquals("players: Pippo, Pluto", gooseGame.addPlayerAndMove("add player Pluto"));
    }

    @Test
    public void TestWrongPippo() {
        GooseGame gooseGame = new GooseGame();
        gooseGame.addPlayerAndMove("add player Pippo");
        assertEquals("Pippo: already existing player", gooseGame.addPlayerAndMove("add player Pippo"));
    }

    @Test
    public void TestMove1() {
        GooseGame gooseGame = new GooseGame();
        gooseGame.addPlayerAndMove("add player Pippo");
        gooseGame.addPlayerAndMove("add player Pluto");

        assertThat( gooseGame.addPlayerAndMove("move Pippo 4, 2"), is("Pippo rolls 4, 2. Pippo moves from Start to 6"));
    }

    @Test
    public void TestMove2() {
        GooseGame gooseGame = new GooseGame();
        gooseGame.addPlayerAndMove("add player Pippo");
        gooseGame.addPlayerAndMove("add player Pluto");

        assertThat( gooseGame.addPlayerAndMove("move Pluto 2, 2"), is("Pluto rolls 2, 2. Pluto moves from Start to 4"));
    }

    @Test
    public void TestMove3() {
        GooseGame gooseGame = new GooseGame();
        gooseGame.addPlayerAndMove("add player Pippo");
        gooseGame.addPlayerAndMove("add player Pluto");

        assertThat( gooseGame.addPlayerAndMove("move Pippo 2, 3"), is("Pippo rolls 2, 3. Pippo moves from 6 to 11"));
    }

    @Test
    public void TestWin() {
        GooseGame gooseGame = new GooseGame();
        gooseGame.addPlayerAndMove("add player Pippo");
        gooseGame.addPlayerAndMove("add player Pluto");

        for (int i = 0; i < 5;i++) {
            gooseGame.addPlayerAndMove("move Pippo 6, 6");
        }

        assertThat( gooseGame.addPlayerAndMove("move Pippo 1, 2"), is("Pippo rolls 1, 2. Pippo moves from 60 to 63. Pippo Wins!!"));
    }

    @Test
    public void TestReturn() {
        GooseGame gooseGame = new GooseGame();
        gooseGame.addPlayerAndMove("add player Pippo");
        gooseGame.addPlayerAndMove("add player Pluto");

        for (int i = 0; i < 5;i++) {
            gooseGame.addPlayerAndMove("move Pippo 6, 6");
        }

        assertThat( gooseGame.addPlayerAndMove("move Pippo 3, 2"), is("Pippo rolls 3, 2. Pippo moves from 60 to 63. Pippo bounces! Pippo returns to 61"));
    }

    @Test
    public void TestRoll() {
        GooseGame gooseGame = new GooseGame();
        gooseGame.addPlayerAndMove("add player Pippo");
        gooseGame.addPlayerAndMove("add player Pluto");
        gooseGame.addPlayerAndMove("move Pippo 2, 2");

        assertThat( gooseGame.addPlayerAndMove("move Pippo"), is("Pippo rolls 1, 2. Pippo moves from 4 to 7"));
    }


}


