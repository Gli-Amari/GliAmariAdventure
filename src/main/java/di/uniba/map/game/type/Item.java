package di.uniba.map.game.type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import di.uniba.map.game.databases.Db;

/**
 * @author Francesco Pio Scoglietti
 * Definizione composizione oggetti di gioco
 */
public class Item { 

    /**
     * query
     */
    public static final String SELECTNAME = "SELECT name FROM item WHERE id = ?";
    public static final String SELECTDESCRIPTION = "SELECT desc FROM item WHERE id = ?";

    private final int id;
    private List<Item> list = new ArrayList<>();
    private boolean openable = false;
    private boolean pickupable = true;
    private boolean weapon = false;
    private int power = 0;
    private boolean healer = false;
    private int heal = 0;
    private boolean armor = false;
    private int protection = 0;
    private boolean container = false;
    private int bullet = 0;

    public Item(int id) {
        this.id = id;
    }

    /** 
     * @return int
     */
    public int getBullet() {
        return bullet;
    }

    /** 
     * @param bullet
     */
    public void setBullet(int bullet) {
        this.bullet = bullet;
    }

    /** 
     * @return int
     */
    public int getId() {
        return id;
    }
    
    /** 
     * @param weapon
     * @return boolean
     */
   
    public boolean isWeapon(){return weapon;}

    
    /** 
     * @param weapon
     */
    public void setWeapon(boolean weapon){
        this.weapon = weapon;
    }

    public int getPower(){ return power;};

    
    /** 
     * @param power
     */
    public void setPower(int power){
        this.power = power;
    }

    
    /** 
     * @param armor
     * @return boolean
     */

    public boolean isArmor(){return armor;}

    
    /** 
     * @param armor
     */
    public void setArmor(boolean armor){
        this.armor = armor;
    }

    public int getProtection(){ return protection;};

    
    /** 
     * @param protection
     */
    public void setProtection(int protection){
        this.protection = protection;
    }

    
    /** 
     * @param getName(
     */
    public void setIsContainer(boolean cont) 
    { 
        this.container = cont;
    }

    
    /** 
     * @return boolean
     */
    public boolean getIsContainer() 
    { 
        return this.container;
    }

    
    /** 
     * @return List<Item>
     */
    public List<Item> getItemList() 
    { 
        return this.list;
    }

    
    /** 
     * @return String
     */
    public String getName(Db db) {
        String name = getInformationAdvObject(db,SELECTNAME);

        return name;
    }

    
    /** 
     * @return String
     */
    public String getDescription(Db db) {
        String description = getInformationAdvObject(db,SELECTDESCRIPTION);

        return description;
    }

    
    /** 
     * @param db
     * @param select
     * @return String
     */
    public String getInformationAdvObject(Db db, String select){
        String resultSelect= new String();
        try{
            ResultSet rs = db.readFromDb(select,getId());
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
    public boolean isOpenable() {
        return openable;
    }

    
    /** 
     * @param openable
     */
    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    
    /** 
     * @return boolean
     */
    public boolean isPickupable() {
        return pickupable;
    }

    
    /** 
     * @param pickupable
     */
    public void setPickupable(boolean pickupable) {
        this.pickupable = pickupable;
    }

    
    /** 
     * @param healer
     */
    public void setHealer(boolean healer)
    {   
        this.healer = healer;
    }

    
    /** 
     * @return boolean
     */
    public boolean getHealer()
    {
        return this.healer;
    }

    
    /** 
     * @param heal
     */
    public void setHeal(int heal)
    {
        this.heal = heal;
    }

    
    /** 
     * @return int
     */
    public int getHeal()
    {
        return this.heal;
    }
}
