
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public
class MyGooseGameApp extends HttpServlet {

    List<String> names = new ArrayList<>();

    @Override
    protected
    void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter( "dice1" ) != null && req.getParameter( "dice2") != null ) {
            names.add( req.getParameter( "dice1" ) );
            names.add( req.getParameter( "dice2" ) );
        }

        if (names.isEmpty()) {
            write( resp, "empty" );
        } else {

            String URI = req.getRequestURI();
            //System.out.println( URI );

            GooseGame gooseGame = new GooseGame();
            gooseGame.addPlayerAndMove( "add player Pippo" );
            gooseGame.addPlayerAndMove( "add player Pluto" );
            //gooseGame.addPlayerAndMove("move Pippo 2, 3");

            String moveStr = "move " + URI.substring( 9, 14 ) + " " + names.get( 0 ) + ", " + names.get( 1 );
            //System.out.println( moveStr );

            write( resp, String.join( ",", gooseGame.addPlayerAndMove( moveStr ) ) );
        }
    }

    @Override
    protected
    void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        names.add( req.getParameter( "name" ) );

        GooseGame gooseGame = new GooseGame();

        String strInput = "add player " +  names.get(0);

        write( resp, gooseGame.addPlayerAndMove(strInput) );
    }

    private
    void write(HttpServletResponse resp, String message) throws IOException {
        resp.getWriter().write( message );
    }
}