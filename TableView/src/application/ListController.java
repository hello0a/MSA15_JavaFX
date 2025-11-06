package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.beans.value.ObservableBooleanValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListController {

    @FXML private TableColumn<?, ?> colNo;
    @FXML private TableColumn<?, ?> colTitle;
    @FXML private TableColumn<?, ?> colWriter;
    @FXML private TableColumn<?, ?> colCreatedAt;
    @FXML private Button btnMain;
    @FXML private Button btnCreate;

    @FXML private TableView<Board> tableView;
    List<Board> boardList = null;
    
    // 흐름 : 컬렉션 생성 -> 매핑 -> 자바FX에 맞는 컬렉션으로 변환
    @FXML
    void initialize() {
    	// 테이블 뷰에 데이터 초기화
    	boardList = new ArrayList<Board>();
    	boardList.add( new Board(1, "제목1", "작성자1", "내용1", new Date() ) );
    	boardList.add( new Board(2, "제목2", "작성자2", "내용2", new Date() ) );
    	boardList.add( new Board(3, "제목3", "작성자3", "내용3", new Date() ) );
    	
    	colNo.setCellValueFactory( new PropertyValueFactory<>("No"));		// colNo <-- no 매핑
    	colTitle.setCellValueFactory( new PropertyValueFactory<>("Title"));
    	colWriter.setCellValueFactory( new PropertyValueFactory<>("Writer"));
    	colCreatedAt.setCellValueFactory( new PropertyValueFactory<>("CreatedAt"));
    	
    	// 테이블뷰에 데이터 추가하기
    	// ObservableList <-- ArrayList 변환
    	ObservableList<Board> list = FXCollections.observableArrayList(boardList);
    	// 테이블뷰(JavaFX)에 컬렉션을 등록할 때는 FXCollections 으로 지정해야 한다.
    	tableView.setItems(list);
    }
    @FXML
    void toCreate(ActionEvent event) {

    }

    @FXML
    void toMain(ActionEvent event) throws Exception {
    	Main.setRoot("Main");
    }

}
