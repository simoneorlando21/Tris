package view;

import controller.TwoPlayersController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerNamesPageController {

    Stage stage;
    TwoPlayersController gameController;

    @FXML
    TextField firstPlayerName;
    @FXML
    TextField secondPlayerName;


    public void getController(TwoPlayersController controller) {
        this.gameController = controller;
        if (controller.getTypeOfGame() == 1) {
            secondPlayerName.appendText("  Artificial Intelligence");
            secondPlayerName.setDisable(true);
        }
    }


    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void sendNames() throws Exception{
        String firstName = firstPlayerName.getText();
        String secondName;
        if (gameController.getTypeOfGame() == 1)
            secondName = "AI";
        else
            secondName = secondPlayerName.getText();
        gameController.setPlayers(firstName, secondName);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/gamePlayPage.fxml"));
        Parent root = loader.load();
        GamePlayPageController controller = (GamePlayPageController) loader.getController();
        controller.setStage(stage);
        controller.getController(gameController);
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
