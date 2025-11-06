module TableView {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires lombok;
	
	opens application to javafx.base, javafx.graphics, javafx.fxml;
}
