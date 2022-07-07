package di.uniba.map.game.engine;

import di.uniba.map.game.parser.Parser;
import di.uniba.map.game.parser.ParserOutput;
import di.uniba.map.game.type.CommandType;

import di.uniba.map.game.databases.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class Engine {

    public static Db db = new Db();
    private final GameDescription game;
    private final Parser cmd;
    private final Utils u = new Utils();

    public Engine(Object obj) {
        this.game = (GameDescription) obj;
        try {
            this.game.init();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        cmd = new Parser();
    }

    protected void begin(){
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("+                                                                     +");
        System.out.println("+                       La Storia degli Amari!                        +");
        System.out.println("+                                                                     +");
        System.out.println("-----------------------------------------------------------------------");
    }

    public void run() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
        u.printRoom(game, db);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\ncosa vuoi fare: ");
            while(scanner.hasNextLine()){
                String c = scanner.nextLine();
                System.out.println();
                ParserOutput command = cmd.parseCmd(c, game, db);
                if(command.getCommand() != null && command.getCommand().getType() == CommandType.END){
                    System.out.println("Forse una decisione poco saggia, ma è pur sempre una decisione!");
                    break;
                }else{
                    u.move(db, command, game);
                }
                if(game.isWin(game) || game.isLose()){
                    System.out.println("Game Over... ");
                    db.closeConnection();
                    break;
                }
                System.out.print("\ncosa vuoi fare: ");
            }
        }
    }

    public static void engine(Engine engine) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
        engine.begin();
        engine.run();
    }
}
