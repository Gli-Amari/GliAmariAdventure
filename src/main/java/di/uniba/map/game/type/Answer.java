package di.uniba.map.game.type;

/**
 * @author Giulio Russo
 * All'interno di questa classe vengono gestite le risposte date all'interno dei vari dialoghi.
 */

public class Answer {
    private String answer = new String();

    private Talk warp = null;

    private Triggers.triggerInterface triggerReference = null;
    
     /** 
     * @return String
     */

    public String getAnswer()
    {
        return answer;
    }

    /** 
     * @param answer
     */
    
    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    /** 
     * @return Talk
     */
    
    public Talk getWarp()
    {
        return warp;
    }

    
    /** 
     * @param warp
     */ 

    public void setWarp(Talk warp)
    {
        this.warp = warp;
    }

    /** 
     * @param T
     */
    
    
    public void setTriggerReference(Triggers.triggerInterface T)
    {
        this.triggerReference = T;
    }

    
    /** 
     * @return triggerInterface
     */
    
    public Triggers.triggerInterface getTriggerReference(){
        return this.triggerReference;
    }
}
