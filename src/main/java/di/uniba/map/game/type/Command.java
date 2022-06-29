package di.uniba.map.game.type;

import di.uniba.map.game.type.CommandType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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


    public CommandType getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public Set<String> getAlias() {
        return alias;
    }
    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));;
    }
}
