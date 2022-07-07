package di.uniba.map.game.engine;

import di.uniba.map.game.parser.Parser;
import di.uniba.map.game.parser.ParserOutput;
import di.uniba.map.game.type.CommandType;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Engine {

    private final GameDescription game;
    private final Parser cmd;
    private final Utils u = new Utils();
    private boolean flagDb = false;

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

    public void run() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        u.printRoom(game);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\ncosa vuoi fare: ");
            while(scanner.hasNextLine()){
                String c = scanner.nextLine();
                System.out.println();
                ParserOutput command = cmd.parseCmd(c, game);
                if(command.getCommand() != null && command.getCommand().getType() == CommandType.END){
                    System.out.println("Forse una decisione poco saggia, ma è pur sempre una decisione!");
                    break;
                }else{
                    u.move(command, game);
                }
                if(game.isWin(game) || game.isLose()){
                    System.out.println("Game Over... ");
                    break;
                }
                System.out.print("\ncosa vuoi fare: ");
            }
        }
    }

    public static void engine(Engine engine) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        engine.begin();
        engine.run();
    }
}
