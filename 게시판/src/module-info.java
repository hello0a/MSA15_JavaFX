module 게시판 {
	requires javafx.controls;
	requires javafx.fxml;
	requires lombok;
	requires java.sql;
	
	// controller 에서 fxml 모듈을 사용하도록 열어준다.
	opens application.controller to javafx.fxml;
	// DTO 에서 base 모듈을 사용하도록 열어준다.
	opens application.DTO to javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
