package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CController implements DataReceiver{
	
	private Object receiveData;

    @FXML private TextField input;
    
    @FXML
    void initialize() {
    	// 1번
    	System.out.println("# initialize #");
    	System.out.println("receiveData : " + this.receiveData);
    	
    	// 3번
    	Platform.runLater( () -> {
    		System.out.println("# runlater() #");
    		System.out.println("receiveData : " + this.receiveData);
    	});
    }

    // 2번
	@Override
	public void receiveData(Object data) {
		if ( data instanceof String text ) {
			input.setText( text );			
		}
		this.receiveData = data;
		System.out.println("# receiveData() #");
		System.out.println("receiveData : " + receiveData);
	}
	
	@FXML
	void to(ActionEvent event) {
		
	}

}
