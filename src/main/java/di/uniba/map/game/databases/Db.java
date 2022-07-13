package di.uniba.map.game.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Db {
    
    /**
     * query di creazione
     */
    public static final String CREATE_ROOM = "CREATE TABLE IF NOT EXISTS room (id int PRIMARY KEY, name TEXT, desc TEXT, look TEXT)";
    public static final String CREATE_ITEM = "CREATE TABLE IF NOT EXISTS item (id int PRIMARY KEY, name VARCHAR(100), desc VARCHAR(100))";

    /**
     * query di ricerca basate sugli id delle tabelle
     */
    public static final String SELECT1 = "SELECT id FROM room WHERE id = ?";
    public static final String SELECT2 = "SELECT id FROM item WHERE id = ?";

    /**
     * query di popolazione delle tabelle
     */
    public static final String INSERT1 = "INSERT INTO room VALUES (?, ?, ?, ?)";
    public static final String INSERT2 = "INSERT INTO item VALUES (?, ?, ?)";

    private static Connection c;
    private Properties p;

    public Db(){

        try{
            p = properties();
            c = connection(p);
            createAllTable();
        }catch(SQLException e){
            System.err.println(e.getSQLState() + ":" + e.getMessage());
        }

    }

    /** 
     * metodo per impostare le proprietà d'accesso al db
     * @return Properties
     */
    public static Properties properties(){
        Properties p = new Properties();
        p.setProperty("user", "amaro");
        p.setProperty("password", "1234");

        return p;
    }

    /** 
     * metodo per creare la connessione al db
     * @param p
     * @return Connection
     * @throws SQLException
     */
    public static Connection connection(Properties p) throws SQLException{
        return DriverManager.getConnection("jdbc:h2:./resource/db/amari", p);
    }

    /** 
     * @throws SQLException
     */
    public void closeConnection() throws SQLException{
        getConnection().close();
    } 

    /** 
     * metodo per creare e leggere i dati presenti nelle tabelle
     * @param select
     * @param idStatement
     * @return rs
     * @throws SQLException
     */
    public ResultSet readFromDb(String select, int idStatement) throws SQLException{
        PreparedStatement ps = getConnection().prepareStatement(select);
        ps.setInt(1, idStatement);
        ResultSet rs = ps.executeQuery();

        return rs;
    }

    /** 
     * metodo che controlla se l'id è presente o meno nella tabella. In caso in cui non esistesse
     * viene effettuato l'ineserimento in tabella
     * @param select
     * @param id
     * @param queryInsert
     * @param array
     * @throws SQLException
     */
    public void init(String select, int id, String queryInsert, String[] array) throws SQLException{
        ResultSet rs = readFromDb(select, id);
        if(!exists(rs, id)){
            insertStringIntoTheTable(id, queryInsert, array);
        }
    }

    /** 
     * @param id
     * @param insert
     * @param array
     * @throws SQLException
     */
    public void insertStringIntoTheTable(int id, String insert, String[] array) throws SQLException{

        PreparedStatement ps = getConnection().prepareStatement(insert);

        if(array.length == 3) { //per le stanze
            ps.setInt(1, id);
            ps.setString(2, array[0]);
            ps.setString(3, array[1]);
            ps.setString(4, array[2]);

            ps.executeUpdate();
        } else if(array.length == 2){ //per gli oggetti
            ps.setInt(1, id);
            ps.setString(2, array[0]);
            ps.setString(3, array[1]);

            ps.executeUpdate(); 
        } else{
            System.out.println("Errore su insertStringIntoTheTable" + id);
        }

        ps.close();
    }

    /**
     *  metodo che crea la tabella
     * @param table 
     * @throws SQLException
     */
    public void createTable(String table) throws SQLException{
        Statement stat = getConnection().createStatement();
        stat.executeUpdate(table);
        stat.close();
    }

    /** 
     * metodo getter per la connessione al db
     * @return c
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        return c;
    }

    /** 
     * @throws SQLException
     */
    public void createAllTable() throws SQLException{
        createTable(CREATE_ROOM);
        createTable(CREATE_ITEM);
        populationTable();
    }
     
    /** 
     * @throws SQLException
     */
    public void populationTable() throws SQLException{

        //aggiungere le stanze qui!
        String[] room1 = {"Intro", "Benvenuto a casa amari", "Ti trovi nell'altrio di casa con Gli Amari, Frank, Giulio e Pier.\n" + "Sta per iniziare una solita giornata noiosa."};
        init(SELECT1,1,INSERT1,room1);

        String[] room2 = {"Ufficio comandante", "Ti trovi all'interno dell'ufficio del tuo comandante, e' passato un mese da quando hai lasciato casa, ascolti il tuo comandante spiegare\nla tattica di guerra. La paura di non farcela e' molta", "Ti trovi all'interno dell'ufficio del comandante.\n" + "Davanti a te e' presente una porta."};
        init(SELECT1,2,INSERT1,room2);

        String[] room3 = {"Ingresso Trincea", "Ti trovi all'interno della trincea", "Sei nel mezzo di un campo di battaglia, intorno a te solo morte e distruzione."};
        init(SELECT1,3,INSERT1,room3);

        String[] room4 = {"Vicolo cieco", "Ti trovi nel mezzo di un vicolo cieco senza la possibilità di proseguire", "Sei in un vicolo, sembra non esserci niente di che...ma scorgi all'improvviso un Demogorgone."};
        init(SELECT1,4,INSERT1,room4);

        String[] room5 = {"Campo di addestramento", "Questo e' un campo di addestramento", "Ti trovi in un campo di addestramento, e dinanzi vedi il sergente mimmo Glatone insieme ad un gruppo di soldati.\nIl sergente ha il compito di far esercitare i soldati a lanciare le granate."};
        init(SELECT1,5,INSERT1,room5);

        String[] room6 = {"Ingresso del campo di addestramento", "Ti trovi al di fuori del campo di addestramento", "Hai appena completato il tuo addestramento.\nEsci dal campo e ti rendi conto che questo e' sotto attacco da un'orda di alieni.\nDEVI DIFENDERLO A TUTTI I COSTI!!"};
        init(SELECT1,6,INSERT1,room6);

        String[] room7 = {"Intermezzo", "Zona morta", "Ti ritrovi in una zona di guerra appena bombardata.\nSono tutti morti, ma riesci a udire il lamento di un soldato alleato."};
        init(SELECT1,7,INSERT1,room7);

        String[] room8 = {"Intermezzo", "Intermezzo a est", "Continuando la tua missione, arrivi in una zona molto tranquilla, sembra quasi intatta.\nMentre controlli in giro, noti delle persone che sembrano venirti incontro.\nMan mano che si avvicinano c'e' qualcosa che non va.\nNon sono delle persone, ma un orda di zombie alieni."};
        init(SELECT1,8,INSERT1,room8);

        String[] room9 = {"Trincea", "Fine della trincea", "Dopo un'estenuante camminata, decidi di fermarti un attimo.\nTi guardi attorno e noti solo morte e distruzione.\nContinuando, ti salta addosso un alieno. Devi ucciderlo e portare a termine la tua missione."};
        init(SELECT1,9,INSERT1,room9);

        String[] room10 = {"In Amber Clad", "Riesci a salire all'interno dell'In Amber Clad, la nave principale responsabile della minaccia aliena.\n" + "Appena entrato noterai in lontananza il nucleo della nave.\n" + "Ti avvicini lentamente con la pistola in mano e piu' ti avvicini e piu' noti che il tuo corpo comincia a smaterializzarsi.\n" + "Sei ormai dinanzi al nucleo di te rimane poco e nulla cominci a sparare una raffica di colpi e il nucleo esplode.\n" + "Sai di aver sacrificato la tua vita ma tutto cio' per un bene superiore.\n" + "Nello stesso momento gli altri amari che stanno combattendo si fermano per guardare in lontananza la nave esplodere, sanno che il loro amico non c'e' piu' ma sono consapevoli del fatto che non e' stato un sacrificio vano.\n" + "Dopo aver eliminato gli ultimi soldati alieni rimasti a ritmo di Fortunate Son si incamminano sulla via del ritorno.", "S"};
        init(SELECT1,10,INSERT1,room10);

        //aggiunto gli oggetti
        String[] item1 = {"caffe", "Combustibile per un programmatore"};
        init(SELECT2, 1, INSERT2, item1);

        String[] item2 = {"pistola", "Utile per colpire un nemico anche a distanza non ravvicinata"};
        init(SELECT2, 2, INSERT2, item2);

        String[] item3 = {"piede_di_porco", "Utile per colpire un nemico corpo a corpo."};
        init(SELECT2, 3, INSERT2, item3);

        String[] item4 = {"granate", "Utile per uccidere gruppi di nemici"};
        init(SELECT2, 4, INSERT2, item4);

        String[] item5 = {"razionek", "Utile nel recuperare hp."};
        init(SELECT2, 5, INSERT2, item5);

        String[] item6 = {"Morso_del_demogorgone", "Cosi potente... cosi spaventoso!"};
        init(SELECT2, 6, INSERT2, item6);
   
    }


    /** 
     * funzione che effettua il controllo se una tabella contiene un oggetto o no
     * @param rs
     * @param id
     * @return toReturn
     * @throws SQLException
     */
    public boolean exists(ResultSet rs, int id) throws SQLException{
        boolean toReturn = false;
        while(rs.next()){
            if(rs.getInt(1) == id){
                toReturn = true;
            }
        }

        return toReturn;
    }
}
