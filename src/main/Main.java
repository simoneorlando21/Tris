import controller.TwoPlayersController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.FirstPageController;



public class Main extends Application {

    TwoPlayersController gameController;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage)  throws Exception{

        gameController = new TwoPlayersController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/firstPage.fxml"));
        Parent root = loader.load();
        FirstPageController controller = (FirstPageController) loader.getController();
        controller.setStage(stage);
        controller.getController(gameController);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
