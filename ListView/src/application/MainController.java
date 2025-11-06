package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {

	@FXML private Label item;
    @FXML private Button add;
    @FXML private Button delete;
    @FXML private TextField input;
    
    @FXML private ListView<String> listView;
    
    // 현재 선택한 아이템
    String selectedItem;
    
    @FXML
    public void initialize() {
    	
    	// 리스트뷰 항목 선택 이벤트
    	listView.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<String>() {

    		// 선택한 항목이 변경됬을때 실행되는 메서드
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// 선택한 항목을 지정
				selectedItem = listView.getSelectionModel().getSelectedItem();
				// 라벨에 지정
				item.setText( selectedItem );
			}
		});
    }

    @FXML
    void add(ActionEvent event) {
    	System.out.println("추가!");
    	String text = input.getText();
    	if( text != null && !text.isEmpty()) {
    		// 리스트뷰에 추가
    		listView.getItems().add(text);
    		// 입력 후 텍스트 필드 비우기
    		input.clear();
    	}
    }

    @FXML
    void delete(ActionEvent event) {

    }

}
