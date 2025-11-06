package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class BController {

    @FXML
    private TextField input;

    @FXML
    void to(ActionEvent event) throws IOException{
    	
    	
    }
    // 데이터 전달을 위한 메서드
    public void setData(String data) {
    	input.setText(data);
    }

}
