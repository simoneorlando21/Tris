package artificialIntelligence;

import model.Grid;
import model.Symbol;

public class Tree {

    private Node root;

    public Tree() {
        root = new Node();
        root.setPlayerTurn(PlayerTurn.MIN);
        generateTree(root, Symbol.X);
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    private void generateTree(Node node, Symbol s) {

        if(checkEndGame(node.getGrid()) == 1)
            return;
        if(checkEndGame(node.getGrid()) == -1)
            return;

        for (Coordinates c: node.getPossibleMoves()) {
            Node n = node.clone();
            n.getGrid().setSymbol(c.getX(),c.getY(), s);
            n.setFather(node);
            if (s == Symbol.X)
                n.setPlayerTurn(PlayerTurn.MAX);
            else
                n.setPlayerTurn(PlayerTurn.MIN);
            node.getSons().add(n);
        }

        for (Node son: node.getSons()) {
            if (s == Symbol.X)
                generateTree(son, Symbol.O);
            else
                generateTree(son, Symbol.X);
        }

    }


    private int checkEndGame(Grid gameGrid) {
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

