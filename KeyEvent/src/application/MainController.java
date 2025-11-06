package application;

import javafx.event.ActionEvent;
//import javafx.event.Event;
//import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;

public class MainController {

    @FXML private Circle circle;
    @FXML private Button down;
    @FXML private Button left;
    @FXML private Button right;
    @FXML private Button up;
    
    // Circle의 x, y 좌표
    double x, y;
    
    /**
     * FXML 이 로딩될 때 초기화하는 메서드
     * * 데이터 초기화
     * * 이벤트 등록
     */
    @FXML
    public void initialize() {
    	if( circle != null) {
    		x = circle.getCenterX();
    		y = circle.getCenterY();
    	}
    }

    @FXML
    void up(ActionEvent event) {
    	System.out.println("UP");
    	y -= 10;
    	circle.setCenterY(y);
    }
    @FXML
    void down(ActionEvent event) {
    	System.out.println("DOWN");
    	y += 10;
    	circle.setCenterY(y);
    }

    @FXML
    void left(ActionEvent event) {
    	System.out.println("LEFT");
    	x -= 10;
    	circle.setCenterX(x);

    }

    @FXML
    void right(ActionEvent event) {
    	System.out.println("RIGHT");
    	x += 10;
    	circle.setCenterX(x);

    }
    
    /**
     * 방향키 키 입력 이벤트
     */
    void keyEvent() {
    	Scene scene = Main.scene;
    	if (scene != null) {
    		// 키입력 이벤트 등록
    		// Event (익명) : UI 이벤트 처리 , 스레드 -> 알로하 찾아봐!
    		scene.setOnKeyPressed( event -> {
    			KeyCode keyCode = event.getCode();
    			switch (keyCode) {
				case UP:	circle.setCenterY( y-= 10 ); break;
				case DOWN:	circle.setCenterY( y+= 10 ); break;
				case LEFT:	circle.setCenterX( x-= 10 ); break;
				case RIGHT:	circle.setCenterX( x+= 10 ); break;
				}
			});
    	}
    }


}
