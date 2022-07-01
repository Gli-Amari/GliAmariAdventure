package di.uniba.map.game.type;

import java.util.Scanner;
/**
 * @author Francesco Pio Scoglietti
 * All'interno di questa classe vengono definite le interazioni con gli altri NPC
 */
public class Npc extends Character{

    private boolean isEnemy = false;
    private boolean isGod = false;
    private boolean isAttacking = false;
    private boolean isSpeakable = false;
    private Talk talk;

    public Npc(int hp, String name, String description) 
    {
        super(hp, name, description);
    }

    public void talking(){
        if(talk != null) {
            try (Scanner scanner = new Scanner(System.in)) {
                Talk temp = talk;
                int answer;
                boolean error = true;

                while (error) {
                    System.out.println("\n" + name + ": " + temp.getSpeech());
                    for (int j = 0; j < temp.getAns().size(); j++) {
                        System.out.println(j + 1 + ": " + temp.getAns().get(j).getAnswer());
                    }
                    try {
                        System.out.println("Cosa vuoi dire?");
                        answer = Integer.parseInt(scanner.nextLine());
                        System.out.println("Tu: " + temp.getAns().get(answer - 1).getAnswer());
                        if (temp.getAns().get(answer - 1).getTriggerReference() != null) {
                            temp.getAns().get(answer - 1).getTriggerReference().trigger();
                        }
                        if (temp.getAns().get(answer - 1).getWarp() == null) {
                            System.out.println(name + ": " + "Allora è tutto.");
                            error = false;
                        } else {
                            temp = temp.getAns().get(answer - 1).getWarp();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(name + ": " + "Dammi una risposta sensata.");
                    }
                }
            }
        }
    }

    
    /** 
     * @return boolean
     */
    public boolean getAttacking()
    {
        return this.isAttacking;
    };

    
    /** 
     * @param attacking
     */
    public void setAttacking(boolean attacking)
    {
        this.isAttacking = attacking;
    }

    
    /** 
     * @param speakable
     */
    public void setSpeakable(boolean speakable) 
    {
        isSpeakable = speakable;
    }

    
    /** 
     * @return boolean
     */
    public boolean getSpeakable()
    {
        return isSpeakable;
    }

    
    /** 
     * @param enemy
     */
    public void setEnemy(boolean enemy) 
    {
        isEnemy = enemy;
    }

    
    /** 
     * @return boolean
     */
    public boolean getEnemy()
    {
        return this.isEnemy;
    }

    
    /** 
     * @param talk
     */
    public void setTalk(Talk talk)
    {
        this.talk = talk;
    }

    
    /** 
     * @return Talk
     */
    public Talk getTalk() 
    {
        return this.talk;
    }

    
    /** 
     * @return boolean
     */
    public boolean getGod()
    { 
        return isGod;
    }

    
    /** 
     * @param god
     */
    public void setGod(boolean god)
    { 
        isGod = god;
    }
}
