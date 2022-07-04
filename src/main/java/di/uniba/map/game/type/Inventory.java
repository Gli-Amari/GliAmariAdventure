package di.uniba.map.game.type;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Giulio Russo
 * Viene definito l'inventario del personaggio principale.
 */

public class Inventory {

    private List<Item> list = new ArrayList<>();
    
    /** 
     * @return List<Item>
     */
    
    public List<Item> getList() {
        return list;
    }

    /** 
     * @param list
     */

    public void setList(List<Item> list) {
        this.list = list;
    }

    /** 
     * @param o
     */

    public void add(Item o) {
        list.add(o);
    }

    /** 
     * @param o
     */

    public void remove(Item o) {
        list.remove(o);
    }
}
