package di.uniba.map.game.type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import di.uniba.map.game.databases.Db;

/**
 * @author Francesco Pio Scoglietti
 * In questa classe vengono definite le caratteristiche delle stanze
 */
public class Room {

    /**
     * query
     */
    public static final String SELECTNAME = "SELECT name FROM room WHERE id = ?";
    public static final String SELECTDESCRIPTION = "SELECT desc FROM room WHERE id = ?";
    public static final String SELECTLOOK = "SELECT look FROM room WHERE id = ?";

    private final int id;
    private boolean firstTimeHere = true;
    private boolean explored = false;
    private Room south = null;
    private Room north = null;
    private Room east = null;
    private Room west = null;
    private final List<Item> items = new ArrayList<>();
    private final List<Npc> npc = new ArrayList<>();

    /** 
     * @return int
     */
    public int getId()
    {
        return id;
    }

    public Room(int id) 
    {
        this.id = id;
    }
    
    /** 
     * @return String
     */
    public String getName(Db db)
    { 
        String name = getInformationRoom(db, SELECTNAME);
        return name;
    }

    
    /** 
     * @return String
     */
    public String getDescription(Db db) 
    { 
        String description = getInformationRoom(db, SELECTDESCRIPTION);
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
    public String getLook(Db db) 
    {
        String look = getInformationRoom(db, SELECTLOOK);
        return look;
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
     * @param db
     * @param select
     * @return String
     */
    public String getInformationRoom(Db db, String select){
        String resultSelect = new String();
        try{
            ResultSet rs = db.readFromDb(select, getId());
            while(rs.next()){
                resultSelect= rs.getString(1);
            }
            rs.close();
        }catch(SQLException ex){
            System.err.println(ex.getSQLState() + ":" + ex.getMessage());
        }
        
        return resultSelect;
    }

    
    /** 
     * @return boolean
     */
    public boolean getFirstTimeHere(){
        return firstTimeHere;
    }

    
    /** 
     * @param firstTimeHere
     */
    public void setFirstTimeHere(Boolean firstTimeHere){
        this.firstTimeHere= firstTimeHere;
    }
}
