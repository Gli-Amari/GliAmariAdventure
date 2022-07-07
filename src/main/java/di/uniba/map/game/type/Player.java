package di.uniba.map.game.type;

/**
 * @author Francesco Pio Scoglietti
 * All'interno di questa classe vengono definite le caratteristiche del protagonista
 */
public class Player extends Character{

    private Inventory inventory = new Inventory();
    protected Item clothesEquip;

    public Player(int hp, String name) 
    {
        super(hp, name);
    }

    
    /** 
     * @return Inventory
     */
    public Inventory getInventory()
    { 
        return inventory;
    }

    
    /** 
     * @return Item
     */
    public Item getClothesEquip() 
    {
        return clothesEquip;
    }

    
    /** 
     * @param clothesEquip
     */
    public void setClothesEquip(Item clothesEquip)
    {
        this.clothesEquip = clothesEquip;
    }

}
