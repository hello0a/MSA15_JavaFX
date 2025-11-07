package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AController {

    @FXML
    private TextField input;

    @FXML
    void to(ActionEvent event) throws IOException{
    	// FXML 로드
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("B.fxml"));
    	Parent root = loader.load();
    	
    	// 컨트롤러 가져오기
    	BController bController = loader.getController();
    	bController.setData( input.getText() );
    	
    	// 화면 이동
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.setScene(new Scene(root));
    	stage.show();
    }

	@FXML 
	public void toC() {
		String data = input.getText();
		StageManager.show("C", data);
	}


}
