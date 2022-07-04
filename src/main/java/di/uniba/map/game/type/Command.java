package di.uniba.map.game.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Giulio Russo 
 * Vengono definiti i comandi di gioco.
 */

public class Command {

    private final CommandType type;

    private final String name;

    private Set<String> alias;

    public Command(CommandType type, String name) {
        this.type = type;
        this.name = name;
    }

    public Command(CommandType type, String name, Set<String> alias) {
        this.type = type;
        this.name = name;
        this.alias = alias;
    }


    /** 
     * @return CommandType
     */

    public CommandType getType() {
        return type;
    }
    
    /** 
     * @return String
     */
    
    public String getName() {
        return name;
    }

    /** 
     * @return Set<String>
     */
    
    public Set<String> getAlias() {
        return alias;
    }
    
    /** 
     * @param alias
     */
    
    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));;
    }
}
