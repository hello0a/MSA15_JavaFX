package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML private Button btnExit;
    @FXML private Button btnList;

    /**
     * 종료하기
     * @param event
     */
    @FXML
    void exit(ActionEvent event) {

    }

    /**
     * 게시글 목록으로 이동하기
     * @param event
     * @throws Exception 
     */
    @FXML
    void toList(ActionEvent event) throws Exception {
    	Main.setRoot("List");
    }

}
