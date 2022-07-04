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
    private boolean isGod = false;
    private boolean isAttacking = false;
    private boolean isSpeakable = false;
    private static final String pathStanza3 = ".\\resource\\dialog\\stanza3Pier.txt";
    private static final String pathStanza4 = ".\\resource\\dialog\\stanza4Frank.txt";
    private static final String pathStanza5 = ".\\resource\\dialog\\stanza5Giulio.txt";
    private static final String pathStanza10 = ".\\resource\\dialog\\stanza10Lanubile.txt";
    private static final String pathStanza11 = ".\\resource\\dialog\\stanza11Pippo.txt";
    private static final String pathStanza12 = ".\\resource\\dialog\\stanza12Ufficiale.txt";
    private static final String pathStanza15 = ".\\resource\\dialog\\stanza15Galatone.txt";
    private static final String pathStanza19 = ".\\resource\\dialog\\stanza12Soldato.txt";

    public Npc(int hp, String name, String description) 
    {
        super(hp, name, description);
    }

    public void talking(int idStanza){

        File fileStanza;

        switch(idStanza){
            case 3:
                fileStanza = new File(pathStanza3);
                readDialog(fileStanza);
            break;
            case 4:
                fileStanza = new File(pathStanza4);
                readDialog(fileStanza);
            break;
            case 5:
                fileStanza = new File(pathStanza5);
                readDialog(fileStanza);
            break;
            case 10:
                fileStanza = new File(pathStanza10);
                readDialog(fileStanza);
            break;
            case 11:
                fileStanza = new File(pathStanza11);
                readDialog(fileStanza);
            break;
            case 12:
                fileStanza = new File(pathStanza12);
                readDialog(fileStanza);
            break;
            case 15:
                fileStanza = new File(pathStanza15);
                readDialog(fileStanza);
            break;
            case 19:
                fileStanza = new File(pathStanza19);
                readDialog(fileStanza);
            break;
        }
    }

    private void readDialog(File file){
        try{
            BufferedReader buffer= new BufferedReader(new FileReader(file));
            String singleLine;
            do{
                singleLine=buffer.readLine();
                if (singleLine!=null){
                    System.out.println(singleLine);
                }
            }while (singleLine!= null);
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
