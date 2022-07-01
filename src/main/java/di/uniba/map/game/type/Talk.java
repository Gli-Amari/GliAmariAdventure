package di.uniba.map.game.type;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Francesco Pio Scoglietti
 * In questa classe vengono definiti i dialoghi possibili con i personaggi interagibili!
 */
public class Talk {

    private String speech = new String();
    private List<Answer> ans = new ArrayList<>();

    
    /** 
     * @return String
     */
    public String getSpeech() 
    {
        return speech;
    }

    
    /** 
     * @param s
     */
    public void setSpeech(String s)
    {
        speech = s;
    }

    
    /** 
     * @return List<Answer>
     */
    public List<Answer> getAns() 
    {
        return ans;
    }
}
