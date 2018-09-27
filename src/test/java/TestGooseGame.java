import org.junit.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public
class TestGooseGame {

    @Test
    public void TestPippo() {
        GooseGame gooseGame = new GooseGame();
        assertEquals("players: Pippo", gooseGame.addPlayerAndMove("add player Pippo"));
        assertThat( gooseGame.addPlayerAndMove("add player Pippo"), is("player Pippo"));
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

}


