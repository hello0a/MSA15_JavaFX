package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	private static Scene scene;
	public static Stage stage;
	/**
	 * 화면 시작 메서드
	 * @throws Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		// Main.fxml 화면 파일을 로드
		Parent container = loadFXML("Main");
		// Main.fxml 화면 레이아웃을 지정하여 Scene 생성
		scene = new Scene (container);
		
		//윈도우 제목 설정
		stage.setTitle("점메추");
		//프로그램 아이콘 지정
		String iconPath = getClass().getResource("/img/아이콘.png").toString();
		Image icon = new Image(iconPath);		// scr/img/아이콘.png 저장
		stage.getIcons().add(icon);
		
		// Stage 에 Scene 등록
		stage.setScene(scene);
		// Stage 출력
		stage.show();
	}
	/**
	 * Scene 에 FXML로 불러온 컨테이너를 지정하는 메서드
	 * @param fxml
	 * @throws Exception
	 */
	public static void setRoot(String fxml) throws Exception {
		scene.setRoot(loadFXML(fxml));
		Main.stage.sizeToScene(); // FXML에 지정한 크기로 윈도우 크기 변경
	}
	/**
	 * FXML 파일을 불러오는 메서드
	 * @param fxml
	 * @return
	 * @throws Exception
	 */
	// Parent : 모든 컨테이너의 추상 클래스
	public static Parent loadFXML(String fxml) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
