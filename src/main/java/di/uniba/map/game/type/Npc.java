package di.uniba.map.game.type;

import java.util.Scanner;

public class Npc extends Character{

    private boolean isEnemy = false;

    private boolean isGod = false;

    private boolean isAttacking = false;

    private boolean isSpeakable = false;

    private Talk talk;

    public Npc(int hp, String name, String description) {
        super(hp, name, description);
    }

    public void talking(){
        if(talk != null) {
            try (Scanner scanner = new Scanner(System.in)) {
                Talk temp = talk;
                int answer;
                boolean error = true;

                while (error) {
                    System.out.println(name + ": " + temp.getSpeech());
                    for (int j = 0; j < temp.getAns().size(); j++) {
                        System.out.println(j + 1 + ": " + temp.getAns().get(j).getAnswer());
                    }
                    try {
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

    public boolean getAttacking(){return this.isAttacking;};

    public void setAttacking(boolean attacking){
        this.isAttacking = attacking;
    }

    public void setSpeakable(boolean speakable) {
        isSpeakable = speakable;
    }

    public boolean getSpeakable(){
        return isSpeakable;
    }

    public void setEnemy(boolean enemy) {
        isEnemy = enemy;
    }

    public boolean getEnemy(){return this.isEnemy;}

    public void setTalk(Talk talk){
        this.talk = talk;
    }

    public Talk getTalk() {return this.talk;}

    public boolean getGod(){ return isGod;}

    public void setGod(boolean god){ isGod = god;}
}
