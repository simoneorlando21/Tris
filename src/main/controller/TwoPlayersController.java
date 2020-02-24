package controller;

import model.Grid;
import model.Player;
import model.Symbol;



public class TwoPlayersController {

    private Player[] players;
    private Player currentPlayer;
    private Grid gameGrid;
    private boolean isEnded;
    private int typeOfGame;


    public TwoPlayersController() {
        gameGrid = new Grid();
        isEnded = false;
        players = new Player[2];
    }

    public int getTypeOfGame() {
        return typeOfGame;
    }

    public void setTypeOfGame(int type) {
        typeOfGame = type;
    }

    public void setPlayers(String namePlayer1, String namePlayer2) {
        players[0] = new Player(namePlayer1, Symbol.X);
        players[1] = new Player(namePlayer2, Symbol.O);
        currentPlayer = players[0];
    }


    public Player getCurrentPlayerName() {
        return currentPlayer;
    }

    public void doAction(int x, int y) {
        gameGrid.setSymbol(x, y, currentPlayer.getPlayerSymbol());
    }

    public Grid getGameGrid() {
        return gameGrid;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setCurrentPlayer() {
        if (currentPlayer.getPlayerName().equals(players[0].getPlayerName())){
            currentPlayer = players[1];
        }
        else {
            currentPlayer = players[0];
        }
    }
    public String getWinner() {
        if(currentPlayer.getPlayerName() == players[0].getPlayerName())
            return players[1].getPlayerName();
        else
            return players[0].getPlayerName();
    }

    public int checkEndGame() {
        if ( (gameGrid.getSymbol(0,0) == gameGrid.getSymbol(0,1)) && (gameGrid.getSymbol(0,1) == gameGrid.getSymbol(0,2)) &&
                (gameGrid.getSymbol(0,0) != Symbol.NULL) && (gameGrid.getSymbol(0,1) != Symbol.NULL)  && (gameGrid.getSymbol(0,2) != Symbol.NULL))
            return 1;
        if ( (gameGrid.getSymbol(1,0) == gameGrid.getSymbol(1,1)) && (gameGrid.getSymbol(1,1) == gameGrid.getSymbol(1,2)) &&
                (gameGrid.getSymbol(1,0) != Symbol.NULL) && (gameGrid.getSymbol(1,1) != Symbol.NULL)  && (gameGrid.getSymbol(1,2) != Symbol.NULL))
            return 1;
        if ( (gameGrid.getSymbol(2,0) == gameGrid.getSymbol(2,1)) && (gameGrid.getSymbol(2,1) == gameGrid.getSymbol(2,2)) &&
                (gameGrid.getSymbol(2,0) != Symbol.NULL) && (gameGrid.getSymbol(2,1) != Symbol.NULL)  && (gameGrid.getSymbol(2,2) != Symbol.NULL))
            return 1;


        if ( (gameGrid.getSymbol(0,0) == gameGrid.getSymbol(1,0)) && (gameGrid.getSymbol(1,0) == gameGrid.getSymbol(2,0)) &&
                (gameGrid.getSymbol(0,0) != Symbol.NULL) && (gameGrid.getSymbol(1,0) != Symbol.NULL)  && (gameGrid.getSymbol(2,0) != Symbol.NULL))
            return 1;
        if ( (gameGrid.getSymbol(0,1) == gameGrid.getSymbol(1,1)) && (gameGrid.getSymbol(1,1) == gameGrid.getSymbol(2,1)) &&
                (gameGrid.getSymbol(0,1) != Symbol.NULL) && (gameGrid.getSymbol(1,1) != Symbol.NULL)  && (gameGrid.getSymbol(2,1) != Symbol.NULL))
            return 1;
        if ( (gameGrid.getSymbol(0,2) == gameGrid.getSymbol(1,2)) && (gameGrid.getSymbol(1,2) == gameGrid.getSymbol(2,2)) &&
                (gameGrid.getSymbol(0,2) != Symbol.NULL) && (gameGrid.getSymbol(1,2) != Symbol.NULL)  && (gameGrid.getSymbol(2,2) != Symbol.NULL))
            return 1;


        if ( (gameGrid.getSymbol(0,0) == gameGrid.getSymbol(1,1)) && (gameGrid.getSymbol(1,1) == gameGrid.getSymbol(2,2)) &&
                (gameGrid.getSymbol(0,0) != Symbol.NULL) && (gameGrid.getSymbol(1,1) != Symbol.NULL)  && (gameGrid.getSymbol(2,2) != Symbol.NULL))
            return 1;
        if ( (gameGrid.getSymbol(2,0) == gameGrid.getSymbol(1,1)) && (gameGrid.getSymbol(1,1) == gameGrid.getSymbol(0,2)) &&
                (gameGrid.getSymbol(2,0) != Symbol.NULL) && (gameGrid.getSymbol(1,1) != Symbol.NULL)  && (gameGrid.getSymbol(0,2) != Symbol.NULL))
            return 1;

        boolean freeGrid = false;
        for (int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (gameGrid.getSymbol(i,j) == Symbol.NULL) {
                    freeGrid = true;
                    break;
                }
            }
        }
        if (freeGrid)
            return 0;

        return -1;
    }
}
