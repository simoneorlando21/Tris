package artificialIntelligence;

import controller.TwoPlayersController;
import model.Grid;
import model.Symbol;
import view.GamePlayPageController;

import java.util.ArrayList;


public class IAPlayer {

    private Tree gameTree;
    private Node state;
    private ArrayList<Node> coda = new ArrayList<>();
    public IAPlayer() {
        gameTree = new Tree();
        assignMinimaxValue(gameTree.getRoot());
        propagateMinimaxValue(gameTree.getRoot());
        //DEBUG
        //coda.add(gameTree.getRoot());
        //while (coda.size() != 0)
          //exploreTree();
        state = gameTree.getRoot();
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void doAction(GamePlayPageController gamePlayPageController, TwoPlayersController controller) {
        if(controller.checkEndGame() == -1)
            return;
        for (Node n: state.getSons()) {
            if(n.getGrid().equals(controller.getGameGrid()))
                state = n;
        }
        int max = -9999;
        Node nodeMax = new Node();
        for (Node n: state.getSons()) {
            if(n.getMinimaxValue() > max) {
                max = n.getMinimaxValue();
                nodeMax = n;
            }
        }

        Coordinates iaAction = state.getGrid().diff(nodeMax.getGrid());
        Node clone = state.clone();
        clone.getGrid().setSymbol(iaAction.getX(),iaAction.getY(),Symbol.O);
        for(Node n: state.getSons()) {
            if(n.getGrid().equals(clone.getGrid()))
                state = n;
        }
        if(iaAction.getX() == 0 && iaAction.getY() == 0) {
            gamePlayPageController.doAction00();
        }
        if(iaAction.getX() == 0 && iaAction.getY() == 1) {
            gamePlayPageController.doAction01();
        }
        if(iaAction.getX() == 0 && iaAction.getY() == 2) {
            gamePlayPageController.doAction02();
        }
        if(iaAction.getX() == 1 && iaAction.getY() == 0) {
            gamePlayPageController.doAction10();
        }
        if(iaAction.getX() == 1 && iaAction.getY() == 1) {
            gamePlayPageController.doAction11();
        }
        if(iaAction.getX() == 1 && iaAction.getY() == 2) {
            gamePlayPageController.doAction12();
        }
        if(iaAction.getX() == 2 && iaAction.getY() == 0) {
            gamePlayPageController.doAction20();
        }
        if(iaAction.getX() == 2 && iaAction.getY() == 1) {
            gamePlayPageController.doAction21();
        }
        if(iaAction.getX() == 2 && iaAction.getY() == 2) {
            gamePlayPageController.doAction22();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void exploreTree() {
        System.out.print(coda.get(0) + "  --> Minimax: "+ coda.get(0).getMinimaxValue());
        if(coda.get(0).getSons().size() == 0)
            System.out.print("        {T}\n");
        else
            System.out.print("\n");
        for (Node n : coda.get(0).getSons()) {
            coda.add(n);
        }
        coda.remove(0);
    }
    private void propagateMinimaxValue(Node node) {

        if(node.getSons().size() != 0) {
            for (Node n : node.getSons()) {
                if (n.getMinimaxValue() == 9999)
                    propagateMinimaxValue(n);
            }
        }
        else {
            return;
        }

        if(node.getPlayerTurn() == PlayerTurn.MAX) {
            int max = -10000;
            for (Node n: node.getSons()) {
                if (n.getMinimaxValue() > max) {
                    max = n.getMinimaxValue();
                }
            }
            node.setMinimaxValue(max);
        }
        else {
            int min = 10000;
            for (Node n : node.getSons()) {
                if(n.getMinimaxValue() < min) {
                    min = n.getMinimaxValue();
                }

            }
            node.setMinimaxValue(min);
        }
    }
    private void assignMinimaxValue(Node node) {
        if(node.getSons().size() == 0) {
            if(checkEndGame(node.getGrid()) == -1) {
                node.setMinimaxValue(0);
            }
            else if(node.getPlayerTurn() == PlayerTurn.MAX && checkEndGame(node.getGrid()) == 1) {
                node.setMinimaxValue(-1);
            }
            else if(node.getPlayerTurn() == PlayerTurn.MIN && checkEndGame(node.getGrid()) == 1){
                node.setMinimaxValue(1);
            }
            return;
        }
        for (Node n: node.getSons()) {
            assignMinimaxValue(n);
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
