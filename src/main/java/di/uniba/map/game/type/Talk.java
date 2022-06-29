package di.uniba.map.game.type;

import java.util.ArrayList;
import java.util.List;

public class Talk {

    private String speech = new String();

    private List<Answer> ans = new ArrayList<>();

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String s){
        speech = s;
    }

    public List<Answer> getAns() {return ans;}
}
