package application;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * StageManager
 * : FXML 로딩(읽기)
 * : 화면 전환
 * 해당 기능을 담당하는 클래스
 */
public class StageManager {

	private static Stage stage;
	private static Scene scene;
	private static final Map<String, Object> controllers = new HashMap<>();
	
	/**
	 * 최초 Stage 등록
	 * @param primaryStage
	 */
	public static void initialize(Stage primaryStage) {
		stage = primaryStage;
		scene = new Scene( new StackPane());
		stage.setScene(scene);
	}
	/**
	 * 화면 이동
	 * - FXML 파일을 로드하여 root 컨테이너 교체
	 * @param fxml
	 */
	public static void show(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(StageManager.class.getResource("/application/" + fxml + ".fxml"));
			Parent root = loader.load();
			controllers.put(fxml, loader.getController());
			scene.setRoot(root);
			stage.sizeToScene();
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("FXML 로드 실패 - 화면 이동 실패");
		}
	}
	/**
	 * 화면 이동
	 * : 새로운 Scene으로 전환하여 화면 이동
	 * @param fxml
	 */
	public static void switchScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(StageManager.class.getResource("/application/" + fxml + ".fxml"));
			Parent root = loader.load();
			controllers.put(fxml, loader.getController());
			
			Scene newScene = new Scene(root);
			stage.setScene(newScene);
			stage.sizeToScene();
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("FXML 로드 실패 - 화면 이동 실패");
		}
	}
	/**
	 * 특정 FXML 컨트롤러를 타입변환하여 가져오기
	 * @param <T>
	 * @param fxml
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getController(String fxml) {
		return (T) controllers.get(fxml);
	}
	public static Stage getStage() {
		return stage;
	}
}
