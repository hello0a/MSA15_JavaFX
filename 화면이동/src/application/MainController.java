package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {


    @FXML
    void toA(ActionEvent event) {
    	StageManager.show("A");
    }

    @FXML
    void toB(ActionEvent event) {
    	StageManager.switchScene("B");
    }

    @FXML
    void exit(ActionEvent event) {
//    	StageManager.getStage().close();
    	Platform.exit();
    }
}
