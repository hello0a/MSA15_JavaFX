package application;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MainController {


	@FXML
	void main(Event event) throws Exception {
		try {
			Main.setRoot("Main");
		} catch (Exception e) {
			System.err.println("Main.fxml 파일이 없습니다.");
			e.printStackTrace();
		}
	}
	
	@FXML
	void login(Event event) throws Exception {
		try {
			Main.setRoot("Login");
		} catch (Exception e) {
			System.err.println("Login.fxml 파일이 없습니다.");
			e.printStackTrace();
		}
	}
	
    @FXML
    void join(Event event) {
    	try {
			Main.setRoot("Join");
			
		} catch (Exception e) {
			System.err.println("Join.fxml 파일이 없습니다.");
			e.printStackTrace();
		}
    }

    @FXML
    void menu(Event event) {
    	try {
			Main.setRoot("Menu");
		} catch (Exception e) {
			System.err.println("Menu.fxml 파일이 없습니다.");
			e.printStackTrace();
		}
    }
    @FXML
    void board(Event event) {
    	try {
			Main.setRoot("Board");
		} catch (Exception e) {
			System.err.println("Board.fxml 파일이 없습니다.");
			e.printStackTrace();
		}
    }

}
