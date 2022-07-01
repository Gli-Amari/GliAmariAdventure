package di.uniba.map.game.type;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Francesco Pio Scoglietti
 * In questa classe vengono definite le caratteristiche delle stanze
 */
public class Room {
    private final int id;
    private String name;
    private String description;
    private String look= "Vuoto";
    private boolean locked = false;
    private boolean explored = false;
    private Room south = null;
    private Room north = null;
    private Room east = null;
    private Room west = null;
    private Triggers.triggerInterface triggerReference = null;
    private final List<Item> items = new ArrayList<>();
    private final List<Npc> npc = new ArrayList<>();

    
    /** 
     * @return int
     */
    public int getId()
    {
        return id;
    }

    public Room(int id, String name, String description) 
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    /** 
     * @return String
     */
    public String getName()
    { 
        return name;
    }

    
    /** 
     * @return String
     */
    public String getDescription() 
    { 
        return description;
    }

    
    /** 
     * @return Room
     */
    public Room getSouth() 
    {
        return south;
    }

    
    /** 
     * @param south
     */
    public void setSouth(Room south) 
    {
        this.south = south;
    }

    
    /** 
     * @return Room
     */
    public Room getNorth() 
    {
        return north;
    }

    
    /** 
     * @param north
     */
    public void setNorth(Room north) 
    {
        this.north = north;
    }

    
    /** 
     * @return Room
     */
    public Room getEast() 
    {
        return east;
    }

    
    /** 
     * @param east
     */
    public void setEast(Room east) 
    {
        this.east = east;
    }

    
    /** 
     * @return Room
     */
    public Room getWest() 
    {
        return west;
    }

    
    /** 
     * @param west
     */
    public void setWest(Room west) 
    {
        this.west = west;
    }

    
    /** 
     * @return List<Item>
     */
    public List<Item> getItems() 
    {
        return items;
    }

    
    /** 
     * @return List<Npc>
     */
    public List<Npc> getNpcs() 
    {
        return npc;
    }

    
    /** 
     * @return String
     */
    public String getLook() 
    {
        return look;
    }

    
    /** 
     * @param look
     */
    public void setLook(String look) 
    {
        this.look = look;
    }

    
    /** 
     * @return boolean
     */
    public boolean getLock()
    {
        return locked;
    }

    
    /** 
     * @param lock
     */
    public void setLock(boolean lock)
    {
        this.locked = lock;
    }

    
    /** 
     * @return boolean
     */
    public boolean getExplored()
    {
        return this.explored;
    }

    
    /** 
     * @param exp
     */
    public void setExplored(boolean exp)
    {
        this.explored = exp;
    }

    
    /** 
     * @param T
     */
    public void setTriggerReference(Triggers.triggerInterface T)
    {
        this.triggerReference = T;
    }

    
    /** 
     * @return triggerInterface
     */
    public Triggers.triggerInterface getTriggerReference()
    {
        return this.triggerReference;
    }
}
