package di.uniba.map.game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Classe per la gestione concorrente della musica in gioco.
 * Estende la classe Thread.
 * 
 * @author Piersilvio Spicoli
 * @author Francesco Pio Scoglietti
 * @author Giulio Russo
 */
public class ThreadMusic implements Runnable{
    
    private static final String musicpath = "./resource/StrangerThings_Season1_Opening-IntroHD.wav";

    /**
     * metodo per la gestione concorrente della musica in gioco.
     */
    public void run(){
        
        try{
            File musicPath = new File(musicpath);
            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }else
            {
                System.out.print("Errore nella lettura del file");
            }
        }catch(Exception e){
            System.out.println("Errore nell'avvio della musica");
        }

    }

}
