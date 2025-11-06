package application;

import javafx.scene.input.MouseEvent;
import java.util.Arrays;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    
    // 초기 데이터
    List<String> initList = Arrays.asList(
    		"피카츄", "라이츄", "파이리", "꼬부기", "버터풀", "마동나", "리자묭", "동까수"
    );
    
    
    @FXML
    public void initialize() {
    	// 데이터 초기화
    	listView.getItems().addAll(initList);
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
    	
    	 // 리스트뷰의 더블 클릭 이벤트
    	listView.setOnMouseClicked( new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// 더블 클릭
				if( event.getClickCount() == 2) {
					System.out.println("더블 클릭");
					selectedItem = listView.getSelectionModel().getSelectedItem();
					System.out.println("선택된 아이템 : " + selectedItem);
					
					// 상테 화면으로 이동...
					
				}
				
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
    	System.out.println("삭제");
    	if( selectedItem == null || selectedItem.isEmpty() ) {
    		System.err.println("선택한 항목이 없습니다.");
    		return;
    	}
    	listView.getItems().remove( selectedItem );
    	selectedItem = null;
    	item.setText("");
    	
    	// 선택 해제
    	listView.getSelectionModel().clearSelection();
    }

}
