package di.uniba.map.game.story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Db {

    /**
     *  query di crezione
     */
    private static String CREATE_TABLE_stanza = "CREATE TABLE IF NOT EXISTS Stanza ( id INTEGER PRIMARY KEY, nomeStanza TEXT, descrizione TEXT, prospettiva TEXT )";
    private static String CREATE_TABLE_oggetti = "CREATE TABLE IF NOT EXISTS Oggetti ( id INTEGER PRIMARY KEY, nomeOggetto TEXT, descrizione TEXT )";
    String CREATE_TABLE_npc = "CREATE TABLE IF NOT EXISTS Npc ( id INTEGER PRIMARY KEY, nomeNpc TEXT, descrizione TEXT )";

    public void population_tables() throws SQLException{
        try {
            Properties dbprops = new Properties();
            dbprops.setProperty("user", "user");
            dbprops.setProperty("password", "user");
            try (Connection conn = DriverManager.getConnection("jdbc:h2:./resource/database/dbAmari", dbprops)) {
                Statement stm_stanza = conn.createStatement();
                stm_stanza.executeUpdate(CREATE_TABLE_stanza);
                stm_stanza.close();       

                Statement stm_oggetti = conn.createStatement();
                stm_oggetti.executeUpdate(CREATE_TABLE_oggetti);
                stm_oggetti.close(); 

                Statement stm_npc = conn.createStatement();
                stm_npc.executeUpdate(CREATE_TABLE_npc);
                stm_npc.close(); 
                        
                conn.close();
            }                 
        }catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
    }

   public ResultSet executeQueryInStory(String q, int id){
        String stringa = new String();

        try {
            Properties dbprops = new Properties();
            dbprops.setProperty("user", "user");
            dbprops.setProperty("password", "user");
            try (Connection conn = DriverManager.getConnection("jdbc:h2:./resource/database/dbAmari", dbprops)) {
                PreparedStatement stm = conn.prepareStatement(q);
                stm.setInt(1, id);
                ResultSet rs = stm.executeQuery();
                
                rs.close();
                stm.close();

                return rs;
            }
        }catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
            return null;
        }
   }
}
