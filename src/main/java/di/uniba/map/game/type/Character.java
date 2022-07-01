package di.uniba.map.game.type;

/**
 * @author Giulio Russo
 * Definisce i personaggi dell'avventura.
 */

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


    /** 
     * @return String
     */
    
    public String getName() {
        return name;
    }

    /** 
     * @param name
     */
    
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return int
     */
    
    public int getHp()
    {
        return this.hp;
    }

    
    /** 
     * @param hp
     */
    
    public void setHp(int hp){
        this.hp = hp;
    }

    
     /** 
     * @return int
     */
    
    public int getArmor()
    { 
        return this.armor;
    }

    
    /** 
     * @param armor
     */
    
    public void setArmor(int armor){
        this.armor = armor;
    }

    /** 
     * @return Item
     */
    
    public Item getWeaponEquip() 
    {
        return weaponEquip;
    }

     /** 
     * @param weapon
     */
    
    public void setWeaponEquip(Item weapon){
        this.weaponEquip = weapon;
    }

    /** 
     * @return String
     */
    
    public String getDescription() 
    {
        return description;
    }

      
    /** 
     * @param description
     */
    
    
    public void setDescription(String description)
    {
        this.description = description;
    }
}
