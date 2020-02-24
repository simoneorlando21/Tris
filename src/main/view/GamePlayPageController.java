package view;

import artificialIntelligence.IAPlayer;
import controller.TwoPlayersController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Player;
import model.Symbol;

public class GamePlayPageController {

    Stage stage;
    TwoPlayersController gameController;
    Player currentPlayer;

    @FXML
    ImageView imgO00;
    @FXML
    ImageView imgX00;
    @FXML
    ImageView imgO01;
    @FXML
    ImageView imgX01;
    @FXML
    ImageView imgO02;
    @FXML
    ImageView imgX02;
    @FXML
    ImageView imgO10;
    @FXML
    ImageView imgX10;
    @FXML
    ImageView imgO11;
    @FXML
    ImageView imgX11;
    @FXML
    ImageView imgO12;
    @FXML
    ImageView imgX12;
    @FXML
    ImageView imgO20;
    @FXML
    ImageView imgX20;
    @FXML
    ImageView imgO21;
    @FXML
    ImageView imgX21;
    @FXML
    ImageView imgO22;
    @FXML
    ImageView imgX22;
    @FXML
    Button button00;
    @FXML
    Button button01;
    @FXML
    Button button02;
    @FXML
    Button button10;
    @FXML
    Button button11;
    @FXML
    Button button12;
    @FXML
    Button button20;
    @FXML
    Button button21;
    @FXML
    Button button22;
    @FXML
    Label currentPlayerLabel;

    IAPlayer iaPlayer;

    public void getController(TwoPlayersController controller) {
        this.gameController = controller;
        currentPlayer = gameController.getCurrentPlayerName();
        currentPlayerLabel.setText("Turn: " + currentPlayer.getPlayerName());
        iaPlayer = new IAPlayer();
    }


    public void setStage(Stage stage){
        this.stage = stage;
    }

    private void disableAllButton() {
        button00.setDisable(true);
        button01.setDisable(true);
        button02.setDisable(true);
        button10.setDisable(true);
        button11.setDisable(true);
        button12.setDisable(true);
        button20.setDisable(true);
        button21.setDisable(true);
        button22.setDisable(true);
    }

    public void doAction00() {
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.doAction(0,0);
        if (currentPlayer.getPlayerSymbol() == Symbol.O)
            imgO00.setVisible(true);
        else
            imgX00.setVisible(true);
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.setCurrentPlayer();
        if(gameController.checkEndGame() == 1) {
            disableAllButton();
            currentPlayerLabel.setText("Winner: " + gameController.getWinner() + "!");
        }
        else if (gameController.checkEndGame() == -1)
            currentPlayerLabel.setText("     No winner");
        else if(gameController.checkEndGame() == 0)
            currentPlayerLabel.setText("Turn: " + gameController.getCurrentPlayerName().getPlayerName());
        button00.setDisable(true);
        if (gameController.getTypeOfGame() == 1 && gameController.getCurrentPlayerName().getPlayerName().equals("AI"))
            iaPlayer.doAction(this, gameController);
    }

    public void doAction01() {
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.doAction(0,1);
        if (currentPlayer.getPlayerSymbol() == Symbol.O)
            imgO01.setVisible(true);
        else
            imgX01.setVisible(true);
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.setCurrentPlayer();
        if(gameController.checkEndGame() == 1) {
            disableAllButton();
            currentPlayerLabel.setText("Winner: " + gameController.getWinner() + "!");
        }
        else if (gameController.checkEndGame() == -1)
            currentPlayerLabel.setText("     No winner");
        else
            currentPlayerLabel.setText("Turn: " + gameController.getCurrentPlayerName().getPlayerName());
        button01.setDisable(true);
        if (gameController.getTypeOfGame() == 1 && gameController.getCurrentPlayerName().getPlayerName().equals("AI"))
            iaPlayer.doAction(this, gameController);
    }
    public void doAction02() {
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.doAction(0,2);
        if (currentPlayer.getPlayerSymbol() == Symbol.O)
            imgO02.setVisible(true);
        else
            imgX02.setVisible(true);
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.setCurrentPlayer();
        if(gameController.checkEndGame() == 1) {
            disableAllButton();
            currentPlayerLabel.setText("Winner: " + gameController.getWinner() + "!");
        }
        else if (gameController.checkEndGame() == -1)
            currentPlayerLabel.setText("     No winner");
        else
            currentPlayerLabel.setText("Turn: " + gameController.getCurrentPlayerName().getPlayerName());
        button02.setDisable(true);
        if (gameController.getTypeOfGame() == 1 && gameController.getCurrentPlayerName().getPlayerName().equals("AI"))
            iaPlayer.doAction(this, gameController);
    }
    public void doAction10() {
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.doAction(1,0);
        if (currentPlayer.getPlayerSymbol() == Symbol.O)
            imgO10.setVisible(true);
        else
            imgX10.setVisible(true);
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.setCurrentPlayer();
        if(gameController.checkEndGame() == 1) {
            disableAllButton();
            currentPlayerLabel.setText("Winner: " + gameController.getWinner() + "!");
        }
        else if (gameController.checkEndGame() == -1)
            currentPlayerLabel.setText("     No winner");
        else
            currentPlayerLabel.setText("Turn: " + gameController.getCurrentPlayerName().getPlayerName());
        button10.setDisable(true);
        if (gameController.getTypeOfGame() == 1 && gameController.getCurrentPlayerName().getPlayerName().equals("AI"))
            iaPlayer.doAction(this, gameController);
    }
    public void doAction11() {
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.doAction(1,1);
        if (currentPlayer.getPlayerSymbol() == Symbol.O)
            imgO11.setVisible(true);
        else
            imgX11.setVisible(true);
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.setCurrentPlayer();
        if(gameController.checkEndGame() == 1) {
            disableAllButton();
            currentPlayerLabel.setText("Winner: " + gameController.getWinner() + "!");
        }
        else if (gameController.checkEndGame() == -1)
            currentPlayerLabel.setText("     No winner");
        else
            currentPlayerLabel.setText("Turn: " + gameController.getCurrentPlayerName().getPlayerName());
        button11.setDisable(true);
        if (gameController.getTypeOfGame() == 1 && gameController.getCurrentPlayerName().getPlayerName().equals("AI"))
            iaPlayer.doAction(this, gameController);
    }
    public void doAction12() {
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.doAction(1,2);
        if (currentPlayer.getPlayerSymbol() == Symbol.O)
            imgO12.setVisible(true);
        else
            imgX12.setVisible(true);
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.setCurrentPlayer();
        if(gameController.checkEndGame() == 1) {
            disableAllButton();
            currentPlayerLabel.setText("Winner: " + gameController.getWinner() + "!");
        }
        else if (gameController.checkEndGame() == -1)
            currentPlayerLabel.setText("     No winner");
        else
            currentPlayerLabel.setText("Turn: " + gameController.getCurrentPlayerName().getPlayerName());
        button12.setDisable(true);
        if (gameController.getTypeOfGame() == 1 && gameController.getCurrentPlayerName().getPlayerName().equals("AI"))
            iaPlayer.doAction(this, gameController);
    }
    public void doAction20() {
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.doAction(2,0);
        if (currentPlayer.getPlayerSymbol() == Symbol.O)
            imgO20.setVisible(true);
        else
            imgX20.setVisible(true);
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.setCurrentPlayer();
        if(gameController.checkEndGame() == 1) {
            disableAllButton();
            currentPlayerLabel.setText("Winner: " + gameController.getWinner() + "!");
        }
        else if (gameController.checkEndGame() == -1)
            currentPlayerLabel.setText("     No winner");
        else
            currentPlayerLabel.setText("Turn: " + gameController.getCurrentPlayerName().getPlayerName());
        button20.setDisable(true);
        if (gameController.getTypeOfGame() == 1 && gameController.getCurrentPlayerName().getPlayerName().equals("AI"))
            iaPlayer.doAction(this, gameController);
    }
    public void doAction21() {
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.doAction(2,1);
        if (currentPlayer.getPlayerSymbol() == Symbol.O)
            imgO21.setVisible(true);
        else
            imgX21.setVisible(true);
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.setCurrentPlayer();
        if(gameController.checkEndGame() == 1) {
            disableAllButton();
            currentPlayerLabel.setText("Winner: " + gameController.getWinner() + "!");
        }
        else if (gameController.checkEndGame() == -1)
            currentPlayerLabel.setText("     No winner");
        else
            currentPlayerLabel.setText("Turn: " + gameController.getCurrentPlayerName().getPlayerName());
        button21.setDisable(true);
        if (gameController.getTypeOfGame() == 1 && gameController.getCurrentPlayerName().getPlayerName().equals("AI"))
            iaPlayer.doAction(this, gameController);
    }
    public void doAction22() {
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.doAction(2,2);
        if (currentPlayer.getPlayerSymbol() == Symbol.O)
            imgO22.setVisible(true);
        else
            imgX22.setVisible(true);
        currentPlayer = gameController.getCurrentPlayerName();
        gameController.setCurrentPlayer();
        if(gameController.checkEndGame() == 1) {
            disableAllButton();
            currentPlayerLabel.setText("Winner: " + gameController.getWinner() + "!");
        }
        else if (gameController.checkEndGame() == -1)
            currentPlayerLabel.setText("     No winner");
        else
            currentPlayerLabel.setText("Turn: " + gameController.getCurrentPlayerName().getPlayerName());
        button22.setDisable(true);
        if (gameController.getTypeOfGame() == 1 && gameController.getCurrentPlayerName().getPlayerName().equals("AI"))
            iaPlayer.doAction(this, gameController);
    }
}
