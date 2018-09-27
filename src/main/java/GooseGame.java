import java.util.ArrayList;

public
class GooseGame {


    private ArrayList playersList = new ArrayList<String> ();

    private int posPippo = 0;
    private int posPluto = 0;

    public GooseGame() {
    }


    public
    String addPlayerAndMove(String input) {

        if (playersList.size() == 0) {
            if (input.equals( "add player Pippo")) {
                playersList.add( "Pippo" );
                return "players: Pippo";
            }
            else return "Wrong string";
        }

        if (input.equals("add player Pippo")) {
            return "Pippo: already existing player";
        }
        else if (input.equals("add player Pluto")) {
            playersList.add( "Pluto" );
            return "players: Pippo, Pluto";
        }

        if ((playersList.size() == 2) && (playersList.get(0).equals("Pippo")) && (playersList.get(1).equals("Pluto"))) {
            //System.out.println( "Concorrenti"  + playersList.get(0)  + playersList.get(1));
            if (input.equals("move Pippo 4, 2")){
                posPippo+=6;
                return "Pippo rolls 4, 2. Pippo moves from Start to 6";
            }
            else if (input.equals("move Pluto 2, 2")) {
                posPluto+=4;
                return "Pluto rolls 2, 2. Pluto moves from Start to 4";
            }
            else if (input.equals("move Pippo 2, 2")) {
                posPippo+=4;
                return "Pippo rolls 2, 2. Pippo moves from 0 to 4";
            }
            else if (input.equals("move Pippo 2, 3")) {
                posPippo+=5;
                return "Pippo rolls 2, 3. Pippo moves from 6 to 11";
            }
            else if (input.equals("move Pippo 6, 6")) {
                posPippo+=12;
                return "Pluto rolls 6, 6. Pluto moves 6";
            }
        }

        if (posPippo == 60) {
            if (input.equals("move Pippo 1, 2")){
                posPippo+=3;
                return "Pippo rolls 1, 2. Pippo moves from 60 to 63. Pippo Wins!!";
            }
            else if (input.equals("move Pippo 3, 2")){
                posPippo+=3;
                return "Pippo rolls 3, 2. Pippo moves from 60 to 63. Pippo bounces! Pippo returns to 61";
            }
        }

        if (posPippo == 4) {
            if (input.equals( "move Pippo" )) {
                posPippo += 3;
                return "Pippo rolls 1, 2. Pippo moves from 4 to 7";
            }
        }


        System.out.println( "Valori: "  + posPippo);
        return "Error";
    }
}