package di.uniba.map.game.story;

import di.uniba.map.game.type.*;
import di.uniba.map.game.engine.GameDescription;

public class Story extends GameDescription{

    @Override
    public void init() {

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
        Room entrylevel = new Room(0, "La tua misera stanza!", "Risveglio, sei appena entrato a far parte di casa Amari!\nTi aspetta una giornata impegnativa. Inizia l'avventura.");
        entrylevel.setLook("All'interno della tua stanza, potrai vestirti e uscire dalla stanza.");

        Room entry_corridoio = new Room(1, "Corridoio", "Uscita dalla tua camera ");
        entry_corridoio.setLook("Vediamo cosa c'è in giro e troviamo qualcosa di interessante\nin questa minchia di casa.");

        Room corridoio_est = new Room(2, "Corridoio", "Corridoio a est");
        corridoio_est.setLook("Ti trovi nell'atrio di casa tua. Da qui è possibile abbandonare la casa.");

        Room atrio_ovest  = new Room(3, "Atrio", "Atrio ovest");
        atrio_ovest.setLook("Questa è la cucina di casa Amari. Davanti i tuoi occhi, trovi una tavola\nimbandita per la colazione. Sulla tua sinistra trovi una macchinetta\ndel caffè pronta all'uso.\nAlla tua destra trovi un Pier selvatico che guarda i biscotti sul tavolo." );

        Room corridoio_nord = new Room(4, "Corridoio", "Corridoio a nord");
        corridoio_nord.setLook("Qui trovi la camera del vecchio Frank!\nEntrando trovi Frank intento a guardare il solito documentario\nsul fantasmagorico Boemo Zeman, EX-allenatore del Foggia." );

        Room corridoio_ovest = new Room(5, "Corridoio", "Corridoio a ovest");
        corridoio_ovest.setLook(" Adesso, trovi la stanza del pericolos Giulio Spaccatutto! (NO! non è ispirato a Ralph!). \n Entrando in camera sua, lo trovi imperterrito davanti al suo televisore mentre guarda una replica di Formula 1. \n Preso dalla rabbia per gli errori fatti dalla sua scuderia preferita, tira un pugno sul muro. ");

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

        Item cassa = new Item(8, "Cassa", "Potrà contenere sicuramente qualcosa...");
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
        pierDialog(pier);
        getNpcList().add(pier);
        
        Npc giulio = new Npc(100, "giulio", "Giulio è on fire, ha voglia di spaccare qualcosa.");
        giulio.setSpeakable(true);
        giulio.setEnemy(false);
        //giulioDialog(giulio);
        getNpcList().add(giulio);
        
        Npc frank = new Npc(100, "frank", "Frank riflette....come sempre.");
        frank.setSpeakable(true);
        frank.setEnemy(false);
        //frankDialog(frank);
        getNpcList().add(frank);
        
        Npc pippo = new Npc(100, "pippo", "Pippo è molto allegro, è un grande programmatore!");
        pippo.setSpeakable(true);
        pippo.setEnemy(false);
        //pippoDialog(pippo);
        getNpcList().add(pippo);
        
        Npc lanubile = new Npc(100, "prof_lanubile", "Ecco il capo prof. lanubile e il suo braccio destro.... Ciccio.");
        lanubile.setSpeakable(true);
        lanubile.setEnemy(false);
        //lanubileDialog(lanubile);
        getNpcList().add(lanubile);
        
        Npc ufficiale = new Npc(100, "ufficiale_in_servizio", "Ufficiale in comando....meglio seguire i suoi ordini.");
        ufficiale.setSpeakable(true);
        ufficiale.setEnemy(false);
        //ufficialeDialog(ufficiale);
        getNpcList().add(ufficiale);
        
        Npc galatone = new Npc(100, "prof_galatone", "Ecco l'ingegner Galatone, l'esperto di esplosivi.");
        galatone.setSpeakable(true);
        galatone.setEnemy(false);
        //galatoneDialog(galatone);
        getNpcList().add(galatone);
        
        Npc soldato = new Npc(100, "soldato", "Bisogna aiutare questo soldato in difficoltà.");
        soldato.setSpeakable(true);
        soldato.setEnemy(false);
        //soldatoDialog(soldato);
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

    private static void commonDialog(Talk talk1, Npc npc) {

        Talk talk2 = new Talk();
        Answer answer = new Answer();
        answer.setAnswer("Chi sei?");
        answer.setWarp(talk2);
        talk1.getAns().add(answer);

        answer = new Answer();
        talk2.setSpeech(npc.getDescription());
        answer.setAnswer("Ho capito!");
        answer.setWarp(talk1);
        talk2.getAns().add(answer);

        answer = new Answer();
        answer.setAnswer("Fine");
        talk1.getAns().add(answer);

    }

    private void pierDialog(Npc pier) {

        /*Talk talk1 = new Talk();
        pier.setTalk(talk1);

        Talk talk2 = new Talk();
        Answer answer = new Answer();
        talk1.setSpeech("Ehi le' ciao! Sono Pier, il tuo strano coinquilino e compagno di classe.");
        answer.setAnswer("Ciao Pier! oggi mi sono svegliato con il durello. Cosa stai mangiando?");
        answer.setWarp(talk2);
        talk1.getAns().add(answer);

        answer = new Answer();
        talk2.setSpeech("Sto mangiando dei biscotti le! e mi sto chiedendo ancora una volta perche'\nhanno una forma strana...");
        Talk talk3 = new Talk();
        answer.setAnswer("Vabbe' ho capito. Ti lascio riflettere sul senso del vita.");
        answer.setWarp(talk3);
        talk2.getAns().add(answer);

        commonDialog(talk1, pier);*/

        Talk talk1 = new Talk();
        pier.setTalk(talk1);
        Talk talk2 = new Talk();
        Answer answer = new Answer();
        talk1.setSpeech("Salve!");
        answer.setAnswer("Dove mi trovo?");
        answer.setWarp(talk2);
        talk1.getAns().add(answer);

        answer = new Answer();
        talk2.setSpeech("Ti trovi a Campo Vecchio! E' l'ultimo accampamento sopravvissuto qui.");
        Talk talk3 = new Talk();
        answer.setAnswer("Cosa è successo?");
        answer.setWarp(talk3);
        talk2.getAns().add(answer);

        answer = new Answer();
        talk3.setSpeech("E' passato ormai tanto tempo da quando siamo chiusi qui dentro. I mostri della zona hanno fatto il resto. Guardati sempre le spalle anche da quelli come te.");
        answer.setAnswer("Mmm..");
        answer.setWarp(talk2);
        talk3.getAns().add(answer);

        talk3 = new Talk();
        answer = new Answer();
        answer.setAnswer("Come esco da qui?");
        answer.setWarp(talk3);
        talk2.getAns().add(answer);

        answer = new Answer();
        talk3.setSpeech("Solo il Barone decide chi può uscire, e non credo la tua permanenza durerà così poco...");
        answer.setAnswer("Va bene");
        Talk talk4 = new Talk();
        answer.setWarp(talk4);
        talk3.getAns().add(answer);

        /*Answer a = new Answer();
        talk4.setSpeech("In ogni caso prendi questa, l'ho trovata da queste parti e potrebbe tornarti utile");
        a.setAnswer("Ok, grazie!");
        Answer finalAnswer = answer;
        a.setTriggerReference(() -> {
            System.out.println(e_guard.getName() + " ti ha dato un " + key_b.getName() + "!");
            getPlayer().getInventory().add(key_b);
            finalAnswer.setWarp(talk2);
        });
        talk4.getAns().add(a);*/

        answer = new Answer();
        answer.setAnswer("Ho capito.");
        answer.setWarp(talk1);
        talk2.getAns().add(answer);
        commonDialog(talk1, pier);

    }

    private void gate_guardDialog(Npc gate_guard, Item letter, Room b_room) {
        Talk talk1 = new Talk();
        gate_guard.setTalk(talk1);
        Talk talk2 = new Talk();
        Answer answerP = new Answer();
        talk1.setSpeech("Salve!");
        answerP.setAnswer("Posso entrare?");
        answerP.setWarp(talk2);
        talk1.getAns().add(answerP);

            Answer answer = new Answer();
            talk2.setSpeech("Assolutamente no ragazzo. Solo le guarde sono autorizzate ad entrare.");
            Talk talk3 = new Talk();
            answer.setAnswer("Non c'è proprio niente che io possa fare?");
            answer.setWarp(talk3);
            talk2.getAns().add(answer);

                answer = new Answer();
                talk3.setSpeech("Bhe ci sarebbe una cosa che potresti fare. C'è una cassa da qualche parte nel bosco contenente una .. ehm.. lettera. \nLa cassa è chiusa ma qualcuno in zona saprà aiutarti. Recuperala per me e ti farò entrare senza fare domande.");
                answer.setAnswer("Va bene, lo farò!");
                Talk hidden_talk = new Talk();
                Answer hidden_answer = new Answer();
                answer.setTriggerReference(() -> {
                    talk1.getAns().remove(answerP);
                    talk1.getAns().add(hidden_answer);});
                answer.setWarp(talk1);
                talk3.getAns().add(answer);

                hidden_answer.setAnswer("Ho la tua lettera!");
                hidden_answer.setTriggerReference(() -> {
                    Answer h_answer = new Answer();
                    if(getPlayer().getInventory().getList().contains(letter)){
                        hidden_talk.setSpeech("Hai la lettera! Puoi passare e.. buona fortuna.");
                        h_answer.setAnswer("Grazie!");
                        gate_guard.setSpeakable(false);
                        b_room.setLock(false);
                    }else{
                        hidden_talk.setSpeech("Non hai la lettera");
                        h_answer.setAnswer("Grr..");
                        h_answer.setWarp(talk1);
                    }
                    hidden_talk.getAns().clear();
                    hidden_talk.getAns().add(h_answer);
                });
                hidden_answer.setWarp(hidden_talk);


            answer = new Answer();
            answer.setAnswer("Mmm..");
            answer.setWarp(talk1);
            talk2.getAns().add(answer);

        talk2 = new Talk();
        answer = new Answer();
        answer.setAnswer("Chi è il Barone?");
        answer.setWarp(talk2);
        talk1.getAns().add(answer);

            answer = new Answer();
            talk2.setSpeech("Non è un tipo facile. Non sta simpatico a molti ma è lui che decide le cose qui..");
            answer.setAnswer("Chiaro.");
            answer.setWarp(talk1);
            talk2.getAns().add(answer);

        commonDialog(talk1, gate_guard);
    }

    private void fabbroDialog(Npc fabbro, Room room, Npc b1, Npc b2, Item key) {
        Talk talk1 = new Talk();
        fabbro.setTalk(talk1);
        Talk talk2 = new Talk();
        Answer answer = new Answer();
        talk1.setSpeech("Ehi tu vieni qua!");
        answer.setAnswer("Cosa c'è?");
        answer.setWarp(talk2);
        talk1.getAns().add(answer);

        answer = new Answer();
        talk2.setSpeech("Potresti darmi una mano con questi due qui?");
        Talk talk3 = new Talk();
        answer.setAnswer("Perché dovrei?");
        answer.setWarp(talk3);
        talk2.getAns().add(answer);

        answer = new Answer();
        talk3.setSpeech("Aiutami e ti aiuterò qualsiasi cosa tu abbia bisogno!");
        answer.setAnswer("Mhm..ok");
        Talk talk4 = new Talk();
        Talk talk5 = new Talk();
        answer.setTriggerReference(() -> {
            fabbro.setTalk(talk5);
        });
        talk3.getAns().add(answer);

        answer = new Answer();
        talk5.setSpeech("...");
        answer.setAnswer("A proposito di quella questione...");
        answer.setTriggerReference(() -> {
            Answer a = new Answer();
            talk1.getAns().clear();
            if(room.getNpcs().contains(b1) || room.getNpcs().contains(b2)){
                talk1.setSpeech("Ehi ci sono ancora questi due a darmi fastidio!");
                a.setAnswer("Provvederò!");
            }else{
                talk1.setSpeech("Ti ringrazio per l'aiuto. Chiedimi quello che vuoi.");
                a.setAnswer("Ho bisogno di una chiave per aprire una cassa");
                a.setWarp(talk4);
                talk1.getAns().add(a);
                a = new Answer();
                a.setAnswer("No grazie.");
            }
            talk1.getAns().add(a);
        });
        answer.setWarp(talk1 );
        talk5.getAns().add(answer);

        answer = new Answer();
        talk4.setSpeech("Ne ho proprio una che fa al caso tuo, dovrebbe andar bene!");
        answer.setAnswer("Ok, dammela!");
        answer.setTriggerReference(() -> {
            System.out.println(fabbro.getName() + " ti ha dato una chiave!");
            getPlayer().getInventory().add(key);
            fabbro.setSpeakable(false);
        });
        talk4.getAns().add(answer);
    }

    private static void bullyDialog(Npc npc, String str) {
        Talk talk1 = new Talk();
        npc.setTalk(talk1);
        Answer answer = new Answer();
        talk1.setSpeech(str);
        answer.setAnswer("Grr..");
        answer.setTriggerReference(() -> {
            npc.setSpeakable(false);
            npc.setAttacking(true);
        });
        talk1.getAns().add(answer);

    }

    public boolean isWin(GameDescription game){
        boolean win = false;
        int idFinalStanza = game.getCurrentRoom().getId();
        
        if(idFinalStanza == 24){
            win = true;
        }
        
        return win;
    }

    public boolean isLose(){
        boolean lose = false;
        if(getPlayer().getHp() <= 0){
            lose = true;
            System.out.println("Sei morto!");
        }
        return lose;
    }
}
