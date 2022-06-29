package di.uniba.map.game.type;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> list = new ArrayList<>();

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public void add(Item o) {
        list.add(o);
    }

    public void remove(Item o) {
        list.remove(o);
    }
}
