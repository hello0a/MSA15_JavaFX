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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MainController {

	@FXML private TableView<Board> tableView;
	
    @FXML private TableColumn<Board, Boolean> colCheck;
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
    }
}
