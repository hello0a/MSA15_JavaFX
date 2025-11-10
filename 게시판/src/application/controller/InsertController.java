package application.controller;

import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import application.util.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertController {

    @FXML private TextField inputTitle;
    @FXML private TextField inputWriter;
    @FXML private TextArea inputContent;

    BoardService boardService = new BoardServiceImpl();
    
    @FXML
    void insert(ActionEvent event) {
    	String title = inputTitle.getText();
    	String writer = inputWriter.getText();
    	String content = inputContent.getText();
    	
    	if ( title.isBlank() || writer.isBlank() ) {
    		Alert alert = new Alert(Alert.AlertType.WARNING);
    		alert.setTitle("입력 오류");
    		alert.setHeaderText("필수 항목 누락");
    		alert.setContentText("제목과 작성자는 반드시 입력해야합니다.");
    		alert.showAndWait();
    		return;
    	}
    	
    	Board board = new Board(title, writer, content);
    	// 데이터 등록 요청
    	int result = boardService.insert(board);
    	
    	if ( result ==  0 ) {
    		Alert alert = new Alert(Alert.AlertType.WARNING);
    		alert.setTitle("등록 실패");
    		alert.setHeaderText("게시글 등록 실패");
    		alert.setContentText("게시글 등록에 실패했습니다.");
    		alert.showAndWait();
    	} else {
    		StageManager.show("Main");
    	}
    }

    @FXML
    void list(ActionEvent event) {
    	StageManager.show("Main");		// 게시글 목록 화면으로 이동
    }

}
