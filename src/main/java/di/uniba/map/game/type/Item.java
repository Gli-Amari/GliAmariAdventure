package di.uniba.map.game.type;

import java.util.*;

/**
 * @author Francesco Pio Scoglietti
 * Definizione composizione oggetti di gioco
 */
public class Item { 

    private final int id;
    private String name;
    private String description;
    private List<Item> list = new ArrayList<>();
    private boolean openable = false;
    private Item openWith = null;
    private boolean pickupable = true;
    private boolean weapon = false;
    private int power = 0;
    private boolean healer = false;
    private int heal = 0;
    private boolean armor = false;
    private int protection = 0;
    private boolean pushable = false;
    private boolean container = false;
    private boolean open = false;
    private boolean push = false;

    public Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
    public String getName() {
        return name;
    }

    
    /** 
     * @return String
     */
    public String getDescription() {
        return description;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return boolean
     */
    public boolean isPushable() {
        return pushable;
    }

    
    /** 
     * @param pushable
     */
    public void setPushable(boolean pushable) {
        this.pushable = pushable;
    }

    
    /** 
     * @return boolean
     */
    public boolean isOpen() {
        return open;
    }

    
    /** 
     * @param open
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    
    /** 
     * @return boolean
     */
    public boolean isPush() {
        return push;
    }

    
    /** 
     * @param push
     */
    public void setPush(boolean push) 
    {
        this.push = push;
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

    
    /** 
     * @param item
     */
    public void setOpenWith(Item item)
    {
        this.openWith = item;
    }

    
    /** 
     * @return Item
     */
    public Item getOpenWith()
    {
        return this.openWith;
    }
}
