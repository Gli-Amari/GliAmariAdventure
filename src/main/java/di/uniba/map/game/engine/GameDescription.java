package di.uniba.map.game.engine;

import di.uniba.map.game.type.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public abstract class GameDescription {

    private final List<Room> rooms = new ArrayList<>();
    private Room currentRoom;
    private final List<Command> commands = new ArrayList<>();
    private final static Player player = new Player(100, "");
    private final List<Item> itemList = new ArrayList<>();
    private final List<Npc> npcList = new ArrayList<>();

    /**
     * metodi astratti
     * @throws Exception
     */
    public abstract void init() throws Exception;
    public abstract boolean isWin(GameDescription game) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    public abstract boolean isLose() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;

    /**
     * metodi concreti
     */


    public List<Item> getItemList() {
        return itemList;
    }

    public List<Npc> getNpcList() {
        return npcList;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Inventory getInventory(){
        return player.getInventory();
    }

    public Player getPlayer(){ return player;}

}
