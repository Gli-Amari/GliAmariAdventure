package di.uniba.map.game.parser;

import di.uniba.map.game.type.Item;
import di.uniba.map.game.type.Command;
import di.uniba.map.game.type.Npc;

public class ParserOutput {

    private Command command;
    private Item item;
    private Item containerItem;
    private Npc npc;

    public ParserOutput(Command command, Item item) {
        this.command = command;
        this.item = item;
    }

    public ParserOutput(Command command, Item container, Item item) {
        this.command = command;
        this.item = container;
        this.containerItem = item;
    }

    public ParserOutput(Command command, Npc npc) {
        this.command = command;
        this.npc = npc;
    }

    public Command getCommand() { return command;}
    public Item getItem() { return item;}
    public Item getContainerItem() { return containerItem;}
    public Npc getNpc() { return npc;}
    
}
