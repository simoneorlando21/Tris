package view;


import controller.TwoPlayersController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirstPageController {

    Stage stage;
    TwoPlayersController gameController;

    public FirstPageController() {
    }

    public void getController(TwoPlayersController controller) {
        this.gameController = controller;
    }


    public void setStage(Stage stage){
        this.stage = stage;
    }
    public void singlePlayerClick() throws Exception {
        gameController.setTypeOfGame(1);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/playerNamesPage.fxml"));
        Parent root = loader.load();
        PlayerNamesPageController controller = (PlayerNamesPageController) loader.getController();
        controller.setStage(stage);
        controller.getController(gameController);
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }

    public void multiPlayerClick() throws Exception {
        gameController.setTypeOfGame(2);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/playerNamesPage.fxml"));
        Parent root = loader.load();
        PlayerNamesPageController controller = (PlayerNamesPageController) loader.getController();
        controller.setStage(stage);
        controller.getController(gameController);
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
