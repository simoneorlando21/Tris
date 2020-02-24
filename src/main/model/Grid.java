package model;

import artificialIntelligence.Coordinates;

public class Grid {

    private Symbol[][] grid;

    public Grid() {
        this.grid = new Symbol[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++){
                this.grid[i][j] = Symbol.NULL;
            }
        }
    }

    public Symbol[][] getGrid() {
        return this.grid;
    }

    public void setSymbol(int x, int y, Symbol s)  {
            this.grid[x][y] = s;
    }

    public Symbol getSymbol(int x, int y) {
        return grid[x][y];
    }


    public boolean equals(Grid g) {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(this.getSymbol(i,j) != g.getSymbol(i,j))
                    return false;
            }
        }
        return true;
    }

    public Coordinates diff(Grid g) {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(this.getSymbol(i,j) != g.getSymbol(i,j))
                    return new Coordinates(i,j);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                str = str.concat("["+grid[i][j].toString()+"]");
            }
        }
        return str;
    }
}
