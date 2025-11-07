package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MainController {

    @FXML private Button button;
    @FXML private ImageView img;
    @FXML private Label menu;
    
    // 메뉴 리스트
    private static List<Menu> MENU_LIST;
    // 타이머1 - 0.05 초마다 메뉴변경 타이머
    private Timeline rotate = null; 
    // 타이머2 - 3초 뒤 랜덤메뉴를 고르는 타이머
    private Timeline stop = null;
    
    /*
     * FXML 이 로딩될 때 초기화하는 메서드
     * * 데이터 초기화
     * * 이벤트 등록
     */
    @FXML
    public void initialize() {
    	// 데이터 초기화
    	initData();
    	// 타이밍 세팅
    	initTimer();
    }
    /**
     * 데이터 초기화
     */
    void initData() {
    	MENU_LIST = new ArrayList<Menu>();
    	List<String> nameList 
    	= Arrays.asList(
    			"국밥","규카츠","김밥","돈까스","떡볶이",
    			"마라탕","부대찌개","삼겹살","쇼좌빙","스테이크",
    			"우동","육회","초밥","치킨","카레",
    			"텐동","파스타","피자","함박스테이크","햄버거");
    	List<String> imgList
    	= Arrays.asList(
    			"국밥.jpg","규카츠.jpg","김밥.jpg","돈까스.jpg","떡볶이.jpg",
    			"마라탕.jpg","부대찌개.jpg","삼겹살.jpg","쇼좌빙.jpg","스테이크.jpg",
    			"우동.jpg","육회.jpg","초밥.jpg","치킨.jpeg","카레.jpg",
    			"텐동.jpg","파스타.jpg","피자.jpg","함박스테이크.jpg","햄버거.jpg");
    	for (int i = 0; i < 20; i++) {
			String name = nameList.get(i);
			String img = imgList.get(i);
			MENU_LIST.add( new Menu (name, img) );
		}
    }
    /**
     * 타이머 세팅
     */
    public void initTimer() {
    	// 0.05초 마다 랜덤 타이머
    	rotate = new Timeline(
    		new KeyFrame(Duration.millis(50), e -> {
    			// 랜덤 메뉴 세팅
    			setMenu();
    		})
    	);
    	rotate.setCycleCount(Timeline.INDEFINITE);
    	// 3초 뒤에 메뉴 고르는 타이머
    	stop = new Timeline(
    			new KeyFrame ( Duration.millis(3000), e -> rotate.stop() )
    	);
    	stop.setCycleCount(1);
    }
    
    /**
     * 랜덤 메뉴 뽑기
     */
    public void setMenu() {
    	// 20개의 메뉴 요소들 중, 랜덤으로 하나 선택
    	Random random = new Random();
    	int index = random.nextInt(20);
    	Menu randomMenu = MENU_LIST.get(index);
    	String menuName = randomMenu.getName();
    	String menuImg = randomMenu.getImg();
    	// 메뉴명 라벨에 지정
    	menu.setText( menuName );
    	// 메뉴 이미지 지정
    	String filePath = getClass().getResource("/img/" + menuImg).toExternalForm();
    	img.setImage( new Image(filePath) );
    	
    }
    
    @FXML
    void random(ActionEvent event) {
    	// 이전 타이머 중지
    	rotate.stop();
    	stop.stop();
    	// 타이머 시작
    	rotate.play();
    	stop.play();
    }

}
