package di.uniba.map.game.parser;

import di.uniba.map.game.type.Item;
import di.uniba.map.game.type.Command;
import di.uniba.map.game.type.Npc;

/**
 * Classe per la gestione del parsing del comando.
 * permette di assegnare ad un oggetto di questa classe un comando e un oggetto.
 * 
 * @author Piersilvio Spicoli
 */
public class ParserOutput {

    private Command command;
    private Item item;
    private Npc npc;

    public ParserOutput(Command command, Item item) {
        this.command = command;
        this.item = item;
    }

    public ParserOutput(Command command, Npc npc) {
        this.command = command;
        this.npc = npc;
    }

    /** 
     * @return Command
     */
    public Command getCommand() { 
        return command;
    }
    
    /** 
     * @return Item
     */
    public Item getItem() { 
        return item;
    }
    
    /** 
     * @return Npc
     */
    public Npc getNpc() { 
        return npc;
    }   
}
