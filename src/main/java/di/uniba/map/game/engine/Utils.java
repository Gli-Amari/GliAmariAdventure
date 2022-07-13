package di.uniba.map.game.engine;

import di.uniba.map.game.type.Item;
import di.uniba.map.game.type.Npc;
import di.uniba.map.game.databases.Db;
import di.uniba.map.game.parser.ParserOutput;
import di.uniba.map.game.type.CommandType;
import di.uniba.map.game.type.Room;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Utils {

    public void move(Db db, ParserOutput cmd, GameDescription game) {

        boolean attack = false;
        if(cmd.getCommand().getType() != null){
            if(cmd.getCommand().getType() == CommandType.NORD){
                checkRoom(game, game.getCurrentRoom().getNorth(), db);
            } else if(cmd.getCommand().getType() == CommandType.SOUTH){
                checkRoom(game, game.getCurrentRoom().getSouth(), db);
            }else if(cmd.getCommand().getType() == CommandType.EAST){
                checkRoom(game, game.getCurrentRoom().getEast(), db);
            }else if(cmd.getCommand().getType() == CommandType.WEST) {
                checkRoom(game, game.getCurrentRoom().getWest(), db);
            }else if(cmd.getCommand().getType() == CommandType.INVENTORY){
                if(game.getInventory().getList().size() > 0){
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("+                                                                +");
                    System.out.println("+                            Inventario                          +");
                    System.out.println("+                                                                +");
                    Iterator<Item> it = game.getInventory().getList().iterator();
                    while (it.hasNext()) {
                        try {
                            Item oggetto = it.next();
                            System.out.println("+ " + oggetto.getName(db) + " : " + oggetto.getDescription(db) + " +");
                        } catch (NoSuchElementException ex) {
                            System.out.println("errore");
                        }
                    }
                    System.out.println("+                                                                +");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                }else{
                    System.out.println("Non ci sono oggetti nel tuo inventario!");
                }
            }
            else if(cmd.getCommand().getType() == CommandType.PICK_UP){
                if(cmd.getItem() != null && game.getCurrentRoom().getItems().contains(cmd.getItem())){
                    if(cmd.getItem().isPickupable()){
                        game.getInventory().add(cmd.getItem());
                        System.out.println("Hai raccolto " + cmd.getItem().getName(db) + "!");
                        game.getCurrentRoom().getItems().remove(cmd.getItem());
                    }else{
                        System.out.println("Ehi non puoi mica raccogliere " + cmd.getItem().getName(db));
                    }
                    attack = true;
                }
                else{
                    System.out.println("L'oggetto che cerchi non c'è!");
                }
            }
            else if(cmd.getCommand().getType() == CommandType.THROW){
                if(cmd.getItem() != null && game.getInventory().getList().contains(cmd.getItem())){
                    game.getInventory().getList().remove(cmd.getItem());
                    game.getCurrentRoom().getItems().add(cmd.getItem());
                    System.out.println(cmd.getItem().getName(db) + " è stato lasciato!");
                }else{
                    System.out.println("L'oggetto non è in inventario!");
                }
            }else if(cmd.getCommand().getType() == CommandType.LOOK_AT){
                System.out.println(game.getCurrentRoom().getLook(db));
            }
            else if(cmd.getCommand().getType() == CommandType.TALK){
                if(cmd.getNpc() != null && game.getCurrentRoom().getNpcs().contains(cmd.getNpc())){
                    if(cmd.getNpc().getSpeakable()){
                        try {
                            cmd.getNpc().talking(game.getCurrentRoom().getId());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println(cmd.getNpc().getName() + ": Non mi disturbare.");
                    }
                    attack = true;
                }else{
                    System.out.println("Quel tizio non c'è!");
                }
            }
            else if(cmd.getCommand().getType() == CommandType.SEARCH){
                System.out.print("Cerchiamo un po'...");
                if(game.getCurrentRoom().getItems().size() != 0 && game.getCurrentRoom().getNpcs().size() != 0){
                    System.out.println("Trovato qualcosa!");
                    for(int i = 0; i<game.getCurrentRoom().getItems().size(); i++){
                        System.out.print(game.getCurrentRoom().getItems().get(i).getName(db) + ", ");
                    }
                    for(int i = 0; i<game.getCurrentRoom().getNpcs().size(); i++){
                        System.out.println("\nC'è qualcuno.." + game.getCurrentRoom().getNpcs().get(i).getName() + ",");
                        System.out.println("tutto qui!");
                    }
                  
                }else{
                    System.out.println("Non ho trovato nulla di interessante!");
                }
            }
            else if(cmd.getCommand().getType() == CommandType.EQUIP){
                if(cmd.getItem() != null && game.getPlayer().getInventory().getList().contains(cmd.getItem())){
                    if(cmd.getItem().isWeapon()){
                        game.getPlayer().setWeaponEquip(cmd.getItem());
                        attack = true;
                    }else{
                        System.out.println("Non si può equipaggiare questo oggetto!");
                    }
                }
                else{
                    System.out.println("Questo oggetto non è in inventario!");
                }

            }
            else if(cmd.getCommand().getType() == CommandType.EAT){
                if(cmd.getItem() != null && game.getPlayer().getInventory().getList().contains(cmd.getItem())){
                    if(cmd.getItem().getHealer()){
                        if(game.getPlayer().getHp() < 100){
                            game.getPlayer().setHp(game.getPlayer().getHp() + cmd.getItem().getHeal());
                            if(game.getPlayer().getHp() > 100){
                                game.getPlayer().setHp(100);
                            }
                            game.getPlayer().getInventory().getList().remove(cmd.getItem());
                        }else{
                            System.out.println("la vita è già al massimo!");
                        }
                        attack = true;
                    }else{
                        System.out.println("Non si può mangiare questo!");
                    }
                }
                else{
                    System.out.println("Questo oggetto non è in inventario!");
                }

            }
            else if(cmd.getCommand().getType() == CommandType.USE){
                if(cmd.getItem() != null && game.getPlayer().getInventory().getList().contains(cmd.getItem())){
                    if(cmd.getItem().isArmor()){
                        game.getPlayer().setArmor(cmd.getItem().getProtection());
                        attack = true;
                    }else{
                        System.out.println("Non si può indossare questo!");
                    }
                }
                else{
                    System.out.println("Questo oggetto non è in inventario!");
                }

            }
            else if(cmd.getCommand().getType() == CommandType.STATS){
                printPlayerStats(game, db);
            }
            else if(cmd.getCommand().getType() == CommandType.ATTACK){
                if(cmd.getNpc() != null && game.getCurrentRoom().getNpcs().contains(cmd.getNpc())){
                    if(game.getPlayer().getWeaponEquip() != null && game.getPlayer().getWeaponEquip().getPower() > 0){
                            //attacco del player..
                        
                            if(game.getPlayer().getWeaponEquip().getName(db).equals("pistola") || game.getPlayer().getWeaponEquip().getName(db).equals("granata")){       //caso in cui attacco con un arma a distanza...

                                //decremento i colpi...
                                game.getPlayer().getWeaponEquip().setBullet(game.getPlayer().getWeaponEquip().getBullet() - 1);

                                cmd.getNpc().setHp(cmd.getNpc().getHp() - game.getPlayer().getWeaponEquip().getPower());
                                System.out.println("Hai attaccato " + cmd.getNpc().getName() + " con " + game.getPlayer().getWeaponEquip().getName(db));
                                cmd.getNpc().setAttacking(true);
                                cmd.getNpc().setSpeakable(false);                    
                            }else{                                       //caso in cui attacco senza armi a distanza...
                                cmd.getNpc().setHp(cmd.getNpc().getHp() - game.getPlayer().getWeaponEquip().getPower());
                                System.out.println("Hai attaccato " + cmd.getNpc().getName() + " con " + game.getPlayer().getWeaponEquip().getName(db));
                                cmd.getNpc().setAttacking(true);
                                cmd.getNpc().setSpeakable(false);
                            }

                        System.out.println(cmd.getNpc().getName() + " hp: " + cmd.getNpc().getHp());
                    }else{
                        System.out.println("Non conviene attaccare qualcuno senza armi..");
                    }
                    attack = true;
                }else{
                    System.out.println("A chi attacchi?? vè acchiann nald trmun!");
                }
            }
            if(attack == true){
                for(int i = 0; i<game.getCurrentRoom().getNpcs().size(); i++){
                    if(game.getCurrentRoom().getNpcs().get(i).getAttacking()){
                        monsterResponse(game.getCurrentRoom().getNpcs().get(i), game);
                        printPlayerStats(game, db);
                    }
                }
            }
        }else{
            System.out.println("Ehm... non ho capito il comando");
        }
    }

    private void monsterResponse(Npc cmd, GameDescription game) {
        //attacco di risposta del mostro
        if(cmd.getHp() <= 0){
            System.out.println(cmd.getName() + ": ARRRRRRRRRGHHHH!!!"); // randomizzare le frasi in base al mostro
            System.out.println("\nHai ucciso " + cmd.getName() + "!");
            if(cmd.getWeaponEquip() != null){
                game.getCurrentRoom().getItems().add(cmd.getWeaponEquip());
            }
            game.getCurrentRoom().getNpcs().remove(cmd);
        }else{
            if(cmd.getEnemy()){
                System.out.println(cmd.getName() + ": WROAAAAAARHHH!!!"); // randomizzare le frasi
                int damage = game.getPlayer().getHp() - cmd.getWeaponEquip().getPower();
                game.getPlayer().setHp(damage);
                
            }
        }
    }

    public void printRoom(GameDescription game, Db db){
        System.out.println("\n" + game.getCurrentRoom().getName(db));
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(game.getCurrentRoom().getDescription(db));
    }

    public void printPlayerStats(GameDescription game, Db db){
        if(game.getPlayer().getWeaponEquip() != null && !game.getPlayer().getWeaponEquip().getName(db).equals("pistola") && !game.getPlayer().getWeaponEquip().getName(db).equals("granate")){
            System.out.println("\nHp_> " + game.getPlayer().getHp() + " armatura_> " + game.getPlayer().getArmor() + " Equip_> " + game.getPlayer().getWeaponEquip().getName(db));
        }else if(game.getPlayer().getWeaponEquip() != null && game.getPlayer().getWeaponEquip().getName(db).equals("pistola")){
            System.out.println("\nHp_> " + game.getPlayer().getHp() + " armatura_> " + game.getPlayer().getArmor() + " Equip_> " + game.getPlayer().getWeaponEquip().getName(db) + " #(colpi)_>" + game.getPlayer().getWeaponEquip().getBullet());
        }else if(game.getPlayer().getWeaponEquip() != null && game.getPlayer().getWeaponEquip().getName(db).equals("granate")){
            System.out.println("\nHp_> " + game.getPlayer().getHp() + " armatura_> " + game.getPlayer().getArmor() + " Equip_> " + game.getPlayer().getWeaponEquip().getName(db) + " #(granate)_>" + game.getPlayer().getWeaponEquip().getBullet());
        }else{
            System.out.println("\nHp_> " + game.getPlayer().getHp() + " armatura_> " + game.getPlayer().getArmor());
        }
    }

    private void checkRoom(GameDescription game, Room room, Db db){
        if(room != null && room.getId() != 1){
            game.setCurrentRoom(room);
            printRoom(game, db);
            if(room.getExplored() == false){
                room.setExplored(true);
            }
        }else if(room != null && room.getId() == 1){
            System.out.println("E' passato così tanto tempo da quella maledetta cartolina... \nQuanto mi sarebbe piaciuto essere a casa mia a mangiare un po'\ndi maicol sushi con miei compagni!\nComunque non è possibile andare da quella parte!");
        }else{
            System.out.println("Non si va da nessuna parte li u scè!");
        }
    }

}
