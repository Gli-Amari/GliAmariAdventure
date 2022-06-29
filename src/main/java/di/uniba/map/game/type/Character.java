package di.uniba.map.game.type;

public class Character {
    protected int hp;

    protected int armor = 0;

    protected String name;

    protected String description;

    protected Item weaponEquip;

    public Character(int hp, String name, String description) {
        this.hp = hp;
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp(){ return this.hp;}

    public void setHp(int hp){
        this.hp = hp;
    }

    public int getArmor(){ return this.armor;}

    public void setArmor(int armor){
        this.armor = armor;
    }

    public Item getWeaponEquip() { return weaponEquip;}

    public void setWeaponEquip(Item weapon){
        this.weaponEquip = weapon;
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}
}
