package di.uniba.map.game.parser;

import di.uniba.map.game.databases.Db;
import di.uniba.map.game.engine.GameDescription;
import di.uniba.map.game.type.Command;
import di.uniba.map.game.type.Item;
import di.uniba.map.game.type.Npc;

public class Parser {
    
    /** 
     * è un metodo che ci consente di poter effettuare il controllo sul comando
     * sull'oggetto e sulla descrizione del gioco.
     * La frase che accetta è del tipo <comando><oggetto>
     * 
     * @param command
     * @param game
     * @param db
     * @return ParserOutput
     */
    public ParserOutput parseCmd(String command, GameDescription game, Db db){

        ParserOutput cmd;
        Command token = new Command(null, null);
        Item item = null;
        Npc npc = null;
        String[] key = command.toLowerCase().split(" ");

        /*
        * il ciclo for è utilizzato per controllare se il comando è valido o no.
        * Il comando si trova nella prima posizione della frase e se tale parola corrisponde
        * al suo comando di default o ad uno dei suoi alias viene creato un oggetto di tipo command
        */
        for(int i = 0; i<game.getCommands().size(); i++){
            try{
                if(key[0].equals(game.getCommands().get(i).getName()) ||  game.getCommands().get(i).getAlias().contains(key[0])){
                    token = new Command(game.getCommands().get(i).getType(),game.getCommands().get(i).getName());
                    break;
                }
            }catch (Exception NullPointerException){
                break;
            }
        }
        /*
         * il ciclo for è utilizzato per controllare se nella frase è presente un oggetto.
         */
        for(int i = 0; i<game.getItemList().size(); i++){
            try{
                if(key[1].equals(game.getItemList().get(i).getName(db))){
                    item = game.getItemList().get(i);
                    break;
                }
            }catch (Exception e){
                break;
            }
        }
        /*
         * il ciclo for ci permette di verificare se nella frase immessa dal giocatore è presente un npc.
         * in caso affermativo, viene assegnato un oggetto di tipo npc.
         */
        for(int i = 0; i<game.getNpcList().size(); i++){
            try{
                if(key[1].equals(game.getNpcList().get(i).getName())) {
                    npc = game.getNpcList().get(i);
                    break;
                }
            }catch (Exception e){
                break;
            }
        }

        if(npc != null){
            cmd = new ParserOutput(token, npc);
        }else{
            cmd = new ParserOutput(token, item);
        }

        return cmd;
    }
    
}
