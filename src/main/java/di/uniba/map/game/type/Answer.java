package di.uniba.map.game.type;

public class Answer {
    private String answer = new String();

    private Talk warp = null;

    private Triggers.triggerInterface triggerReference = null;

    //insert trigger to answer

    public String getAnswer(){return answer;}

    public void setAnswer(String answer){this.answer = answer;}

    public Talk getWarp(){return warp;}

    public void setWarp(Talk warp){this.warp = warp;}

    public void setTriggerReference(Triggers.triggerInterface T){this.triggerReference = T;}

    public Triggers.triggerInterface getTriggerReference(){
        return this.triggerReference;
    }
}
