package di.uniba.map.game.type;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Francesco Pio Scoglietti
 * All'interno di questa classe vengono definite le interazioni con gli altri NPC
 */
public class Npc extends Character{

    private boolean isEnemy = false;
    private boolean isAttacking = false;
    private boolean isSpeakable = false;
    String pathStanza1 = "dialog//amari.txt";
    String pathStanza2 = "dialog//ufficiale.txt";
    String pathStanza5 = "dialog//galatone.txt";
    String pathStanza7 = "dialog//Soldato.txt";


    public Npc(int hp, String name, String description){
        super(hp, name, description);
    }

    public String getName(){ 
       return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void talking(int idStanza) throws IOException{

        File fileStanza;

        switch(idStanza){
            case 1:
                fileStanza = new File(pathStanza1);
                readDialog(fileStanza);
            break;
            case 2:
                fileStanza = new File(pathStanza2);
                readDialog(fileStanza);
            break;
            case 5:
                fileStanza = new File(pathStanza5);
                readDialog(fileStanza);
            break;
            case 7:
                fileStanza = new File(pathStanza7);
                readDialog(fileStanza);
            break;
        }
    }

    private void readDialog(File file) throws IOException{
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String singleLine;
            do{
                singleLine = buffer.readLine();
                if (singleLine != null){
                    System.out.println(singleLine);
                }
            }while (singleLine != null);
            buffer.close();
        }catch (FileNotFoundException e){
            System.err.println("il file non esiste");
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
}
