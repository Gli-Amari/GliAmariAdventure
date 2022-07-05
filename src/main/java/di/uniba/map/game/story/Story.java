package di.uniba.map.game.story;

import di.uniba.map.game.type.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import di.uniba.map.game.engine.GameDescription;

public class Story extends GameDescription{

    Db db = new Db();

    /**
     *  query di interrogazione
     */
    private static String SELECT_ALL_stanza = "SELECT * FROM Stanza WHERE id = ?";
    private static String SELECT_ALL_oggetti = "SELECT * FROM oggetti WHERE id = ?";
    private static String SELECT_ALL_npc = "SELECT * FROM npc WHERE id = ?";

    ResultSet rs_stanza = null;
    ResultSet rs_oggetti = null;
    ResultSet rs_npc = null;

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

        Command open = new Command(CommandType.OPEN, "apri");
        open.setAlias(new String[]{});
        getCommands().add(open);

        Command push = new Command(CommandType.PUSH, "premi");
        push.setAlias(new String[]{"spingi","attiva"});
        getCommands().add(push);

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
        rs_stanza = db.executeQueryInStory(SELECT_ALL_stanza, 0);
        Room entrylevel = new Room(rs_stanza.getInt(1), rs_stanza.getString(2), rs_stanza.getString(3));
        entrylevel.setLook(rs_stanza.getString(4));

        Room entry_corridoio = new Room(1, "Corridoio", "Uscita dalla tua camera ");
        entry_corridoio.setLook("Vediamo cosa c'è in giro e troviamo qualcosa di interessante\nin questa minchia di casa.");

        Room corridoio_est = new Room(2, "Corridoio", "Corridoio a est");
        corridoio_est.setLook("Ti trovi nell'atrio di casa tua. Da qui è possibile abbandonare la casa.");

        Room atrio_ovest  = new Room(3, "Atrio", "Atrio ovest");
        atrio_ovest.setLook("Questa è la cucina di casa Amari. Davanti i tuoi occhi, trovi una tavola\nimbandita per la colazione. Sulla tua sinistra trovi una macchinetta\ndel caffè pronta all'uso.\nAlla tua destra trovi un Pier selvatico che guarda i biscotti sul tavolo." );

        Room corridoio_nord = new Room(4, "Corridoio", "Corridoio a nord");
        corridoio_nord.setLook("Qui trovi la camera del vecchio Frank!\nEntrando trovi Frank intento a guardare il solito documentario\nsul fantasmagorico Boemo Zeman, EX-allenatore del Foggia." );

        Room corridoio_ovest = new Room(5, "Corridoio", "Corridoio a ovest");
        corridoio_ovest.setLook("Adesso, trovi la stanza del pericolos Giulio Spaccatutto! (NO! non è ispirato a Ralph!). \n Entrando in camera sua, lo trovi imperterrito davanti al suo televisore mentre guarda una replica di Formula 1. \n Preso dalla rabbia per gli errori fatti dalla sua scuderia preferita, tira un pugno sul muro. ");

        Room entry_campus = new Room(6, "Campus", "ingresso campus");
        entry_campus.setLook("Ti trovi all'ingresso del tuo campus universitario. E' un'area molto vasta, cerca il tuo dipartimento.");

        Room Campus_ovest = new Room(7, "Campus", "Campus a ovest");
        Campus_ovest.setLook("Ti trovi al Politecnico di Bari: regno dei fuori corso!. Trovi un ragazzo molto bislacco e snello, molto selvaggio che saluta tristemente la sua dolce metà Cinzia.");

        Room Campus_nord = new Room(8, "Campus", "Campus a nord");
        Campus_nord.setLook("   Davanti a te trovi la casa del nemico: il dipartimento di matematica. E' un dipartimento molto triste: all'interno ci trovi il dio dell'inferno e il dio del paradiso, rispettivamente la Germinario e il mitico Pugliese!. Quante te ne ha fatte passare la Germinario per quel maledetto esame di analisi 1. D'altro canto, Pugliese ti ha dato una grandissima soddisfazione credendo più che mai in te!.  " );

        Room Campus_est = new Room(9, "Campus", "Campus a est");
        Campus_est.setLook("Ti trovi nel famoso palazzo di vetro dell'Onu, o meglio noto come dipartimento di informatica. All'ingresso trovi un membro di un associazione studentesca che ti chiede se hai votato.");

        Room dibest = new Room(10, "DIB", "DIB a est");
        dibest.setLook(" Ti trovi di fronte l'oggetto più sacro del dipartimento di informatica, la macchinetta del caffè pronta per essere usata. Al suo finaco trovi il prof. labubile con il suo cane baffuto Ciccio a bersi il caffè. Ride a crepa pelle!.");

        Room dibovest = new Room(11, "DIB", "DIB a ovest");
        dibovest.setLook("Ti troverai dentro l'aula A. Dove trovi tutti gli amici ciobbà e Pippo che sembra arrabbiato. Sicuramente avrà corretto tanti progetti orribili come il nostro. Comprensibile come cosa.");

        Room Start_level = new Room(12, "Ufficio comandante", "Ti trovi all'interno dell'ufficio del tuo comandante, ti sta spiegando la tattica di guerra");
        Start_level.setLook("Ti trovi all'interno dell'ufficio del comandante. Hai dinanzi a te una cassa. Magari potrebbe esser utile scoprire cose vi è all'interno.\n Inoltre dietro di te è presente una porta. ");

        Room Entry_trincea = new Room(13, "ingresso trincea", "Ti trovi all'interno della trincea.");
        Entry_trincea.setLook("Sei nel mezzo di un campo di battaglia, intorno a te solo morte e distruzione. Sei in compagnia degli amari.");

        Room trincea_empty = new Room(14, "Vicolo cieco", "Ti trovi nel mezzo di un vicolo senza la possibilità di proseguire");
        trincea_empty.setLook("Ti trovi nel mezzo di un vicolo senza la possibilità di proseguire");

        Room trincea_addestramento= new Room(15, "Campo di addestramento", "Questo è un campo di addestamento");
        trincea_addestramento.setLook("Ti trovi in un campo di addestramento, e dinanzi vedi il sergente mimmo Glatone insieme ad un gruppo di soldati. Il sergente ha il compito di far esercitare i soldati a lanciare le granate.");

        Room trincea_orda = new Room(16, "Ingresso del campo di addestramento", "Ti trovi al di fuori del campo di addestramento");
        trincea_orda.setLook("Hai appena completato il tuo addestramento. Esci dal campo e ti rendi conto che questo è sotto attacco da un'orda di alieni. DEVI DIFENDERLO A TUTTU I COSTI!");

        Room Ospedale_campo = new Room(17, "Ospedale da campo", "Ti ritrovi all'interno dell'ospedale da campo allestito per i feriti di guerra");
        Ospedale_campo.setLook("All'interno del campo noti tutti i soldati feriti. In mezzo al caos, sembra spuntare una razione K. Potrebbe tornarti utile!");

        Room Ospedale_nord = new Room(18, "Ospedale", "Ospedale a Nord");
        Ospedale_nord.setLook( "Ti ritrovi nell'ala nord dell'ospedale e noti la presenza di un gruppo di alieni, che girano nei corridoi.");

        Room Intermezzo = new Room(19, "Intermezzo", "Zona morta");
        Intermezzo.setLook("Ti ritrovi in una zona di guerra appena bombardata. Sono tutti morti, ma riesci a udire il lamento di un soldato alleato.");

        Room Intermezzo_est = new Room(20, "Intermezzo", "Intermezzo a est");
        Intermezzo_est.setLook("Continuando la tua missione, arrivi in una zona molto tranquilla, sembra quasi intatta. Mentre controlli in giro, ti ritrovi  in un bombardamento. Riesci però a salvarti. Al tuo risveglio un tuo compagno ti aiuta a rialzarti e ti offre una razione K. " );

        Room end_trincea = new Room(21, "Trincea", "Fine della trincea");
        end_trincea.setLook("Subito dopo il bombardamento, è tutto distrutto. Sei solo. Ma devi portare a termine la missione. Mentre continui a camminare per la tua strada un alieno sopravvisuto ti attacca di sorpresa e c'è un solo modo per liberati di lui.");

        //aggiunta stanze
        getRooms().add(trincea_addestramento);
        getRooms().add(entrylevel);
        getRooms().add(entry_corridoio);
        getRooms().add(corridoio_est);
        getRooms().add(atrio_ovest);
        getRooms().add(corridoio_nord);
        getRooms().add(corridoio_ovest);
        getRooms().add(entry_campus);
        getRooms().add(Campus_ovest);
        getRooms().add(Campus_nord);
        getRooms().add(Campus_est);
        getRooms().add(dibest);
        getRooms().add(dibovest);
        getRooms().add(Start_level);
        getRooms().add(Entry_trincea);
        getRooms().add(trincea_empty);
        getRooms().add(trincea_orda);
        getRooms().add(Ospedale_campo);
        getRooms().add(Ospedale_nord);
        getRooms().add(Intermezzo);
        getRooms().add(Intermezzo_est);
        getRooms().add(end_trincea);

        entrylevel.setNorth(entry_corridoio);
        entry_corridoio.setSouth(entrylevel);
        entry_corridoio.setWest(corridoio_ovest);
        entry_corridoio.setNorth(corridoio_nord);
        entry_corridoio.setEast(corridoio_est);
        atrio_ovest.setSouth(corridoio_est);
        corridoio_nord.setSouth(entry_corridoio);
        corridoio_ovest.setSouth(entry_corridoio);
        corridoio_est.setWest(atrio_ovest);
        corridoio_est.setNorth(entry_campus);
        corridoio_est.setSouth(entry_corridoio);
        entry_campus.setNorth(Campus_nord);
        entry_campus.setWest(Campus_ovest);
        entry_campus.setEast(Campus_est);
        Campus_ovest.setSouth(entry_campus);
        Campus_nord.setSouth(entry_campus);
        dibest.setSouth(Campus_est );
        dibovest.setSouth(Campus_est);
        Start_level.setNorth(Entry_trincea);
        Entry_trincea.setSouth(Start_level);
        Entry_trincea.setWest(trincea_addestramento);
        Entry_trincea.setNorth(trincea_empty);
        trincea_empty.setSouth(Entry_trincea);
        trincea_addestramento.setSouth(Entry_trincea);
        trincea_addestramento.setNorth(trincea_orda);
        trincea_orda.setSouth(trincea_addestramento);
        trincea_orda.setEast(Ospedale_campo);
        Ospedale_campo.setWest(Intermezzo);
        Ospedale_campo.setNorth(Ospedale_nord);
        Ospedale_nord.setSouth(Ospedale_campo);
        Intermezzo.setEast(Intermezzo_est);
        Intermezzo_est.setNorth(end_trincea);
        Campus_est.setWest(dibovest);
        Campus_est.setEast(dibest);

        //temp
        Campus_est.setNorth(Start_level);

        //oggetti
        Item vestiti = new Item(1, "vestiti", "puoi indossare i vestiti prima di uscire dalla sua stanza.");
        vestiti.setArmor(true);
        vestiti.setProtection(15);
        getItemList().add(vestiti);

        Item caffe = new Item(4, "caffe", "Combustibile per un programmatore");
        getItemList().add(caffe);

        Item pistola = new Item(6, "pistola", "Utile per colpire un nemico anche a distanza non ravvicinata");
        pistola.setWeapon(true);
        pistola.setPower(40);
        getItemList().add(pistola);

        Item piedePorco = new Item(3, "piede_di_porco", "Utile per colpire un nemico corpo a corpo.");
        piedePorco.setWeapon(true);
        piedePorco.setPower(60);
        getItemList().add(piedePorco);

        Item granata = new Item(5, "granate", "Utile per uccidere gruppi di nemici");
        granata.setWeapon(true);
        granata.setPower(80);
        getItemList().add(granata);

        Item razioneK = new Item(7, "razioneK", "Utile nel recuperare hp.");
        razioneK.setHealer(true);
        razioneK.setHeal(40);
        getItemList().add(razioneK);

        Item cassa = new Item(8, "cassa", "Potrà contenere sicuramente qualcosa...");
        cassa.setPickupable(false);
        cassa.setOpenable(true);
        cassa.setIsContainer(true);
        cassa.getItemList().add(piedePorco);
        cassa.getItemList().add(pistola);
        getItemList().add(cassa);

        //NPC
        Npc pier = new Npc(100, "pier", "Ecco Pier, avvolto nei suoi pensieri.");
        pier.setSpeakable(true);
        pier.setEnemy(false);
        getNpcList().add(pier);
        
        Npc giulio = new Npc(100, "giulio", "Giulio è on fire, ha voglia di spaccare qualcosa.");
        giulio.setSpeakable(true);
        giulio.setEnemy(false);
        getNpcList().add(giulio);
        
        Npc frank = new Npc(100, "frank", "Frank riflette....come sempre.");
        frank.setSpeakable(true);
        frank.setEnemy(false);
        getNpcList().add(frank);
        
        Npc pippo = new Npc(100, "pippo", "Pippo è molto allegro, è un grande programmatore!");
        pippo.setSpeakable(true);
        pippo.setEnemy(false);
        getNpcList().add(pippo);
        
        Npc lanubile = new Npc(100, "prof_lanubile", "Ecco il capo prof. lanubile e il suo braccio destro.... Ciccio.");
        lanubile.setSpeakable(true);
        lanubile.setEnemy(false);
        getNpcList().add(lanubile);
        
        Npc ufficiale = new Npc(100, "ufficiale_in_servizio", "Ufficiale in comando....meglio seguire i suoi ordini.");
        ufficiale.setSpeakable(true);
        ufficiale.setEnemy(false);
        getNpcList().add(ufficiale);
        
        Npc galatone = new Npc(100, "prof_galatone", "Ecco l'ingegner Galatone, l'esperto di esplosivi.");
        galatone.setSpeakable(true);
        galatone.setEnemy(false);
        getNpcList().add(galatone);
        
        Npc soldato = new Npc(100, "soldato", "Bisogna aiutare questo soldato in difficoltà.");
        soldato.setSpeakable(true);
        soldato.setEnemy(false);
        getNpcList().add(soldato);
           
        //Npc nemici
        Npc orda = new Npc(200, "orda_di_zombie", "Un gruppo di zombi diretto verso di te!");
        orda.setEnemy(true);
        getNpcList().add(orda);
        
        Npc demogorgone = new Npc(150, "demogorgone", "un mostro orribile!");
        demogorgone.setEnemy(true);
        getNpcList().add(demogorgone);

        //item insert
        entrylevel.getItems().add(vestiti);
        dibest.getItems().add(caffe);
        Start_level.getItems().add(cassa);
        trincea_addestramento.getItems().add(granata);
        Ospedale_nord.getItems().add(razioneK);

        //NPC insert
        corridoio_nord.getNpcs().add(frank);
        corridoio_ovest.getNpcs().add(giulio);
        atrio_ovest.getNpcs().add(pier);
        dibovest.getNpcs().add(pippo);
        dibest.getNpcs().add(lanubile);
        Start_level.getNpcs().add(ufficiale);
        trincea_addestramento.getNpcs().add(galatone);
        Intermezzo.getNpcs().add(soldato);
        trincea_orda.getNpcs().add(orda);
        trincea_empty.getNpcs().add(demogorgone);
        Ospedale_nord.getNpcs().add(orda);
        end_trincea.getNpcs().add(demogorgone);

        //Starting room
        setCurrentRoom(entrylevel);

    }

    @Override
    public boolean isWin(GameDescription game){
        boolean win = false;
        int idFinalStanza = game.getCurrentRoom().getId();
        
        if(idFinalStanza == 24){
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
