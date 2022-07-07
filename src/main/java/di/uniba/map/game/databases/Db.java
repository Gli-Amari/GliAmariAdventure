package di.uniba.map.game.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Db {
    
    /**
     * query di creazione
     */
    public static final String CREATE_ROOM = "CREATE TABLE IF NOT EXISTS room (id int PRIMARY KEY, name VARCHAR(100), desc VARCHAR(100), look VARCHAR(1000), descReturn VARCHAR(1000))";
    public static final String CREATE_ITEM = "CREATE TABLE IF NOT EXISTS item (id int PRIMARY KEY, name VARCHAR(100), desc VARCHAR(100))";
    public static final String CREATE_NPC = "CREATE TABLE IF NOT EXISTS npc (id int PRIMARY KEY, hp int, name VARCHAR(100), desc VARCHAR(100))";

    /**
     * query di ricerca basate sugli id delle tabelle
     */
    public static final String SELECT1 = "SELECT id FROM room WHERE id = ?";
    public static final String SELECT2 = "SELECT id FROM item WHERE id = ?";
    public static final String SELECT3 = "SELECT id FROM npc WHERE id = ?";

    /**
     * query di popolazione delle tabelle
     */
    public static final String INSERT1 = "INSERT INTO room VALUES (?, ?, ?, ?, ?)";
    public static final String INSERT2 = "INSERT INTO item VALUES (?, ?, ?, ?, ?)";
    public static final String INSERT3 = "INSERT INTO npc VALUES (?, ?, ?, ?, ?)";

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
     * metodo per creare e leggere i dati presenti nelle tabelle
     * @param select
     * @param idStatement
     * @return ResultSet
     * @throws SQLException
     */
    public static ResultSet readFromDb(String select, int idStatement) throws SQLException{
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

    public void insertStringIntoTheTable(int id, String insert, String[] array) throws SQLException{

        PreparedStatement pstm = getConnection().prepareStatement(insert);

        if(array.length==4) { //per le stanze
            pstm.setInt(1, id);
            pstm.setString(2, array[0]);
            pstm.setString(3, array[1]);
            pstm.setString(4, array[2]);
            pstm.setString(5,array[3]);

            pstm.executeUpdate();
        } else if(array.length==2){ //per gli oggetti
            pstm.setInt(1,id);
            pstm.setString(2,array[0]);
            pstm.setString(3,array[1]);

            pstm.executeUpdate();
        } else if(array.length==3){ //per gli npc
            pstm.setInt(1,id);
            pstm.setInt(2,Integer.parseInt(array[0]));
            pstm.setString(3,array[1]);
            pstm.setString(4,array[2]);
            
            pstm.executeUpdate();
        } else{
            System.out.println("Errore su insertStringIntoTheTable" + id);
        }

        pstm.close();
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

    
    /** 
     * metodo getter per la connessione al db
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        return c;
    }


}
