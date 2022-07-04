package di.uniba.map.game.type;

import java.util.*;

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

    private boolean explosive = false;

    private int nExplosive;

    public Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    
    public void setExplosive(boolean explosive){
        this.explosive = explosive;
    }

    
    public boolean getExplosive(){
        return explosive;
    }

    ////
    public void setnExplosive(int nExplosive){
        this.nExplosive = nExplosive;
    }

    public int getnExplosive(){
        return nExplosive;
    }
    ////


    public int getId() {
        return id;
    }

    public boolean isWeapon(){return weapon;}

    public void setWeapon(boolean weapon){
        this.weapon = weapon;
    }

    public int getPower(){ return power;};

    public void setPower(int power){
        this.power = power;
    }

    //end weapon

    //armor set

    public boolean isArmor(){return armor;}

    public void setArmor(boolean armor){
        this.armor = armor;
    }

    public int getProtection(){ return protection;};

    public void setProtection(int protection){
        this.protection = protection;
    }

    //end armor

    //Impostazione Oggetto che può contenere oggetti
    public void setIsContainer(boolean cont) { this.container = cont;}

    public boolean getIsContainer() { return this.container;}

    public List<Item> getItemList() { return this.list;}

    //Fine
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOpenable() {
        return openable;
    }

    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    public boolean isPickupable() {
        return pickupable;
    }

    public void setPickupable(boolean pickupable) {
        this.pickupable = pickupable;
    }

    public boolean isPushable() {
        return pushable;
    }

    public void setPushable(boolean pushable) {
        this.pushable = pushable;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isPush() {
        return push;
    }

    public void setPush(boolean push) {
        this.push = push;
    }

    public void setHealer(boolean healer){this.healer = healer;}

    public boolean getHealer(){return this.healer;}

    public void setHeal(int heal){this.heal = heal;}

    public int getHeal(){return this.heal;}

    public void setOpenWith(Item item){this.openWith = item;}

    public Item getOpenWith(){return this.openWith;}
}
