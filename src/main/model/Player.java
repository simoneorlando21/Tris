package model;

public class Player {

    private String name;
    private Symbol symbol;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return name;
    }

    public Symbol getPlayerSymbol() {
        return symbol;
    }

    public boolean equals(Player p) {
        if (!this.getPlayerName().equals(p.getPlayerName()))
            return false;
        return true;
    }

}
