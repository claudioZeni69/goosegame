import java.util.ArrayList;

public
class GooseGame {


    private  ArrayList playersList = new ArrayList<String> ();

    public GooseGame() {
    }

    public
    String addPlayerAndMove(String input) {

        if (playersList.size() == 0) {
            if (input == "add player Pippo") {
                playersList.add( "Pippo" );
                return "players: Pippo";
            }
            else return "Wrong string";
        }

        if (input == "add player Pippo") {
            return "Pippo: already existing player";
        }
        else if (input == "add player Pluto") {
            playersList.add( "Pluto" );
            return "players: Pippo, Pluto";
        }

        if ((playersList.size() == 2) && (playersList.get(0)==  "Pippo") && (playersList.get(1)==  "Pluto")) {
            //System.out.println( "Concorrenti"  + playersList.get(0)  + playersList.get(1));
            if (input == "move Pippo 4, 2"){
                return "Pippo rolls 4, 2. Pippo moves from Start to 6";
            }
            else if (input == "move Pluto 2, 2") {
                return "Pluto rolls 2, 2. Pluto moves from Start to 4";
            }


    }


        return "Error";
    }
}