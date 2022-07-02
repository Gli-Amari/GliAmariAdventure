package di.uniba.map.game.type;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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

    public Npc(int hp, String name, String description) {
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
        }
    }

    private void readDialog(File file){
        /*try{
            Scanner leggi = new Scanner(file);
            while (leggi.hasNextLine()) {
                String data = leggi.nextLine();
                System.out.println(data);
            }
            leggi.close();
        } catch(IOException ex){
            System.out.println("Si è verificato un errore");
            ex.printStackTrace();
        }*/
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
