package di.uniba.map.game.parser;

import di.uniba.map.game.engine.GameDescription;
import di.uniba.map.game.parser.ParserOutput;
import di.uniba.map.game.type.Command;
import di.uniba.map.game.type.Item;
import di.uniba.map.game.type.Npc;

public class Parser {

    public ParserOutput parseCmd(String command, GameDescription game){

        ParserOutput cmd;
        Command token = new Command(null, null);
        Item item = null;
        Item containerItem = null;
        Npc npc = null;
        String[] key = command.toLowerCase().split(" ");

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
        for(int i = 0; i<game.getItemList().size(); i++){
            try{
                if(key[1].equals(game.getItemList().get(i).getName())){
                    item = game.getItemList().get(i);
                    if(item.getIsContainer()){
                        for(int j = 0; j<game.getItemList().size(); j++) {
                            try {
                                if(key[2].equals(game.getItemList().get(j).getName())){
                                    containerItem = game.getItemList().get(j);
                                    break;
                                }
                            } catch (Exception ArrayIndexOutOfBoundsException) {
                                break;
                            }
                        }
                    }
                    break;
                }
            }catch (Exception e){
                break;
            }
        }
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
            if(containerItem != null){
                cmd = new ParserOutput(token, item, containerItem);
            }else{
                cmd = new ParserOutput(token, item);
            }
        }

        return cmd;

    }
    
}
