package di.uniba.map.game.type;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Npc extends Character{

    private boolean isEnemy = false;
    private boolean isGod = false;
    private boolean isAttacking = false;
    private boolean isSpeakable = false;
    private static final String pathStanza3 = ".\\resource\\dialog\\stanza3Pier.txt";

    public Npc(int hp, String name, String description) {
        super(hp, name, description);
    }

    public void talking(int idStanza){
        
        if(idStanza == 3){
            File fileStanza3 = new File(pathStanza3);
            readDialog(fileStanza3);
        }

    }

    private void readDialog(File file){
        try{
            Scanner leggi = new Scanner(file);
            while (leggi.hasNextLine()) {
                String data = leggi.nextLine();
                System.out.println(data);
            }
            leggi.close();
        } catch(IOException ex){
            System.out.println("Si è verificato un errore");
            ex.printStackTrace();
        }
    }

    public boolean getAttacking(){
        return this.isAttacking;
    }

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

    public boolean getEnemy(){
        return this.isEnemy;
    }

    public boolean getGod(){ 
        return isGod;
    }

    public void setGod(boolean god){ 
        isGod = god;
    }
}
