package application.controller;

import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import application.util.DataReceiver;
import application.util.StageManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateController implements DataReceiver{

    @FXML private TextField inputTitle;
    @FXML private TextField inputWriter;
    @FXML private TextArea inputContent;
    Integer no;
    BoardService boardService = new BoardServiceImpl();
    
    @FXML
    void initialize() {
    	Platform.runLater( () -> {
    		Board board = boardService.select(this.no);
    		inputTitle.setText( board.getTitle() );
    		inputWriter.setText( board.getWriter() );
    		inputContent.setText( board.getContent() );
    	});
    }

    @FXML
    void list(ActionEvent event) {
    	StageManager.show("Main");		// 게시글 목록으로 이동
    }
    

    @FXML
    void update(ActionEvent event) {
    	String title = inputTitle.getText();
    	String writer = inputWriter.getText();
    	String content = inputContent.getText();
    			
		if (title.isBlank() || writer.isBlank()) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("입력 오류");
			alert.setHeaderText("필수 항목 누락");
			alert.setContentText("제목과 작성자는 반드시 입력해야합니다.");
			alert.showAndWait();
			return;
		}

		Board board = new Board(title, writer, content);
		board.setNo(this.no);
		// 데이터 수정 요청
		int result = boardService.update(board);

		if (result == 0) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("수정 실패");
			alert.setHeaderText("게시글 수정 실패");
			alert.setContentText("게시글 수정을 실패했습니다.");
			alert.showAndWait();
		} else {
			StageManager.show("Main");
		}
	}

    @FXML
    void delete(ActionEvent event) {
    	Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    	confirm.setTitle("게시글 삭제");
    	confirm.setHeaderText("정말로 삭제하겠습니다?");
    	confirm.setContentText("이 작업은 되돌릴 수 없습니다.");
    	
    	confirm.showAndWait().ifPresent( response -> {
    		// 확인 클릭
    		if( response == ButtonType.OK ) {
    			int result = boardService.delete(this.no);
    			if( result == 0 ) {
    				Alert fail = new Alert(Alert.AlertType.ERROR);
    				fail.setTitle("삭제 실패");
    				fail.setHeaderText("게시글 삭제 실패");
    				fail.setContentText("삭제 처리 중 오류가 발생했습니다.");
    				fail.showAndWait();
    			} else {
    				StageManager.show("Main");
    			}
    		}
    	});
    }
    
	@Override
	public void receiveData(Object data) {
		this.no = (Integer) data;
	}

}
