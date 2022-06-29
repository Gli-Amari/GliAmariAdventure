package di.uniba.map.game.type;

public class Player extends Character{

    private Inventory inventory = new Inventory();

    protected Item clothesEquip;

    public Player(int hp, String name, String description) {
        super(hp, name, description);
    }

    public Inventory getInventory(){ return inventory;}

    public Item getClothesEquip() { return clothesEquip;}

    public void setClothesEquip(Item clothesEquip){
        this.clothesEquip = clothesEquip;
    }

}
