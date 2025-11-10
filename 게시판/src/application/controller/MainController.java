package application.controller;

import java.util.List;

import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import application.util.StageManager;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MainController {

	@FXML private TableView<Board> tableView;
	
	@FXML CheckBox checkBox;
    @FXML private TableColumn<Board, CheckBox> colCheck;
    @FXML private TableColumn<Board, Integer> colNo;
    @FXML private TableColumn<Board, String> colTitle;
    @FXML private TableColumn<Board, String> colWriter;
    @FXML private TableColumn<Board, String> colCreatedAt;
    @FXML private TableColumn<Board, String> colUpdatedAt;
    

    // 게시글 목록 데이터
    List<Board> boardList = null;
    BoardService boardService = new BoardServiceImpl();
    
    // 데이터 초기화
    @FXML
    void initialize () {
    	// 게시글 목록 요청
    	boardList = boardService.list();
    	//TableColumn 에 Board 객체 매핑하기
    	colCheck.setCellValueFactory( new PropertyValueFactory<>("check") );
    	colNo.setCellValueFactory( new PropertyValueFactory<>("no") );
    	colTitle.setCellValueFactory( new PropertyValueFactory<>("title") );
    	colWriter.setCellValueFactory( new PropertyValueFactory<>("writer") );
    	colCreatedAt.setCellValueFactory( new PropertyValueFactory<>("createdAt") );
    	colUpdatedAt.setCellValueFactory( new PropertyValueFactory<>("updatedAt") );
    	
    	// 테이블 뷰에 데이터 추가하기
    	// FXCollection <-- Collection
    	ObservableList<Board> list = FXCollections.observableArrayList(boardList);
    	tableView.setItems(list);
    	
    	// 테이블 뷰의 더블 클릭 이벤트
    	tableView.setOnMouseClicked( new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// 더블 클릭
				if ( event.getClickCount() == 2) {
					Board board = tableView.getSelectionModel().getSelectedItem();
					System.out.println(board);
					
					// 글 번호 전달하면서 게시글 조회 화면으로 이동
					StageManager.show("UI/Read", board.getNo());
				}
				
			}
		});
    }
    
    @FXML
    void exit(ActionEvent event) {
    	Platform.exit();	// 프로그램 종료
    }

    @FXML
    void insert(ActionEvent event) {
    	StageManager.show("UI/Insert");		// 글쓰기 화면으로 이동
    }

    @FXML
    void delete(ActionEvent event) {
    	// TODO : 선택 삭제
    	ObservableList<Board> list = tableView.getItems();
    	
    	int count = 0;
    	for (int i = 0; i < list.size(); i++) {
			Board board = list.get(i);
			// 체크 여부 확인
			if( board.getCheck().isSelected() )	{
				count += boardService.delete( board.getNo() );
			}
		}
    	System.out.println(count + "건 게시글 삭제 완료!");
    	
    	if ( count > 0 ) {
    		boardList = boardService.list();
    		ObservableList<Board> newList = FXCollections.observableArrayList(boardList);
    		tableView.setItems(newList);
    	}
    }
    
    @FXML
    void check(ActionEvent event) {
    	ObservableList<Board> list = tableView.getItems();
    	
    	if ( checkBox.isSelected() ) {
    		System.out.println("전체 체크");
        	for (int i = 0; i < list.size(); i++) {
    			Board board = list.get(i);
    			board.getCheck().setSelected(true);
    		}
    	} else {
    		System.out.println("체크 해제");
        	for (int i = 0; i < list.size(); i++) {
    			Board board = list.get(i);
    			board.getCheck().setSelected(false);
    		}
    	}
    }
}
