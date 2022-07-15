package di.uniba.map.game.story;

import di.uniba.map.game.type.*;

import java.sql.SQLException;

import di.uniba.map.game.engine.GameDescription;

public class Story extends GameDescription{

    @Override  
    public void init() throws SQLException{

        //Commands
        getPlayer().setName("Lello");
        

        Command nord = new Command(CommandType.NORD, "nord");
        nord.setAlias(new String[]{"n", "N", "Nord", "NORD"});
        getCommands().add(nord);
        
        Command inventory = new Command(CommandType.INVENTORY, "inventario");
        inventory.setAlias(new String[]{"inv", "i", "I"});
        getCommands().add(inventory);

        Command sud = new Command(CommandType.SOUTH, "sud");
        sud.setAlias(new String[]{"s", "S", "Sud", "SUD"});
        getCommands().add(sud);

        Command est = new Command(CommandType.EAST, "est");
        est.setAlias(new String[]{"e", "E", "Est", "EST"});
        getCommands().add(est);

        Command ovest = new Command(CommandType.WEST, "ovest");
        ovest.setAlias(new String[]{"o", "O", "Ovest", "OVEST"});
        getCommands().add(ovest);

        Command end = new Command(CommandType.END, "end");
        end.setAlias(new String[]{"end", "fine", "esci","exit"});
        getCommands().add(end);

        Command look = new Command(CommandType.LOOK_AT, "osserva");
        look.setAlias(new String[]{"guarda", "vedi", "descrivi"});
        getCommands().add(look);

        Command search = new Command(CommandType.SEARCH, "cerca");
        search.setAlias(new String[]{"trova", "controlla"});
        getCommands().add(search);

        Command pickup = new Command(CommandType.PICK_UP, "raccogli");
        pickup.setAlias(new String[]{"prendi", "pick", "prendere"});
        getCommands().add(pickup);

        Command talk = new Command(CommandType.TALK, "parla");
        talk.setAlias(new String[]{"Parla","PARLA"});
        getCommands().add(talk);

        Command equip = new Command(CommandType.EQUIP, "equipaggia");
        equip.setAlias(new String[]{"equip"});
        getCommands().add(equip);

        Command stats = new Command(CommandType.STATS, "statistica");
        stats.setAlias(new String[]{"stat", "stats", "statistiche", "vita", "info", "informazioni"});
        getCommands().add(stats);

        Command attack = new Command(CommandType.ATTACK, "attacca");
        attack.setAlias(new String[]{"attack", "combatti"});
        getCommands().add(attack);

        Command eat = new Command(CommandType.EAT, "mangia");
        eat.setAlias(new String[]{"eat", "bevi", "assumi"});
        getCommands().add(eat);

        Command use = new Command(CommandType.USE, "usa");
        use.setAlias(new String[]{"indossa", "vesti", "use"});
        getCommands().add(use);

        Command throww = new Command(CommandType.THROW, "butta");
        throww.setAlias(new String[]{"getta", "cestina", "elimina", "rimuovi"});
        getCommands().add(throww);

        //Rooms
        Room intro = new Room(1);
        Room ufficio_comandante = new Room(2);
        Room ingresso_trincea = new Room(3);
        Room vicolo_cieco = new Room(4);
        Room campo_add = new Room(5);
        Room ingresso_campo_add = new Room(6);
        Room intermezzo = new Room(7);
        Room intermezzo_est = new Room(8);
        Room fine_trincea = new Room(9);
        Room Amber_clad = new Room(10);

        //aggiunta stanze
        getRooms().add(intro);
        getRooms().add(ufficio_comandante);
        getRooms().add(ingresso_trincea);
        getRooms().add(vicolo_cieco);
        getRooms().add(campo_add);
        getRooms().add(ingresso_campo_add);
        getRooms().add(intermezzo);
        getRooms().add(intermezzo_est);
        getRooms().add(fine_trincea);
        getRooms().add(Amber_clad);

        //mappa
        intro.setNorth(ufficio_comandante);
        ufficio_comandante.setSouth(intro);
        ufficio_comandante.setNorth(ingresso_trincea);
        ingresso_trincea.setSouth(ufficio_comandante);
        ingresso_trincea.setWest(campo_add);
        ingresso_trincea.setNorth(vicolo_cieco);
        vicolo_cieco.setSouth(ingresso_trincea);
        campo_add.setNorth(ingresso_campo_add);
        campo_add.setSouth(ingresso_trincea);
        ingresso_campo_add.setWest(intermezzo);
        ingresso_campo_add.setSouth(campo_add);
        intermezzo.setEast(intermezzo_est);
        intermezzo_est.setNorth(fine_trincea);
        intermezzo_est.setSouth(intermezzo);
        fine_trincea.setNorth(Amber_clad);

        //oggetti
        Item caffe = new Item(1);
        caffe.setHealer(true);
        caffe.setHeal(5);
        getItemList().add(caffe);

        Item pistola = new Item(2);
        pistola.setWeapon(true);
        pistola.setBullet(20);
        pistola.setPower(40);
        getItemList().add(pistola);

        Item piedePorco = new Item(3);
        piedePorco.setWeapon(true);
        piedePorco.setPower(60);
        getItemList().add(piedePorco);

        Item granata = new Item(4);
        granata.setWeapon(true);
        granata.setPower(80);
        granata.setBullet(5);
        getItemList().add(granata);

        Item razioneK = new Item(5);
        razioneK.setHealer(true);
        razioneK.setHeal(40);
        getItemList().add(razioneK);

        Item armatura = new Item(6);
        armatura.setArmor(true);
        armatura.setProtection(50);
        getItemList().add(armatura);
        
        Item armatura_rotta = new Item(7);
        armatura_rotta.setArmor(true);
        armatura_rotta.setProtection(30);
        getItemList().add(armatura_rotta);
        
        
        

        //NPC
        Npc amari = new Npc(100, "amari", "Ecco Pier,Frank e Giulio!");
        amari.setSpeakable(true);
        amari.setEnemy(false);
        getNpcList().add(amari);
        
        Npc ufficiale = new Npc(100, "ufficiale_in_servizio", "Ufficiale in comando... Meglio seguire i suoi ordini!");
        ufficiale.setSpeakable(true);
        ufficiale.setEnemy(false);
        getNpcList().add(ufficiale);
        
        Npc galatone = new Npc(100, "prof_galatone", "Ecco l'ingegner Galatone, esperto di esplosivi!");
        galatone.setSpeakable(true);
        galatone.setEnemy(false);
        getNpcList().add(galatone);
        
        Npc soldato = new Npc(50, "soldato", "Bisogna aiutare questo soldato in difficoltà");
        soldato.setSpeakable(true);
        soldato.setEnemy(false);
        getNpcList().add(soldato);
           
        //Npc nemici - aggiungere un nuovo nemico!
        Npc orda = new Npc(150, "orda_zombie", "Un gruppo di zombie è diretto verso di te!");
        orda.setEnemy(true);
        orda.setSpeakable(false);
        //equipaggiare arma con quale far combattere gli zombi o il motro che volete
        getNpcList().add(orda);
        
        Npc demogorgone = new Npc(150, "demogorgone", "Un demogorgone, un mostro orribile");
        demogorgone.setEnemy(true);
        demogorgone.setSpeakable(false);
        getNpcList().add(demogorgone);

        //item insert
        intro.getItems().add(caffe);
        ufficio_comandante.getItems().add(pistola);
        ufficio_comandante.getItems().add(piedePorco);
        campo_add.getItems().add(granata);
        campo_add.getItems().add(razioneK);
        ingresso_trincea.getItems().add(armatura);
        intermezzo.getItems().add(razioneK);
        intermezzo.getItems().add(armatura_rotta);

        //NPC insert
        intro.getNpcs().add(amari);
        ufficio_comandante.getNpcs().add(ufficiale);
        vicolo_cieco.getNpcs().add(demogorgone);
        campo_add.getNpcs().add(galatone);
        ingresso_campo_add.getNpcs().add(orda);
        intermezzo.getNpcs().add(soldato);
        intermezzo_est.getNpcs().add(orda);
        fine_trincea.getNpcs().add(demogorgone);
        
        
        

        //Starting room
        setCurrentRoom(intro);
    }

    @Override
    public boolean isWin(GameDescription game){
        boolean win = false;
        int idFinalStanza = game.getCurrentRoom().getId();
        
        if(idFinalStanza == 10){
            win = true;
        }
        
        return win;
    }

    @Override
    public boolean isLose(){
        boolean lose = false;
        if(getPlayer().getHp() <= 0){
            lose = true;
            System.out.println("Sei morto!");
        }
        return lose;
    }
}
