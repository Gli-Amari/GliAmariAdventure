package di.uniba.map.game.databases;

public class Db {
    
    /**
     * query di creazione
     */
    public static final String CREATE_ROOM = "CREATE TABLE IF NOT EXISTS room (id int PRIMARY KEY, name VARCHAR(100), desc VARCHAR(100), look VARCHAR(1000), descReturn VARCHAR(1000))";
    public static final String CREATE_ITEM = "CREATE TABLE IF NOT EXISTS item (id int PRIMARY KEY, name VARCHAR(100), desc VARCHAR(100))";
    public static final String CREATE_NPC = "CREATE TABLE IF NOT EXISTS npc (id int PRIMARY KEY AUTOINCREMENT, hp int, name VARCHAR(100), desc VARCHAR(100))";

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
}
