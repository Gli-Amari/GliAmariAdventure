package di.uniba.map.game.engine;

import di.uniba.map.game.type.Item;
import di.uniba.map.game.parser.ParserOutput;
import di.uniba.map.game.type.CommandType;
import di.uniba.map.game.type.Npc;
import di.uniba.map.game.type.Room;

public class Utils {
    
    public void move(ParserOutput cmd, GameDescription game) {

        boolean attack = false;
        if(cmd.getCommand().getType() != null){
            if(cmd.getCommand().getType() == CommandType.NORD){
                checkRoom(game, game.getCurrentRoom().getNorth());
            } else if(cmd.getCommand().getType() == CommandType.SOUTH){
                checkRoom(game, game.getCurrentRoom().getSouth());
            }else if(cmd.getCommand().getType() == CommandType.EAST){
                checkRoom(game, game.getCurrentRoom().getEast());
            }else if(cmd.getCommand().getType() == CommandType.WEST) {
                checkRoom(game, game.getCurrentRoom().getWest());
            }else if(cmd.getCommand().getType() == CommandType.INVENTORY){
                if(game.getInventory().getList().size() > 0){
                    for (Item o : game.getInventory().getList()) {
                        System.out.println("\nIl tuo Inventario:");
                        System.out.println("_> " + o.getName() + ": " + o.getDescription());
                    }
                }else{
                    System.out.println("Non ci sono oggetti nel tuo inventario!");
                }
            }
            else if(cmd.getCommand().getType() == CommandType.PICK_UP){
                if(cmd.getItem() != null && game.getCurrentRoom().getItems().contains(cmd.getItem())){
                    if(cmd.getItem().getIsContainer() && cmd.getContainerItem() != null){
                        if(cmd.getItem().isOpen()){
                            game.getInventory().add(cmd.getContainerItem());
                            cmd.getItem().getItemList().remove(cmd.getContainerItem());
                        }else{
                            System.out.println("Non puoi prendere qualcosa se " + cmd.getItem().getName() + " è chiuso!");
                        }
                    }
                    else{
                        if(cmd.getItem().isPickupable()){
                            game.getInventory().add(cmd.getItem());
                            game.getCurrentRoom().getItems().remove(cmd.getItem());
                        }else{
                            System.out.println("Ehi non puoi mica raccogliere " + cmd.getItem().getName());
                        }
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
                    System.out.println(cmd.getItem().getName() + " è stato lasciato!");
                }else{
                    System.out.println("L'oggetto non è in inventario!");
                }

            }
            else if(cmd.getCommand().getType() == CommandType.OPEN){
                if(cmd.getItem() != null && game.getCurrentRoom().getItems().contains(cmd.getItem())){
                    if(cmd.getItem().isOpenable()){
                        System.out.println("Guardando dentro..");
                        if(cmd.getItem().getItemList().size() > 0){
                            for (Item o : cmd.getItem().getItemList()) {
                                System.out.println(o.getName() + ": " + o.getDescription());
                            }
                            cmd.getItem().setOpen(true);
                        }else{
                            System.out.println("E' vuoto!");
                        }
                    }else if(cmd.getItem().getIsContainer() && cmd.getContainerItem() != null){
                        if(game.getPlayer().getInventory().getList().contains(cmd.getContainerItem())){
                            if(cmd.getItem().getOpenWith() == cmd.getContainerItem()){
                                cmd.getItem().setOpenable(true);
                                System.out.println(cmd.getItem().getName() + " è stato aperto!");
                            }else{
                                System.out.println("Non si può aprire " + cmd.getItem().getName() + " con " + cmd.getContainerItem().getName());
                            }
                        }else{
                            System.out.println(cmd.getContainerItem().getName() + " non è in inventario!");
                        }
                    }
                    else{
                        System.out.println("Non riesco ad aprire " + cmd.getItem().getName());
                    }
                    attack = true;
                }else{
                    System.out.println("L'oggetto che cerchi non c'è!");
                }
            }
            else if(cmd.getCommand().getType() == CommandType.LOOK_AT){
                System.out.println(game.getCurrentRoom().getLook());
            }
            else if(cmd.getCommand().getType() == CommandType.TALK){
                if(cmd.getNpc() != null && game.getCurrentRoom().getNpcs().contains(cmd.getNpc())){
                    if(cmd.getNpc().getSpeakable()){
                        cmd.getNpc().talking();
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
                if(game.getCurrentRoom().getItems().size() != 0 || game.getCurrentRoom().getNpcs().size() != 0){
                    System.out.println("Trovato qualcosa!");
                    for(int i = 0; i<game.getCurrentRoom().getItems().size(); i++){
                        System.out.print(game.getCurrentRoom().getItems().get(i).getName() + ", ");
                    }
                    for(int i = 0; i<game.getCurrentRoom().getNpcs().size(); i++){
                        if(i == 0){
                            System.out.println("\nC'è qualcuno..");
                        }
                        System.out.print(game.getCurrentRoom().getNpcs().get(i).getName() + ", ");
                    }
                    System.out.println("tutto qui!");
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
                        game.getPlayer().setClothesEquip(cmd.getItem());
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
                printPlayerStats(game);
            }
            else if(cmd.getCommand().getType() == CommandType.ATTACK){
                if(cmd.getNpc() != null && game.getCurrentRoom().getNpcs().contains(cmd.getNpc())){
                    if(game.getPlayer().getWeaponEquip() != null && cmd.getNpc().getGod() == false){
                        cmd.getNpc().setHp((int) Math.round(cmd.getNpc().getHp() - (game.getPlayer().getWeaponEquip().getPower() - (game.getPlayer().getWeaponEquip().getPower() * (cmd.getNpc().getArmor()/200.000)))));
                        cmd.getNpc().setAttacking(true);
                        cmd.getNpc().setSpeakable(false);
                        System.out.println(cmd.getNpc().getName() + " hp_> " + cmd.getNpc().getHp());
                    }else if(cmd.getNpc().getGod() == true){
                        System.out.println(cmd.getNpc().getName() + ": Non perdere tempo con me. Sono invincibile.");
                    }
                    else{
                        System.out.println("Non conviene attaccare qualcuno senza armi..");
                    }
                    attack = true;
                }else{
                    System.out.println("Non si può attaccare qualcuno che non c'è..");
                }
            }
            if(attack){
                for(int i = 0; i<game.getCurrentRoom().getNpcs().size(); i++){
                    if(game.getCurrentRoom().getNpcs().get(i).getAttacking()){
                        npcResponse(game.getCurrentRoom().getNpcs().get(i), game);
                        printPlayerStats(game);
                    }
                }
            }
        }else{
            System.out.println("Ehm... non ho capito il comando");
        }
    }

    private void npcResponse(Npc cmd, GameDescription game) {
        if(cmd.getHp() <= 0){
            System.out.println(cmd.getName() + ": Ouch..");
            if(cmd.getWeaponEquip() != null){
                game.getCurrentRoom().getItems().add(cmd.getWeaponEquip());
            }
            game.getCurrentRoom().getNpcs().remove(cmd);
        }else{
            if(cmd.getEnemy()){
                System.out.println(cmd.getName() + ": E no eh");
                game.getPlayer().setHp((int) Math.round(game.getPlayer().getHp() - (cmd.getWeaponEquip().getPower() - (cmd.getWeaponEquip().getPower() * (game.getPlayer().getArmor()/200.000)))));
            }
        }
    }

    public void printRoom(GameDescription game){
        System.out.println("\n" + game.getCurrentRoom().getName());
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(game.getCurrentRoom().getDescription());
    }

    public void printPlayerStats(GameDescription game){
        if(game.getPlayer().getWeaponEquip() != null){
            System.out.println("\nHp_> " + game.getPlayer().getHp() + " armatura_> " + game.getPlayer().getArmor() + " Equip_> " + game.getPlayer().getWeaponEquip().getName());
        }else{
            System.out.println("\nHp_> " + game.getPlayer().getHp() + " armatura_> " + game.getPlayer().getArmor());
        }
    }

    private void checkRoom(GameDescription game, Room room){
        if(room != null){
            if(!room.getLock()){
                game.setCurrentRoom(room);
                printRoom(game);
                if(room.getTriggerReference() != null && room.getExplored() == false){
                    room.setExplored(true);
                    room.getTriggerReference().trigger();
                }
            }else{
                System.out.println("E' bloccato, non si può passare!");
            }
        }else{
            System.out.println("Ehi non c'è niente qui."); 
        }
    }

}
