package artificialIntelligence;

import model.Grid;
import model.Symbol;

import java.util.ArrayList;

public class Node {
    private Grid grid;
    private int minimaxValue = 9999;
    private Node father;
    private ArrayList<Node> sons;
    private PlayerTurn playerTurn;

    public Node() {
        grid = new Grid();
        father = null;
        sons = new ArrayList<>();
    }

    public PlayerTurn getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(PlayerTurn playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getFather() {
        return father;
    }

    public int getMinimaxValue() {
        return minimaxValue;
    }

    public void setMinimaxValue(int value) {
        minimaxValue = value;
    }

    public ArrayList<Node> getSons() {
        return sons;
    }

    public ArrayList<Coordinates> getPossibleMoves() {
        ArrayList<Coordinates> list = new ArrayList<>();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (grid.getSymbol(i,j) == Symbol.NULL) {
                    list.add(new Coordinates(i,j));
                }
            }
        }
        return list;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                str = str.concat("["+grid.getSymbol(i,j).toString()+"]");
            }
        }
        return str;
    }

    public Node clone() {
        Node clone = new Node();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                clone.getGrid().setSymbol(i,j,grid.getSymbol(i,j));
            }
        }
        return clone;
    }
}
