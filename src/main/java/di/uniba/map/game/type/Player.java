package di.uniba.map.game.type;

/**
 * @author Francesco Pio Scoglietti
 * All'interno di questa classe vengono definite le caratteristiche del protagonista
 */
public class Player extends Character{

    private Inventory inventory = new Inventory();

    public Player(int hp, String name, String description){
        super(hp, name, description);
    }
    
    
    /** 
     * @return Inventory
     */
    public Inventory getInventory()
    { 
        return inventory;
    }
}
