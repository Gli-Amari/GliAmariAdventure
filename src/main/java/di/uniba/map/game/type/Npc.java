package di.uniba.map.game.type;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import di.uniba.map.game.databases.Db;

/**
 * @author Francesco Pio Scoglietti
 * All'interno di questa classe vengono definite le interazioni con gli altri NPC
 */
public class Npc extends Character{

    /**
     * query
     */
    public static final String SELECTNAME = "SELECT name FROM npc WHERE id = ?";
    public static final String SELECTDESCRIPTION = "SELECT desc FROM npc WHERE id = ?";

    private boolean isEnemy = false;
    private boolean isAttacking = false;
    private boolean isSpeakable = false;
    String pathStanza1 = "dialog//stanza3Pier.txt";
    String pathStanza2 = "dialog//ufficiale.txt";
    String pathStanza5 = "dialog//galatone.txt";
    String pathStanza7 = "dialog//Soldato.txt";


    public Npc(int hp, String name, String description){
        super(hp, name, description);
    }

    public String getName(Db db){ 
       return this.name;
    }

    public String getDescription(Db db){
        return this.description;
    }

    public void talking(int idStanza){

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

    private void readDialog(File file){
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
        }catch (FileNotFoundException e ){
            System.err.println("il file non esiste");
        }catch (IOException e ){
            System.err.println("ERRORE  DI I/0");
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
